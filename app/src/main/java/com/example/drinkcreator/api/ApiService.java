package com.example.drinkcreator.api;


import com.example.drinkcreator.apiModels.DrinkModelFromApi;
import com.example.drinkcreator.apiModels.ObjectModelWithListFromApi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/json/v1/1/search.php")
    Observable<Response<ObjectModelWithListFromApi>> getDrinkListFromApiBySingleChar(@Query("f") String name);

    @GET("/api/json/v1/1/search.php")
    Observable<Response<ObjectModelWithListFromApi>> getDrinkListFromApiByName(@Query("s") String name);



}
