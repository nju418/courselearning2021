package cn.seecoder.courselearning.mapperservice.post;

import cn.seecoder.courselearning.po.post.Reply;

import java.util.List;

public interface ReplyMapper {
    int insert(Reply reply);

    List<Reply> selectByPostId(Integer postId);

    Reply selectByReplyId(Integer replyId);
}
