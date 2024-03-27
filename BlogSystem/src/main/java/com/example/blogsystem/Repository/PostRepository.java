package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findPostByPostId(Integer id);
    List<Post> findPostsByCategoryId(Integer CategoryId );

    List<Post> findPostsByUserId(Integer userId);

    @Query("select a from Post a where a.publishDate=?1")
    List<Post> findPostsByPublishDate(LocalDate publishDate);

    @Query("select a from Post a where a.title=?1")
    List<Post> findPostsByTitle(String title);


}
