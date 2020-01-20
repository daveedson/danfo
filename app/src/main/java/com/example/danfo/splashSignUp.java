package com.example.danfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class splashSignUp extends AppCompatActivity {

    private EditText edtSignUpName,
                     edtSignUpEmail,
                     edtSignUpPassword;

    private ProgressDialog progressDialog;
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

                try{

                    edtSignUpEmail.setError(null);
                    edtSignUpPassword.setError(null);


                    if (edtSignUpName.getText().toString().equals("")||edtSignUpEmail.getText().toString().equals("")||edtSignUpPassword.getText().toString().equals("")){

                        Toast.makeText(splashSignUp.this,"Name,Email and password is required !",Toast.LENGTH_SHORT).show();

                    }else {

                        final ParseUser TheUser = new ParseUser();
                        TheUser.setUsername(edtSignUpName.getText().toString());
                        TheUser.setEmail(edtSignUpEmail.getText().toString());
                        TheUser.setPassword(edtSignUpPassword.getText().toString());


                        progressDialog = new ProgressDialog(splashSignUp.this);
                        progressDialog.setMessage("Signing Up "+edtSignUpName.getText().toString());
                        progressDialog.show();





                        TheUser.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {

                                if (e == null) {
                                    ParseUser.logOut();
                                    alertDisplayer("Account created Successfully", "Please verify Your email before Login", false);
                                    //  Toast.makeText(splashSignUp.this,TheUser.getUsername() + " is signed up",Toast.LENGTH_LONG).show();


                                } else {
                                    ParseUser.logOut();
                                    alertDisplayer("Error Account Creation Failed", "Account could not be created" + e.getMessage(), true);
                                 //   Toast.makeText(splashSignUp.this, "An Error Occurred" + e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                progressDialog.dismiss();


                            }
                        });
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }



            }
        });



    }
    private  void alertDisplayer(String title,String message,final boolean error){

        AlertDialog.Builder builder = new AlertDialog.Builder(splashSignUp.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if(!error) {
                            Intent intent = new Intent(splashSignUp.this, SplashLogin.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();


    }


}
