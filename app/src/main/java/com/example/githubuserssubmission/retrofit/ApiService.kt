package com.example.githubuserssubmission.retrofit

import com.example.githubuserssubmission.response.DetailUserResponse
import com.example.githubuserssubmission.response.GithubResponse
import com.example.githubuserssubmission.response.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getUsers(
        @Header("Authorization") token: String
    ): Call<List<Users>>

    @GET("search/users")
    fun getSearchUser(
        @Query("q") user : String,
        @Header("Authorization") token: String
    ) : Call<GithubResponse>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    fun getUserFollowers(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Call<List<Users>>

    @GET("users/{username}/following")
    fun getUserFollowings(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Call<List<Users>>
}