package ru.wo0t.mvp_sample.repos;

import java.util.List;

import ru.wo0t.mvp_sample.models.GitHubRepo;

/**
 * Created by alex on 13.01.17.
 */

public interface IReposView {
    void onLoadSuccess(List<GitHubRepo> repos);
    void onLoadError(String error);
}
