package com.example.githubsearchandroid.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubsearchandroid.MainActivity;
import com.example.githubsearchandroid.R;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
    }

    public void login(View v) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build()
        );

        Intent loginIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_favourite)
                .build();

        startActivityForResult(loginIntent, 42);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 42) {
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "bruh", Toast.LENGTH_LONG).show();
            }
        }
    }
}
