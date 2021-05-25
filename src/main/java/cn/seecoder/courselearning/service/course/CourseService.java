package cn.seecoder.courselearning.service.course;

import cn.seecoder.courselearning.po.course.Course;
import cn.seecoder.courselearning.vo.course.CourseVO;
import cn.seecoder.courselearning.vo.ResultVO;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface CourseService {
    // 根据关键字，分页查询课程
    PageInfo<CourseVO> getCourses(Integer currPage, Integer pageSize, Integer uid, String key);
    // 根据分类，分页查询课程
    PageInfo<CourseVO> getCoursesByType(Integer currPage, Integer pageSize, Integer uid, String type);
    // 分页获取热门课程列表
    PageInfo<CourseVO> getHotCourses(Integer currPage, Integer pageSize, Integer uid);
    // 查询用户所有已购买的课程
    List<CourseVO> getBoughtCourses(Integer uid);
    // 查询教师所有可管理的课程
    List<CourseVO> getManageableCourses(Integer uid);
    // 查询单门课程
    CourseVO getCourse(Integer courseId, Integer uid);
    // 创建课程
    ResultVO<CourseVO> createCourse(CourseVO courseVO);

    Course getByPrimaryKey(Integer courseId);

    //用户取消点赞
    void cancelCourseLikes(Integer courseId, Integer userId);

    //用户点赞
    void addCourseLikes(Integer courseId, Integer userId);

    //查看用户是否已点赞
    Boolean isCourseLiked(Integer courseId, Integer userId);

    //返回课程点赞数
    int getCountOfCourseLikes(Integer courseId);
}