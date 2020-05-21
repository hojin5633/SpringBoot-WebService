package com.jojoldu.book.springboot.web;

//import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {  //Model은 서버 template엔진에서 사용할 수 있는 객체 저장
        model.addAttribute("posts", postsService.findAllDesc());//findAllDesc()의 결과를 posts로 index.mustache에 전달
//        SessionUser user = (SessionUser)httpSession.getAttribute("user");
        //Index method 외의 다른 메소드에서 세션이 필요할경우 그때마다 httpSession에서 값을 가져와야 함 --> 불필요한 반복
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){  //수정 화면을 연결할 controller
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);    //post로 posts-update에게 넘겨줬기 때문에
                                                        //posts-update에서 post.id로 접근 가능
        return "posts-update";
    }
}
