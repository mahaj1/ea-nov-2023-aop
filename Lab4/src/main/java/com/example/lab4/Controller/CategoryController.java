package com.example.lab4.Controller;

import com.example.lab4.Model.Category;
import edu.miu.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id)
    {
        return categoryService.findById(id);
    }
    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable int id){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

}