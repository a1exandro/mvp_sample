package ru.wo0t.mvp_sample.repos;

import java.util.ArrayList;
import java.util.List;

import ru.wo0t.mvp_sample.models.GitHubRepo;

/**
 * Created by alex on 13.01.17.
 */

class ReposEvent {
    private boolean success;
    private List<GitHubRepo> repos;
    private String error;

    ReposEvent(String errorString) { this.success = false; this.repos = new ArrayList<>(); this.error = errorString; }
    ReposEvent(List<GitHubRepo> repos) { this.success = true; this.repos = repos; this.error = ""; }

    boolean isSuccess() { return this.success; }
    List<GitHubRepo> getRepos() { return repos; }
    String getError() { return this.error; }
}
