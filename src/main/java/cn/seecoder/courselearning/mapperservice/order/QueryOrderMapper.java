package cn.seecoder.courselearning.mapperservice.order;

import cn.seecoder.courselearning.po.order.CourseOrder;
import org.apache.ibatis.annotations.Param;

public interface QueryOrderMapper {

    CourseOrder queryMostRecentOrder(@Param("userId") Integer uid,@Param("courseId")  Integer courseId);

    CourseOrder getByPrimaryKey(Integer orderId);
}
