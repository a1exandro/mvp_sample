package ru.wo0t.mvp_sample.login;

import de.greenrobot.event.EventBus;

/**
 * Created by alex on 13.01.17.
 */

public class LoginPresenter {
    private ILoginView mView;
    private LoginIterator mIterator = new LoginIterator();

    public LoginPresenter(ILoginView view) {
        mView = view;
        EventBus.getDefault().register(this);
    }

    public void login(String username) {
        mIterator.login(username);
    }

    public void onEvent(LoginEvent event) {
        if (event.isSuccess()) {
            mView.onLoginSuccess();
        }
        else {
            mView.onLoginError(event.getError());
        }
    }
}
