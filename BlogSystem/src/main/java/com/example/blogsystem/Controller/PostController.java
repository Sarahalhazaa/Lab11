package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/vi/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/get")
    public ResponseEntity getPost(){
        return ResponseEntity.status(200).body(postService.getPost());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.addPost(post);
        return ResponseEntity.ok().body(new ApiResponse("Post added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id,post);

        return ResponseEntity.ok().body(new ApiResponse("Post Update"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){

       postService.deletePost(id);
        return ResponseEntity.ok().body(new ApiResponse("Post Deleted"));
    }

    //---------------------------  end CRUD  ---------------------------------

    @GetMapping("/getByCategoryId/{CategoryId}")
    public ResponseEntity getPostsByCategoryId(@PathVariable Integer CategoryId) {
        return ResponseEntity.status(200).body(postService.getPostByCategoryId(CategoryId));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity getPostsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(postService.getPostsByUserId(userId));
    }

    @GetMapping("/getByPublishDate/{publishDate}")
    public ResponseEntity getPostsByPublishDate(@PathVariable LocalDate publishDate) {
        return ResponseEntity.status(200).body(postService.getPostsByPublishDate(publishDate));
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity getPostsByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.getPostsByTitle(title));
    }
}
