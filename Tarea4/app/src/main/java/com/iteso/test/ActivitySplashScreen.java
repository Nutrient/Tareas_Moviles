package com.iteso.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends Activity {
    SharedPreferences sharedPreferences;
    Gson gson;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);
        gson = new Gson();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Intent intent;
                try {
                    user = gson.fromJson(sharedPreferences.getString("USER", gson.toJson(new User())), User.class);
                    if (user.isLogged()){
                        intent = new Intent().setClass(ActivitySplashScreen.this, ActivityMain.class);
                    }
                    else {
                        intent = new Intent().setClass(ActivitySplashScreen.this, ActivityLogin.class);
                    }
                    startActivity(intent);
                }catch (Exception e){
                    intent = new Intent().setClass(ActivitySplashScreen.this, ActivityLogin.class);
                    startActivity(intent);
                }
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);

    }

}
