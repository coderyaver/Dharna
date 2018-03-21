package com.example.hrishabh.dharna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {

    private EditText email,pass,cpass;
    private Button button;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressDialog=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        email=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.pass);
        cpass=(EditText) findViewById(R.id.cpass);
        button=(Button) findViewById(R.id.register);
        textView=(TextView) findViewById(R.id.refer);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().trim().equals(cpass.getText().toString().trim())) {
                    if (TextUtils.isEmpty(email.getText().toString().trim())) {
                        Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (TextUtils.isEmpty(pass.getText().toString().trim())) {
                        Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Log.d("tag", "proceed");
                        Toast.makeText(Signup.this, "Proceed", Toast.LENGTH_SHORT).show();
                        progressDialog.setMessage("Registering User...");
                        progressDialog.show();
                        mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), pass.getText().toString().trim()).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Signup.this,"User Registered",Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                    Intent intent=new Intent(Signup.this,Login.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(Signup.this,"Could not registered",Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                    return;
                                }
                            }
                        });
                    }
                }else {
                    Toast.makeText(Signup.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}

