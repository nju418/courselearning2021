package cn.seecoder.courselearning.serviceimpl.post;

import cn.seecoder.courselearning.mapperservice.post.ReplyMapper;
import cn.seecoder.courselearning.po.post.Post;
import cn.seecoder.courselearning.po.post.Reply;
import cn.seecoder.courselearning.po.post.ReplyNotice;
import cn.seecoder.courselearning.service.post.ReplyNoticeService;
import cn.seecoder.courselearning.service.post.ReplyService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.util.PageInfoUtil;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    ReplyMapper replyMapper;
    @Resource
    ReplyNoticeService replyNoticeService;

    @Override
    public PageInfo<ReplyVO> getRepliesByPostId(Integer postId, Integer currPage, Integer pageSize) {
        if(currPage==null || currPage<1) currPage=1;
        PageHelper.startPage(currPage, pageSize);
        List<Reply> replyList = replyMapper.selectByPostId(postId);
        //对replyList按照回复时间排序
        replyList.sort(Comparator.comparing(Reply::getCreateTime));

        PageInfo<Reply> po = new PageInfo<>(replyList);


        PageInfo<ReplyVO> result = PageInfoUtil.convert(po, ReplyVO.class);
        //检验用户是否允许回复

        return result;
    }

    @Override
    public ResultVO<ReplyVO> createReply(ReplyVO replyVO) {
        Reply reply=new Reply(replyVO);
        reply.setCreateTime(new Date());
        replyMapper.insert(reply);
        //replyNoticeService.insert(new ReplyNotice(replyVO));
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "回复创建成功");
    }

    @Override
    public ReplyVO getReplyBYReplyId(Integer replyId) {
        Reply reply=replyMapper.selectByReplyId(replyId);
        ReplyVO result=new ReplyVO(reply);
        return result;
    }
}
