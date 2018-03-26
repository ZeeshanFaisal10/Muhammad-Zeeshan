package com.example.hp.ecompetencia_2018;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView goLogin;
    EditText et_user;
    EditText et_pass , confirmpass;
    Button signin;
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    goLogin = findViewById(R.id.txt_login);
    goLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(SignupActivity.this , FirstActivity.class));
            finish();
        }
    });

    prg = findViewById(R.id.prg_bar);
    et_user = findViewById(R.id.s_user);
    et_pass = findViewById(R.id.s_pass);
    confirmpass = findViewById(R.id.s_cnfpass);
    signin = (Button)findViewById(R.id.s_sign);
        mAuth = FirebaseAuth.getInstance();
   signin.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           RegisterUser();
       }
   });
    }
    private  void RegisterUser(){
        String username =et_user.getText().toString();
        String password = et_pass.getText().toString();
        String cnfpass = confirmpass.getText().toString();
        if(username.isEmpty()){
            et_user.setError("Email is Required!");
            et_user.requestFocus();
            return;
        }
        if(password.isEmpty()){
            et_pass.setError("Password is Required!");
            et_pass.requestFocus();
            return;
        }
        if(cnfpass.isEmpty()){
            confirmpass.setError("Password is Required!");
            confirmpass.requestFocus();
            return;
        }
        if(!confirmpass.getText().toString().equals(password.toString()))
        {
            confirmpass.setError("Password Mismatch");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            et_user.setError("Enter a valid Email!");
            et_user.requestFocus();
            return;
        }
        if(password.length() < 6){
            et_pass.setError("Password minimum length should be 6");
            et_pass.requestFocus();
            return;
        }
        prg.setVisibility(View.VISIBLE);

        try {
            mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    prg.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        DialogCall();
                        final FirebaseUser user = mAuth.getCurrentUser();
                        user.sendEmailVerification();
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Dialog("Account already exists");
                        } else {
                            Dialog(task.getException().getMessage().toString());
                        }
                    }
                }
            });

        }catch (Exception exp){
            Dialog(exp.getMessage().toString());
        }
    }
    private void DialogCall() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Verification is sent to your Email, Go to your email and confirm verification.");
        //  builder.setCancelable(true);
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SignupActivity.this , FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });
        AlertDialog alert11 = builder.create();
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
