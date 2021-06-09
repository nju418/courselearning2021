package cn.seecoder.courselearning.controller.post;

import cn.seecoder.courselearning.service.post.ReplyNoticeService;
import cn.seecoder.courselearning.vo.post.ReplyNoticeVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/reply_notice")
public class ReplyNoticeController {

    @Resource
    ReplyNoticeService replyNoticeService;

    @GetMapping("/{userId}")
    public List<ReplyNoticeVO> getReplyNoticesByUserId(@PathVariable Integer userId){
        return replyNoticeService.selectByUserId(userId);
    }


}
