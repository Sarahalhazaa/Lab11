package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findCommentByCommentId(Integer id);
    List<Comment> findCommentsByPostId(Integer postId);
    List<Comment> findCommentsByUserId(Integer userId);

    @Query("select a from Comment a where a.userId=?1 and a.commentDate=?2")
    List<Comment> findComment(Integer userId , LocalDate commentDate );
}
