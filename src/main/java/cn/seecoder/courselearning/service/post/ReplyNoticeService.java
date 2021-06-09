package cn.seecoder.courselearning.service.post;

import cn.seecoder.courselearning.po.post.ReplyNotice;

import java.util.List;

public interface ReplyNoticeService {

    int deleteByPrimaryKey(Integer id);

    int insert(ReplyNotice replyNotice);

    List<ReplyNotice> selectByUserId(Integer userId);
}
