package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/vi/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/get")
    public ResponseEntity getComment(){
        return ResponseEntity.status(200).body(commentService.getComment());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.ok().body(new ApiResponse("Comment added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.ok().body(new ApiResponse("Comment Update"));

    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){

       commentService.deleteComment(id);
        return ResponseEntity.ok().body(new ApiResponse("Comment Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    @GetMapping("/getByPostId/{postId}")
    public ResponseEntity getCommentPostId(@PathVariable Integer postId) {
        return ResponseEntity.status(200).body(commentService.getCommentByPostId(postId));
    }

    @GetMapping("/getCommentByUserId/{userId}")
    public ResponseEntity getCommentByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(commentService.getCommentByUserId(userId));
    }

    @GetMapping("/getComment/{userId}/{commentDate}")
    public ResponseEntity getComment(@PathVariable Integer userId, LocalDate commentDate) {
        return ResponseEntity.status(200).body(commentService.getComment(userId,commentDate));
    }
}
