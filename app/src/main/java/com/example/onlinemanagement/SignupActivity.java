package com.example.onlinemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText namebox,emailbox,passwodrbox;
    Button loginbtn,createbtn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        namebox=findViewById(R.id.namebox);
        emailbox=findViewById(R.id.emailbox);
        passwodrbox=findViewById(R.id.passwordbox);
        loginbtn=findViewById(R.id.loginbtn);
        createbtn=findViewById(R.id.createbtn);
        auth=FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,pass;
                name=namebox.getText().toString();
                email=emailbox.getText().toString();
                pass=passwodrbox.getText().toString();
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this,"اکانت شما با موفقیت ساخته شد",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                        }else {
                            Toast.makeText(SignupActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}