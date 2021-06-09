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

    //对回复内容的引用
    private ReplyVO reply;

    private String content;

    private Date createTime;

    public ReplyVO(@NonNull Reply reply){
        id = reply.getId();
        postId = reply.getPostId();
        userId = reply.getUserId();
        content = reply.getContent();
        createTime = reply.getCreateTime();
    }

}
