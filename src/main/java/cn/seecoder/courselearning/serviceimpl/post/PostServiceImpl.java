package cn.seecoder.courselearning.serviceimpl.post;

import cn.seecoder.courselearning.enums.UserRole;
import cn.seecoder.courselearning.mapperservice.post.PostMapper;
import cn.seecoder.courselearning.po.course.Course;
import cn.seecoder.courselearning.po.order.CourseOrder;
import cn.seecoder.courselearning.po.post.Post;
import cn.seecoder.courselearning.po.user.User;
import cn.seecoder.courselearning.service.course.CourseService;
import cn.seecoder.courselearning.service.post.PostService;
import cn.seecoder.courselearning.service.user.UserService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.util.PageInfoUtil;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import cn.seecoder.courselearning.vo.user.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    PostMapper postMapper;
    @Resource
    CourseService courseService;

    @Override
    public PageInfo<PostVO> getPostsByCourseId(Integer currPage, Integer pageSize, Integer courseId, Integer sortedType, Integer uid) {
        if(currPage==null || currPage<1) currPage=1;
        PageHelper.startPage(currPage, pageSize);
        List<Post> postList = postMapper.selectByCourseId(courseId);
        //对postList排序
        //
        if (sortedType == 1) {
            //按照创建时间排序
            postList.sort(Comparator.comparing(Post::getCreateTime));
        } else {
            //按照最新回复时间排序
            postList.sort(Comparator.comparing(Post::getLatestReplyTime));
        }

        PageInfo<Post> po = new PageInfo<>(postList);


        PageInfo<PostVO> result = PageInfoUtil.convert(po, PostVO.class);
        //检验用户是否允许回复
        if(isAllowToReply(uid, courseId)){
            List<PostVO> voList = result.getList();
            for(PostVO vo: voList){
                vo.setIsAllowToReply(true);
            }
        }

        return result;
    }

    @Override
    public ResultVO<PostVO> createPost(PostVO postVO) {
        if(!isAllowToReply(postVO.getUserId(),postVO.getCourseId()))
            return new ResultVO<>(Constant.REQUEST_FAIL, "该用户没有权限发布帖子");
        Post post = new Post(postVO);
        post.setLatestReplyTime(new Date());
        post.setCreateTime(new Date());
        postMapper.insert(post);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "帖子发布成功");
    }
    @Override
    public ResultVO<PostVO> updateLatestReplyTime(PostVO postVO) {
        Post post = new Post(postVO);
        //更新最新回复时间
        post.setLatestReplyTime(new Date());
        postMapper.updateByPrimaryKey(post);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "帖子最新回复时间更新成功");
    }

    boolean isAllowToReply(Integer uid, Integer courseId){
        //如果学生已经购买该课程或是创建该课程的老师，则允许回复帖子
        CourseVO courseVO = courseService.getCourse(courseId, uid);
        return courseVO.isBought() || courseVO.isManageable();
    }


}
