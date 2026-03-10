package com.Ecommerce.Backend.Gateway;

import DTO.APICategoryDto;
import DTO.APIProductDto;
import DTO.CategoryDto;
import DTO.ProductDto;
import com.Ecommerce.Backend.API.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("retrofit")
public class FakeApiCategoryGateway implements CategoryGateway {

    @Autowired
    FakeStoreCategoryApi fakeStoreCategoryApi;
    @Override
    public List<CategoryDto> getAllCategory() throws IOException {
       List<APICategoryDto>categoryListFromApi=fakeStoreCategoryApi.getAllCategories().execute().body();
        assert categoryListFromApi != null;
        return convertToCategoryDTOs(categoryListFromApi);
    }

    private List<CategoryDto> convertToCategoryDTOs(List<APICategoryDto> categoryListFromApi) {
        List<CategoryDto>resultList=new ArrayList<>();
        for(APICategoryDto apiDto:categoryListFromApi)
        {
            resultList.add(CategoryDto.builder().id(apiDto.getId()).name(apiDto.getName()).imageUrl(apiDto.getImage()).build());
        }
        return resultList;
    }

}
