package cn.seecoder.courselearning.serviceimpl.coupon;

import cn.seecoder.courselearning.po.order.CourseOrder;

public interface QueryOrderService {

    CourseOrder queryMostRecentOrder(Integer uid, Integer courseId);

    CourseOrder getByPrimaryKey(Integer orderId);
}
