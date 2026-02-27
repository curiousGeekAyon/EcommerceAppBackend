package com.Ecommerce.Backend.Service.ProductService;

import DTO.ProductDto;
import com.Ecommerce.Backend.Controller.ProductController;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    public List<ProductDto> getAllProductByCategoryId(int categoryId) throws IOException;
    public ProductDto getProductById(int Id) throws IOException;
}
