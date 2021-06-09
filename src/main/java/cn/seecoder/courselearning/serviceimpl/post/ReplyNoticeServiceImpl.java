package cn.seecoder.courselearning.serviceimpl.post;


import cn.seecoder.courselearning.mapperservice.post.ReplyNoticeMapper;
import cn.seecoder.courselearning.po.post.ReplyNotice;
import cn.seecoder.courselearning.service.post.ReplyNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyNoticeServiceImpl implements ReplyNoticeService {

    @Resource
    ReplyNoticeMapper replyNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        replyNoticeMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(ReplyNotice replyNotice) {
        replyNoticeMapper.insert(replyNotice);
        return 0;
    }

    @Override
    public List<ReplyNotice> selectByUserId(Integer userId) {
        return replyNoticeMapper.selectByUserId(userId);
    }
}
