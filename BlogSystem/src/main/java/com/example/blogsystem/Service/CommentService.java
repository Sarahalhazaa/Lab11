package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CommentRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {

        User u = userRepository.findUserByUserId(comment.getUserId());
        if (u==null){
            throw new ApiException(" User Id not found");
        }
        Post p = postRepository.findPostByPostId(comment.getPostId());
        if (p==null){
            throw new ApiException("Post Id not found");
        }
        commentRepository.save(comment);
    }

    public void updateComment(Integer id, Comment comment) {
        Comment comment1 = commentRepository.findCommentByCommentId(id);
        if(comment1==null) {
            throw new ApiException("id not found");
        }
        User u = userRepository.findUserByUserId(comment.getUserId());
        if (u==null){
            throw new ApiException(" User Id not found");
        }
        Post p = postRepository.findPostByPostId(comment.getPostId());
        if (p==null){
            throw new ApiException("Post Id not found");
        }
        comment1.setContent(comment.getContent());
        comment1.setPostId(comment.getPostId());
        comment1.setUserId(comment.getUserId());
        comment1.setCommentDate(comment.getCommentDate());
        commentRepository.save(comment1);

    }

    public void deleteComment(Integer id) {
        Comment comment1 = commentRepository.findCommentByCommentId(id);
        if (comment1 == null) {
            throw new ApiException("id not found");
        }
       commentRepository.delete(comment1);
    }
    //---------------------------  end CRUD  ---------------------------------
    public List<Comment> getCommentByPostId(Integer PostId) {
        List<Comment> comments1 = commentRepository.findCommentsByPostId(PostId);
        if (comments1 == null) {
            throw new ApiException("Post Id not found");
        }
        return comments1;
    }


    public List<Comment> getCommentByUserId(Integer userId) {
        List<Comment> comments1 = commentRepository.findCommentsByUserId(userId);
        if (comments1 == null) {
            throw new ApiException("user Id not found");
        }
        return comments1;

    }

    //endPoint (9)    ترجع جميع تعليقات اليوزر في تاريخ معين
    public List<Comment> getComment(Integer userId , LocalDate commentDate) {
        List<Comment> comments1 = commentRepository.findComment(userId,commentDate);
        if (comments1 == null) {
            throw new ApiException("not found");
        }
        return comments1;

    }

}
