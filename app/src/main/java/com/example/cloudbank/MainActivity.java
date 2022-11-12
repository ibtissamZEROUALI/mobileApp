package com.example.cloudbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText email_input;
    @BindView(R.id.password)
    EditText password_input;
    @BindView(R.id.RemembermeCheckBox)
    CheckBox rememberMe;


    public void redirection_after_login() {


        if (email_input.getText().toString().equals("saad@gmail.com") && password_input.getText().toString().equals("root")) {
            //the credentials are correct
            Intent intent = new Intent(this, AccueilActivity.class);
            rememberMeCheck();
            startActivity(intent);
        } else {
            //an error in the credentials

        }
    }

    public void rememberMeCheck() {
        SharedPreferences preferences = getSharedPreferences("loginInfo", Context.MODE_APPEND);
        if (rememberMe.isChecked()) {
            preferences.edit().putString("email", email_input.getText().toString()).commit();
            preferences.edit().putString("password", password_input.getText().toString()).commit();

        } else {
            preferences.edit().clear();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MaterialButton button_login = (MaterialButton) findViewById(R.id.login_btn);

        //so if we have the check we have to directely redirect it
        SharedPreferences preferences = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        if (preferences.contains("email")){
            Intent intent = new Intent(this, AccueilActivity.class);
            startActivity(intent);
        }


            //this is the listener onclick that will be initiated when receiving the event and
            // will start the function on click
            button_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    redirection_after_login();
                }
            });
    }
}