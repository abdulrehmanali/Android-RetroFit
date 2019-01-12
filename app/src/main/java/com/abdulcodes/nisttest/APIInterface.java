package com.abdulcodes.nisttest;

import android.content.Intent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/users")
    Call<User> createUser(@Body User user);

    @GET("/wp-json/api/v1/users?")
    Call<UserList> doGetUserList();

    @FormUrlEncoded
    @POST("/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("access_token") String access_token);
}
