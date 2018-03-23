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
import com.google.firebase.auth.FirebaseAuth;

public class Reset extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        textView=(TextView) findViewById(R.id.show);
        editText=(EditText) findViewById(R.id.remail);
        button=(Button) findViewById(R.id.rbutton);
        progressDialog=new ProgressDialog(this);
        auth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                progressDialog.setMessage("Resetting Password");
                progressDialog.show();

                if(TextUtils.isEmpty(editText.getText().toString().trim())){
                    textView.setText("Enter email id  to reset password");
                    progressDialog.dismiss();
                    return;
                }

                auth.sendPasswordResetEmail(editText.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            textView.setText("Check you email id to reset your password");
                            progressDialog.dismiss();
                            
                        } else{
                            textView.setText("Password resetting failed, try again");
                            progressDialog.dismiss();
                            return;
                        }
                    }
                });

            }
        });

    }
}
