package com.example.hrishabh.dharna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button login;
    private EditText luser,lpass;
    FirebaseAuth lauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        luser=(EditText) findViewById(R.id.login_email);
        lpass=(EditText) findViewById(R.id.login_pass);
        login=(Button) findViewById(R.id.login);
        lauth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lauth.signInWithEmailAndPassword()
            }
        });

    }
}
