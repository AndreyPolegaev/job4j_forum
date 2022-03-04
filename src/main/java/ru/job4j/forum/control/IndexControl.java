package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class IndexControl {

    private final PostService postService;
    private final UserService userService;

    public IndexControl(PostService ps, UserService us) {
        this.postService = ps;
        this.userService = us;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
            model.addAttribute("users", userService.getAllUsers());
            return "users";
    }

}
