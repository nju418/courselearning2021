package cn.seecoder.courselearning.serviceimpl.order;

import cn.seecoder.courselearning.mapperservice.order.QueryOrderMapper;
import cn.seecoder.courselearning.po.order.CourseOrder;
import cn.seecoder.courselearning.service.order.QueryOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class QueryOrderServiceImpl implements QueryOrderService {

    @Resource
    private QueryOrderMapper queryOrderMapper;

    @Override
    public CourseOrder queryMostRecentOrder(Integer uid, Integer courseId) {
        return queryOrderMapper.queryMostRecentOrder(uid,courseId);
    }

    @Override
    public CourseOrder getByPrimaryKey(Integer orderId) {
        return queryOrderMapper.getByPrimaryKey(orderId);
    }
}
