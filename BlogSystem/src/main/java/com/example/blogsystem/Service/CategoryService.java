package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        Category category1 = categoryRepository.findCategoryByCategoryId(id);
        if(category1==null) {
            throw new ApiException("id not found");
        }
        category1.setName(category.getName());
        categoryRepository.save(category1);

    }

    public void deleteCategory(Integer id) {
        Category category1 = categoryRepository.findCategoryByCategoryId(id);
        if (category1 == null) {
            throw new ApiException("id not found");
        }
       categoryRepository.delete(category1);
    }
    //---------------------------  end CRUD  ---------------------------------
}
