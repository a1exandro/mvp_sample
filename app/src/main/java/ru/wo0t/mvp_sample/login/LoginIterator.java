package ru.wo0t.mvp_sample.login;

import android.os.Handler;

import de.greenrobot.event.EventBus;

/**
 * Created by alex on 13.01.17.
 */

class LoginIterator {
    void login(final String userName) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if ((userName.length() >= 3)) {
                    EventBus.getDefault().post(new LoginEvent(true));
                } else {
                    EventBus.getDefault().post(new LoginEvent(false, "Username must be at least 3 letters length"));
                }
            }
        }, 2000);
    }
}
