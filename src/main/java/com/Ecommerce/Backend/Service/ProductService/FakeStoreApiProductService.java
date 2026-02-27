package com.Ecommerce.Backend.Service.ProductService;

import DTO.ProductDto;
import com.Ecommerce.Backend.Gateway.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service

public class FakeStoreApiProductService implements ProductService{

    @Autowired
    ProductGateway productGateway;
    @Override
    public List<ProductDto> getAllProductByCategoryId(int categoryId) throws IOException {
        return productGateway.getAllProductsByCategoryId(categoryId);
    }

    @Override
    public ProductDto getProductById(int Id) throws IOException {
        return productGateway.getProductById(Id);
    }
}
