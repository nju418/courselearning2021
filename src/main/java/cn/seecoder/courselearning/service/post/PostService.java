package cn.seecoder.courselearning.service.post;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import com.github.pagehelper.PageInfo;

public interface PostService {

    // 根据关键字，分页查询帖子
    PageInfo<PostVO> getPostsByCourseId(Integer currPage, Integer pageSize, Integer courseId);

    //发布帖子
    ResultVO<PostVO> createCourse(PostVO postVO);
}
