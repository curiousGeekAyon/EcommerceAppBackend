package com.Ecommerce.Backend.Gateway;

import DTO.APICategoryDto;
import DTO.CategoryDto;
import com.Ecommerce.Backend.API.FakeStoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeApiGateway implements CategoryGateway {

    @Autowired
    FakeStoreApi fakeStroeApi;
    @Override
    public List<CategoryDto> getAllCategory() throws IOException {
       List<APICategoryDto>categoryListFromApi=fakeStroeApi.getAllCategories().execute().body();
        assert categoryListFromApi != null;
        return convertedDTOs(categoryListFromApi);
    }

    private List<CategoryDto> convertedDTOs(List<APICategoryDto> categoryListFromApi) {
        List<CategoryDto>resultList=new ArrayList<>();
        for(APICategoryDto apiDto:categoryListFromApi)
        {
            resultList.add(CategoryDto.builder().id(apiDto.getId()).name(apiDto.getName()).imageUrl(apiDto.getImage()).build());
        }
        return resultList;
    }
}
