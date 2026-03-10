package com.Ecommerce.Backend.API;

import DTO.APICategoryDto;
import DTO.APIProductDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface FakeStoreCategoryApi {
    @GET("categories")
    Call<List<APICategoryDto>> getAllCategories();
}
