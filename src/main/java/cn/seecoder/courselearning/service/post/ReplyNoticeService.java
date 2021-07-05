package cn.seecoder.courselearning.service.post;

import cn.seecoder.courselearning.po.post.ReplyNotice;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.ReplyNoticeVO;

import java.util.List;

public interface ReplyNoticeService {

    ResultVO<ReplyNoticeVO> deleteByPrimaryKey(Integer id);

    ResultVO<ReplyNoticeVO> insert(ReplyNotice replyNotice);

    List<ReplyNoticeVO> selectByUserId(Integer userId);
}
