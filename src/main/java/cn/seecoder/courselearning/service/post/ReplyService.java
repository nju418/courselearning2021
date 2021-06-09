package cn.seecoder.courselearning.service.post;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import com.github.pagehelper.PageInfo;

public interface ReplyService {
    // 分页查询帖子回复，按回复时间排序展示
    PageInfo<ReplyVO> getRepliesByPostId(Integer postId,Integer currPage, Integer pageSize);

    //发布回复
    ResultVO<ReplyVO> createReply(ReplyVO replyVO);
}
