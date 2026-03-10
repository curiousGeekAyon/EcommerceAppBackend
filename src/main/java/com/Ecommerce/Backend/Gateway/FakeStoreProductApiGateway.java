package com.Ecommerce.Backend.Gateway;

import DTO.APIProductDto;
import DTO.ProductDto;
import com.Ecommerce.Backend.API.FakeStoreProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("retrofit")
public class FakeStoreProductApiGateway implements  ProductGateway{

    @Autowired
    FakeStoreProductApi fakeStoreProductApi;
    public List<ProductDto> getAllProductsByCategoryId(int categoryId) throws IOException {
        List<APIProductDto>apiProductDtoList=fakeStoreProductApi.getAllItemsByCategoryId(categoryId).execute().body();
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
        APIProductDto apiProductDto=fakeStoreProductApi.getProductById(Id).execute().body();
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
