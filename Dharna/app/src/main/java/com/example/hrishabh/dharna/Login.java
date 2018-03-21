package com.example.hrishabh.dharna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button login;
    private EditText luser,lpass;
    FirebaseAuth lauth;
    ProgressDialog lprogressDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lprogressDialog=new ProgressDialog(this);
        luser=(EditText) findViewById(R.id.login_email);
        lpass=(EditText) findViewById(R.id.login_pass);
        login=(Button) findViewById(R.id.login);
        lauth=FirebaseAuth.getInstance();
        textView=(TextView) findViewById(R.id.lrefer);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(luser.getText().toString().trim())){
                    Toast.makeText(Login.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                } else if(TextUtils.isEmpty(lpass.getText().toString().trim())){
                    Toast.makeText(Login.this,"Enter Pass",Toast.LENGTH_SHORT).show();
                    return;
                } else{
                    lprogressDialog.setMessage("Logging in");
                    lprogressDialog.show();
                    lauth.signInWithEmailAndPassword(luser.getText().toString().trim(),lpass.getText().toString().trim()).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this,"Logged in",Toast.LENGTH_SHORT).show();
                                lprogressDialog.dismiss();
                            } else{
                                Toast.makeText(Login.this,"Login fail, try again",Toast.LENGTH_SHORT).show();
                                lprogressDialog.dismiss();
                                return;
                            }

                        }
                    });
                }
            }
        });

    }
}
