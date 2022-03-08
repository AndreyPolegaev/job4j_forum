package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAllPosts() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getPostById(long id) {
        return posts.findById(id).get();
    }

    public void update(Post post) {
        posts.update(post.getName(), post.getId());
    }

    public void save(Post post) {
        post.setCreated(LocalDateTime.now());
        posts.save(post);
    }
}
