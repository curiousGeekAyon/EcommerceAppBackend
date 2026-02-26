package com.Ecommerce.Backend.API;

import DTO.APICategoryDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreApi {
    @GET("categories")
    Call<List<APICategoryDto>> getAllCategories();
}
