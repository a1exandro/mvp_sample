package ru.wo0t.mvp_sample.ui;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import ru.wo0t.mvp_sample.R;
import ru.wo0t.mvp_sample.login.ILoginView;
import ru.wo0t.mvp_sample.login.LoginPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements ILoginView{
    public static String TAG = "LoginFragment";

    @Bind(R.id.login_userName)
    EditText userName;

    LoginPresenter mPresenter;

    ProgressDialog mProgressDialog;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginFragment.
     */
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_submitBtn)
    public void onLoginTapped() {
        mProgressDialog = ProgressDialog.show(getContext(), "Authenticating...", null);
        mPresenter.login(userName.getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        mProgressDialog.dismiss();
        Intent intent = new Intent(getContext(), ListRepos.class);
        intent.putExtra(ListRepos.USERNAME, userName.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onLoginError(String error) {
        mProgressDialog.dismiss();
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
