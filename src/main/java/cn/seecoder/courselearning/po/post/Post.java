package cn.seecoder.courselearning.po.post;

import cn.seecoder.courselearning.vo.post.PostVO;
import lombok.NonNull;

import java.util.Date;

public class Post {

    private Integer id;

    private Integer userId;

    private Integer courseId;

    private String title;

    private String content;

    private Date createTime;

    private Date latestReplyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getLatestReplyTime() {
        return latestReplyTime;
    }

    public void setLatestReplyTime(Date latestReplyTime) {
        this.latestReplyTime = latestReplyTime;
    }


    public Post(@NonNull PostVO postVO){
        this.id = postVO.getId();
        this.userId = postVO.getUserId();
        this.courseId = postVO.getCourseId();
        this.title = postVO.getTitle();
        this.content = postVO.getContent();
        this.createTime = postVO.getCreateTime();
        this.latestReplyTime = postVO.getLatestReplyTime();
    }
}
