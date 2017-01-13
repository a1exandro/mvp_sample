package ru.wo0t.mvp_sample.repos;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.wo0t.mvp_sample.models.GitHubRepo;
import ru.wo0t.mvp_sample.services.GitHubReposService;

/**
 * Created by alex on 13.01.17.
 */

class ReposIterator {

    void getRepos(String username) {
        GitHubReposService gitHubService = GitHubReposService.retrofit.create(GitHubReposService.class);
        Call<List<GitHubRepo>> call = gitHubService.listRepos(username);
        call.enqueue(new Callback<List<GitHubRepo>>() {

            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> list = response.body();
                if (list != null)
                    EventBus.getDefault().post(new ReposEvent(list));
                else
                    EventBus.getDefault().post(new ReposEvent("Unable to load data!"));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                EventBus.getDefault().post(new ReposEvent(t.getMessage()));
            }
        });
    }
}
