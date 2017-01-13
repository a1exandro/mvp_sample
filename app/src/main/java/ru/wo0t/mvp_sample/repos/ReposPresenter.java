package ru.wo0t.mvp_sample.repos;

import de.greenrobot.event.EventBus;

/**
 * Created by alex on 13.01.17.
 */

public class ReposPresenter {
    private IReposView mView;
    private ReposIterator mIterator = new ReposIterator();

    public ReposPresenter(IReposView view) {
        mView = view;
        EventBus.getDefault().register(this);
    }

    public void loadRepos(String username) {
        mIterator.getRepos(username);
    }

    public void onEvent(ReposEvent event) {
        if (event.isSuccess()) {
            mView.onLoadSuccess(event.getRepos());
        }
        else {
            mView.onLoadError(event.getError());
        }
    }
}
