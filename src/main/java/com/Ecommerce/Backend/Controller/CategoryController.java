package com.Ecommerce.Backend.Controller;

import DTO.CategoryDto;
import DTO.ProductDto;
import com.Ecommerce.Backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    CategoryService iCategoryService;
    @GetMapping
    public List<CategoryDto>getCategories() throws IOException {
       return iCategoryService.getAllCategories();
    }

}
