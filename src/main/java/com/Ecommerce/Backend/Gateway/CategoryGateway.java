package com.Ecommerce.Backend.Gateway;

import DTO.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryGateway {
    List<CategoryDto> getAllCategory() throws IOException;
}
