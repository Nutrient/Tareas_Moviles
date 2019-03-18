package com.iteso.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.Collections;

public class ActivityLogin extends Activity {

    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }

    public void login (View v){
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER", new Gson().toJson(new User(username.getText().toString(), password.getText().toString(), true)));
        editor.apply();

        Intent intent = new Intent().setClass(ActivityLogin.this, ActivityMain.class);
        startActivity(intent);
    }
}
