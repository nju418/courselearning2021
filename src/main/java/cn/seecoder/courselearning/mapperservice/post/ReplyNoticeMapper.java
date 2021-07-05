package cn.seecoder.courselearning.mapperservice.post;

import cn.seecoder.courselearning.po.post.ReplyNotice;

import java.util.List;

public interface ReplyNoticeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ReplyNotice replyNotice);

    List<ReplyNotice> selectByUserId(Integer userId);

}
