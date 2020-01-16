package com.example.danfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Login extends AppCompatActivity{
    private ImageView btnsplashlogin;
    private ImageView btnsplashsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnsplashlogin = findViewById(R.id.btnsplashlogin);
        btnsplashsignup = findViewById(R.id.btnsplashsignup);




        btnsplashlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SplashLogin.class); //intent 
                startActivity(intent);

            }
        });

    }



}
