package com.Ecommerce.Backend.Gateway;

import DTO.APICategoryDto;
import DTO.APIProductDto;
import DTO.CategoryDto;
import DTO.ProductDto;
import com.Ecommerce.Backend.API.FakeStoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeApiGateway implements CategoryGateway, ProductGateway {

    @Autowired
    FakeStoreApi fakeStoreApi;
    @Override
    public List<CategoryDto> getAllCategory() throws IOException {
       List<APICategoryDto>categoryListFromApi=fakeStoreApi.getAllCategories().execute().body();
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
    public List<ProductDto>getAllProductsByCategoryId(int categoryId) throws IOException {
        List<APIProductDto>apiProductDtoList=fakeStoreApi.getAllItemsByCategoryId(categoryId).execute().body();
        assert apiProductDtoList != null;
        return convertToProductDto(apiProductDtoList);
    }
    private List<ProductDto>convertToProductDto(List<APIProductDto>dtoList)
    {
        List<ProductDto>resultList=new ArrayList<>();
        for(APIProductDto apiProductDto:dtoList)
        {
            resultList.add(APIProductDtotoProductDtoConverter(apiProductDto));
        }
        return resultList;
    }
    public ProductDto getProductById(int Id) throws IOException {
        APIProductDto apiProductDto=fakeStoreApi.getProductById(Id).execute().body();
        assert apiProductDto != null;
        return APIProductDtotoProductDtoConverter(apiProductDto);
    }

    private ProductDto APIProductDtotoProductDtoConverter(APIProductDto apiProductDto) {
        return ProductDto.builder()
                .id(apiProductDto.getId())
                .title(apiProductDto.getTitle())
                .price(apiProductDto.getPrice())
                .description(apiProductDto.getDescription())
                .categoryId(apiProductDto.getCategory().getId())
                .images(apiProductDto.getImages())
                .build();
    }
}
