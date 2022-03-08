package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.time.LocalDateTime;

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

    /** Обновление Темы*/
    @GetMapping("/update")
    public String update(@RequestParam(value = "id", required = false) String id, Model model) {
        model.addAttribute("updatePost", postService.getPostById(Long.parseLong(id)));
        return "edit";
    }

    /** Обновление Темы*/
    @PostMapping("/updateItem")
    public String update(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/index";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute Post post) {
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/index";
    }
}
