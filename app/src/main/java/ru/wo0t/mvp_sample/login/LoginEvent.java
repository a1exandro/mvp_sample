package ru.wo0t.mvp_sample.login;

/**
 * Created by alex on 13.01.17.
 */

class LoginEvent {
    private boolean success;
    private String error;

    LoginEvent(boolean success) { this.success = success; this.error = "";}
    LoginEvent(boolean success, String error) { this.success = success; this.error = error; }

    boolean isSuccess() { return this.success; }
    String getError() { return this.error; }
}
