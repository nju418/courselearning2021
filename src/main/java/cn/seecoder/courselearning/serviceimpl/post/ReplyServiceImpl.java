package cn.seecoder.courselearning.serviceimpl.post;

import cn.seecoder.courselearning.mapperservice.post.ReplyMapper;
import cn.seecoder.courselearning.service.post.ReplyService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;

public class ReplyServiceImpl implements ReplyService {
    @Resource
    ReplyMapper replyMapper;

    @Override
    public PageInfo<ReplyVO> getRepliesByPostId(Integer postId, Integer currPage, Integer pageSize) {
        return null;
    }

    @Override
    public ResultVO<ReplyVO> createReply(ReplyVO replyVO) {
        return null;
    }
}
