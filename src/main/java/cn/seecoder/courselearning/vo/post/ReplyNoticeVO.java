package cn.seecoder.courselearning.vo.post;

import cn.seecoder.courselearning.po.post.ReplyNotice;
import lombok.Data;
import lombok.NonNull;

@Data
public class ReplyNoticeVO {
    private Integer id;

    private Integer userId;

    private ReplyVO reply;

    public ReplyNoticeVO(){}

    public ReplyNoticeVO(@NonNull ReplyNotice replyNotice){
        id = replyNotice.getId();
        userId = replyNotice.getUserId();
    }
}
