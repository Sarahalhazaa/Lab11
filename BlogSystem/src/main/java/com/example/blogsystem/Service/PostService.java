package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CategoryRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getPost() {
        return postRepository.findAll();
    }

    public void addPost(Post post) {
        User u = userRepository.findUserByUserId(post.getUserId());
        if (u==null){
            throw new ApiException("User Id not found");
        }
        Category c = categoryRepository.findCategoryByCategoryId(post.getCategoryId());
        if (c==null){
            throw new ApiException("Category Id not found");
        }
        postRepository.save(post);
    }

    public void updatePost(Integer id,Post post) {
        Post post1 = postRepository.findPostByPostId(id);
        if(post1==null) {
            throw new ApiException("id not found");
        }
        User u = userRepository.findUserByUserId(post.getUserId());
        if (u==null){
            throw new ApiException("User Id not found");
        }
        Category c = categoryRepository.findCategoryByCategoryId(post.getCategoryId());
        if (c==null){
            throw new ApiException("Category Id not found");
        }
        post1.setCategoryId(post.getCategoryId());
        post1.setUserId(post.getUserId());
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setPublishDate(post.getPublishDate());
       postRepository.save(post1);

    }

    public void deletePost(Integer id) {
        Post post1 = postRepository.findPostByPostId(id);
        if (post1 == null) {
            throw new ApiException("id not found");
        }
        postRepository.delete(post1);
    }
    //---------------------------  end CRUD  ---------------------------------

    public List<Post> getPostByCategoryId(Integer CategoryId) {
        List<Post> post1 =  postRepository.findPostsByCategoryId(CategoryId);
        if (post1 == null) {
            throw new ApiException("Post not found");
        }
        return post1;
    }

    public List<Post> getPostsByUserId(Integer userId) {
        List<Post> post1 =  postRepository.findPostsByUserId(userId);
        if (post1 == null) {
            throw new ApiException("Post not found");
        }
        return post1;
    }

    public List<Post> getPostsByPublishDate(LocalDate publishDate) {
        List<Post> post1 = postRepository.findPostsByPublishDate(publishDate);
        if (post1 == null) {
            throw new ApiException("Post not found");
        }
        return post1;

    }

    public List<Post> getPostsByTitle(String title) {
        List<Post> post1 =  postRepository.findPostsByTitle(title);
        if (post1 == null) {
            throw new ApiException("Post not found");
        }
        return post1;
    }

}
