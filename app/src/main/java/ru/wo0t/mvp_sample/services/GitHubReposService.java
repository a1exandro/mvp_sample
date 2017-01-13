package ru.wo0t.mvp_sample.services;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.wo0t.mvp_sample.models.GitHubRepo;

/**
 * Created by alex on 13.01.17.
 */

public interface GitHubReposService {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> listRepos(@Path("user") String user);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
