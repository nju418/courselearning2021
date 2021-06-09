package cn.seecoder.courselearning.vo.post;

import cn.seecoder.courselearning.po.post.Reply;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class ReplyVO {

    private Integer id;

    private Integer postId;

    private Integer userId;

    private Integer replyId;

    private String content;

    private Date createTime;

    public ReplyVO(@NonNull Reply reply){
        id = reply.getId();
        postId = reply.getPostId();
        userId = reply.getUserId();
        replyId = reply.getReplyId();
        content = reply.getContent();
        createTime = reply.getCreateTime();
    }
}
