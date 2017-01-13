package ru.wo0t.mvp_sample.login;

/**
 * Created by alex on 13.01.17.
 */

public interface ILoginView {
    void onLoginSuccess();
    void onLoginError(String error);
}
