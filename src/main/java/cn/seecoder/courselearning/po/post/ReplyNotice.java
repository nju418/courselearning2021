package cn.seecoder.courselearning.po.post;

import cn.seecoder.courselearning.vo.post.ReplyNoticeVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import lombok.Data;
import lombok.NonNull;

@Data
public class ReplyNotice {

    private Integer id;

    private Integer userId;

    private Integer replyId;

    public ReplyNotice(){}

    public ReplyNotice(@NonNull ReplyNoticeVO replyNoticeVO){
        id = replyNoticeVO.getId();
        userId = replyNoticeVO.getUserId();
        replyId = replyNoticeVO.getReply().getId();
    }

    public ReplyNotice(@NonNull ReplyVO replyVO){
        id = replyVO.getId();
        userId = replyVO.getReply().getUserId();
        replyId = replyVO.getId();
    }

}
