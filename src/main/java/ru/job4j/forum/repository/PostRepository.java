package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Modifying
    @Query(value = "update Post p set p.name = ?1 where p.id = ?2")
    void update(String name, long id);
}
