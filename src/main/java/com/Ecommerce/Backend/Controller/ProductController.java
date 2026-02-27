package com.Ecommerce.Backend.Controller;

import DTO.ProductDto;
import com.Ecommerce.Backend.Service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping(params = "categoryid")
    public List<ProductDto> getAllProductsByCategory(@RequestParam int categoryid) throws IOException {
        return productService.getAllProductByCategoryId(categoryid);
    }
    @GetMapping("{productId}")
    public ProductDto getProductsById(@PathVariable int productId) throws IOException {
        return productService.getProductById(productId);
    }
}
