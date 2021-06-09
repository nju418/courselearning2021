package cn.seecoder.courselearning.service.post;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import com.github.pagehelper.PageInfo;

public interface PostService {

    // 根据关键字，分页查询帖子,按创建时间排序
    PageInfo<PostVO> getPostsByCourseId(Integer currPage, Integer pageSize, Integer courseId, Integer sortedType,Integer uid);

    //发布帖子
    ResultVO<PostVO> createPost(PostVO postVO);

    //更新帖子最新回复时间
    ResultVO<PostVO> updateLatestReplyTime(PostVO postVO);
}
