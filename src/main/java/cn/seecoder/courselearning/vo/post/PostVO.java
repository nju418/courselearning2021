package cn.seecoder.courselearning.vo.post;

import cn.seecoder.courselearning.po.post.Post;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class PostVO {

    private Integer id;

    private Integer userId;

    private Integer courseId;

    private String title;

    private String content;

    private Date createTime;

    private Date latestReplyTime;

    public PostVO(@NonNull Post post){
        id = post.getId();
        userId = post.getUserId();
        courseId = post.getCourseId();
        title = post.getTitle();
        content = post.getContent();
        createTime = post.getCreateTime();
        latestReplyTime = post.getLatestReplyTime();
    }


}
