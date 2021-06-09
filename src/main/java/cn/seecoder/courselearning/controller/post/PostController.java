package cn.seecoder.courselearning.controller.post;

import cn.seecoder.courselearning.service.post.PostService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseVO;
import cn.seecoder.courselearning.vo.post.PostVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    PostService postService;

    /**
     *
     * @param uid 用户id,用来判断用户是否能回复
     * @param sortedType 排序方式,1为按创建时间排序，2为按最新回复时间排序
     * */
    @GetMapping("/{courseId}/page")
    public PageInfo<PostVO> getPostsByCourseId(@RequestParam(required = false, defaultValue = "") Integer uid,
                                               @RequestParam(required = false, defaultValue = "1") Integer sortedType,
                                               @PathVariable Integer courseId, @PathVariable Integer page){
        return postService.getPostsByCourseId(page, Constant.POST_PAGE_SIZE, courseId, sortedType, uid);
    }

    @PostMapping("/create")
    public ResultVO<PostVO> createPost(@RequestBody PostVO postVO) {
        return postService.createPost(postVO);
    }
}
