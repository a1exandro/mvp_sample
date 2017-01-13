package ru.wo0t.mvp_sample.models;

/**
 * Created by alex on 13.01.17.
 */

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    public int id;
    public String name;
    public boolean fork;
    @SerializedName("stargazers_count")
    public int stars;
}
