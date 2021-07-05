package cn.seecoder.courselearning.serviceimpl.post;


import cn.seecoder.courselearning.mapperservice.post.ReplyNoticeMapper;
import cn.seecoder.courselearning.po.post.ReplyNotice;
import cn.seecoder.courselearning.service.post.ReplyNoticeService;
import cn.seecoder.courselearning.service.post.ReplyService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.post.ReplyNoticeVO;
import cn.seecoder.courselearning.vo.post.ReplyVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyNoticeServiceImpl implements ReplyNoticeService {


    @Resource
    ReplyNoticeMapper replyNoticeMapper;
    @Resource
    ReplyService replyService;

    @Override
    public ResultVO<ReplyNoticeVO> deleteByPrimaryKey(Integer id) {
        replyNoticeMapper.deleteByPrimaryKey(id);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "删除通知成功");
    }

    @Override
    public ResultVO<ReplyNoticeVO> insert(ReplyNotice replyNotice) {
        replyNoticeMapper.insert(replyNotice);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "添加通知成功");
    }

    @Override
    public List<ReplyNoticeVO> selectByUserId(Integer userId) {
        List<ReplyNotice> replyNoticeList = replyNoticeMapper.selectByUserId(userId);
        List<ReplyNoticeVO> replyNoticeVOList = new ArrayList<ReplyNoticeVO>();
        for(ReplyNotice replyNotice: replyNoticeList){
            ReplyNoticeVO replyNoticeVO = new ReplyNoticeVO(replyNotice);
            ReplyVO replyVO= replyService.getReplyBYReplyId(replyNotice.getId());
            replyNoticeVO.setReply(replyVO);
            replyNoticeVOList.add(replyNoticeVO);
        }
        return replyNoticeVOList;
    }
}
