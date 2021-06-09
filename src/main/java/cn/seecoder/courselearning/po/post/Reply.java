package cn.seecoder.courselearning.po.post;

import cn.seecoder.courselearning.vo.post.ReplyVO;
import lombok.NonNull;

import java.util.Date;

public class Reply {

    private Integer id;

    private Integer postId;

    private Integer userId;

    private Integer replyId;

    private String content;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Reply(@NonNull ReplyVO replyVO){
        id = replyVO.getId();
        postId = replyVO.getPostId();
        userId = replyVO.getUserId();
        replyId = replyVO.getReply().getId();
        content = replyVO.getContent();
        createTime = replyVO.getCreateTime();
    }
}
