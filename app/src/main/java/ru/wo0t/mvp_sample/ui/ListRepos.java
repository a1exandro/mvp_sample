package ru.wo0t.mvp_sample.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.wo0t.mvp_sample.R;
import ru.wo0t.mvp_sample.models.GitHubRepo;
import ru.wo0t.mvp_sample.repos.IReposView;
import ru.wo0t.mvp_sample.repos.RepoAdapter;
import ru.wo0t.mvp_sample.repos.ReposPresenter;

public class ListRepos extends AppCompatActivity implements IReposView{
    public static final String USERNAME = "USERNAME";
    String mUserName;
    ReposPresenter mReposPresenter;
    ProgressDialog mProgressDialog;
    RepoAdapter mAdapter;

    @Bind(R.id.repos_listview)
    ListView mReposList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repos);
        ButterKnife.bind(this);
        mAdapter = new RepoAdapter(this, null);
        mReposList.setAdapter(mAdapter);

        Intent intent = getIntent();
        mUserName = intent.getStringExtra(USERNAME);

        mReposPresenter = new ReposPresenter(this);
        mProgressDialog = ProgressDialog.show(this, "Loading repo list...", null);
        mReposPresenter.loadRepos(mUserName);
    }

    @Override
    public void onLoadSuccess(List<GitHubRepo> repos) {
        mProgressDialog.dismiss();
        mAdapter.setData(repos);
    }

    @Override
    public void onLoadError(String error) {
        mProgressDialog.dismiss();
        Toast.makeText(this, "Could not load repo list", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
