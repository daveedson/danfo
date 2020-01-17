package com.example.danfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class splashSignUp extends AppCompatActivity {

    private EditText edtSignUpName,
                     edtSignUpEmail,
                     edtSignUpPassword;

    private ImageView btnsgSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sign_up);


        edtSignUpName = findViewById(R.id.edtSignUpName);
        edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
        btnsgSignUp = findViewById(R.id.btnsgSignUp);

        if (ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }

        btnsgSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtSignUpName.getText().toString().equals("")||edtSignUpEmail.getText().toString().equals("")||edtSignUpPassword.getText().toString().equals("")){

                    Toast.makeText(splashSignUp.this,"Name,Email and password is required !",Toast.LENGTH_SHORT).show();

                }else{

                    final ParseUser TheUser = new ParseUser();
                    TheUser.setUsername(edtSignUpName.getText().toString());
                    TheUser.setEmail(edtSignUpEmail.getText().toString());
                    TheUser.setPassword(edtSignUpPassword.getText().toString());

                    TheUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e==null){
                                Toast.makeText(splashSignUp.this,TheUser.getUsername() + " is signed up",Toast.LENGTH_LONG).show();


                            }else {
                                Toast.makeText(splashSignUp.this,"An Errorr Occured" + e.getMessage(),Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });
    }


}
