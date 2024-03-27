package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findCategoryByCategoryId(Integer id);

}
