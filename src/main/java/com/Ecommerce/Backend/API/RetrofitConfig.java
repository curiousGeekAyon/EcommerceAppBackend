package com.Ecommerce.Backend.API;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Value("${fakestore.api.baseurl}")
    String baseUrl;
    @Bean
    public Retrofit retrofitCreation()
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //TODO:add url in env file to get it dynamically
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApiCreation(Retrofit retrofit)
    {
        return retrofit.create(FakeStoreCategoryApi.class);
    }
    @Bean
    public FakeStoreProductApi fakeStoreProductApiCreation(Retrofit retrofit)
    {
        return retrofit.create(FakeStoreProductApi.class);
    }
}
