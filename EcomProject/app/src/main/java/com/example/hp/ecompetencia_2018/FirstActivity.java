package com.example.hp.ecompetencia_2018;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirstActivity extends AppCompatActivity {

    ProgressBar progressBar;TextView signup_txt;
    FirebaseAuth mAuth;
    EditText username1,pass;
    Button login;
    FirebaseUser user;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        signup_txt = findViewById(R.id.signup_txt);
        login = (Button)findViewById(R.id.l_btn);
        username1 = (EditText)findViewById(R.id.l_user);
        progressBar = (ProgressBar)findViewById(R.id.prog);
        pass = (EditText)findViewById(R.id.l_pass);
        mAuth = FirebaseAuth.getInstance();
        signup_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this , SignupActivity.class);
                startActivity(intent);
            }
        });

   login.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           userLogin();
       }
   });
    }
    @Override
    public void onBackPressed() {
        if(doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = false;
        dialog();
    }

    private void userLogin() {
        String username =username1.getText().toString().trim();
        String password = pass.getText().toString().trim();
        if(username.isEmpty()){
            username1.setError("Email is Required!");
            username1.requestFocus();
            return;
        }
        if(password.isEmpty()){
            pass.setError("Password is Required!");
            pass.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            username1.setError("Enter a valid Email!");
            username1.requestFocus();
            return;
        }
        if(password.length() < 6){
            pass.setError("Password minimum length should be 6");
            pass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        try {
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    user = mAuth.getCurrentUser();
                    if (task.isSuccessful() && user.isEmailVerified()) {
                        Intent intent = new Intent(FirstActivity.this, Homepage.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else if (!user.isEmailVerified()) {
                        Dialog("Please first verify your email");
                        progressBar.setVisibility(View.GONE);
                    } else {
                        String m = task.getException().getMessage().toString();
                        Dialog(m);
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }catch (Exception ex){
            Dialog(ex.getMessage());
        }
    }
    private void dialog(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Do you really want to exit?");
        build.setCancelable(true);
       build.setPositiveButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               doubleBackToExitPressedOnce = false;
               return;
           }
       });
        build.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           finish();
            }
        });
        AlertDialog alert11 = build.create();
        alert11.show();
    }
    private void Dialog(String x) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(x.toString());
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}