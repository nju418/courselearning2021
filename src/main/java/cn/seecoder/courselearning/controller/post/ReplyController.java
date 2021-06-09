package cn.seecoder.courselearning.controller.post;


import cn.seecoder.courselearning.service.post.ReplyService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    ReplyService replyService;

    /**
     *
     * @param postid postid,用来查询帖子相应回复列表
     * 按回复时间排序回复
     * */
    @GetMapping("/{postId}/{page}")
    public PageInfo<ReplyVO> getRepliesByPostId(@PathVariable Integer postid, @PathVariable Integer page){
        return replyService.getRepliesByPostId(postid,page,Constant.REPLY_PAGE_SIZE);
    }

    @PostMapping("/create")
    public ResultVO<ReplyVO> createPost(@RequestBody ReplyVO replyVO) {
        return replyService.createReply(replyVO);
    }
}
