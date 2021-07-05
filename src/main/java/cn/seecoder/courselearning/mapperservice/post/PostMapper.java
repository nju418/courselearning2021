package cn.seecoder.courselearning.mapperservice.post;

import cn.seecoder.courselearning.po.course.Course;
import cn.seecoder.courselearning.po.post.Post;

import java.util.List;

public interface PostMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Post post);

    int updateByPrimaryKey(Post post);

    List<Post> selectByCourseId(Integer courseId);

    Post selectByPrimaryKey(Integer id);

}
