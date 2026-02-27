package com.Ecommerce.Backend.Gateway;

import DTO.ProductDto;

import java.io.IOException;
import java.util.List;

public interface ProductGateway {
   List<ProductDto>getAllProductsByCategoryId(int categoryId) throws IOException;
   public ProductDto getProductById(int Id) throws IOException ;

}
