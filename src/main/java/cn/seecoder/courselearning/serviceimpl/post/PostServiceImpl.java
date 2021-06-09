package cn.seecoder.courselearning.serviceimpl.post;

import cn.seecoder.courselearning.mapperservice.post.PostMapper;
import cn.seecoder.courselearning.po.course.Course;
import cn.seecoder.courselearning.po.post.Post;
import cn.seecoder.courselearning.service.post.PostService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.util.PageInfoUtil;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PostServiceImpl implements PostService {
    @Resource
    PostMapper postMapper;

    @Override
    public PageInfo<PostVO> getPostsByCourseId(Integer currPage, Integer pageSize, Integer courseId, Integer sortedType) {
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
        return PageInfoUtil.convert(po, PostVO.class);
    }

    @Override
    public ResultVO<PostVO> createPost(PostVO postVO) {
        Post post = new Post(postVO);
        post.setLatestReplyTime(new Date());
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


}
