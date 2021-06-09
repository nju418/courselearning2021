package cn.seecoder.courselearning.serviceimpl.post;

import cn.seecoder.courselearning.service.post.PostService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import com.github.pagehelper.PageInfo;

public class PostServiceImpl implements PostService {
    @Override
    public PageInfo<PostVO> getPostsByCourseId(Integer currPage, Integer pageSize, Integer courseId) {
        return null;
    }

    @Override
    public ResultVO<PostVO> createCourse(PostVO postVO) {
        return null;
    }
}
