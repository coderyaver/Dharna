package com.example.hrishabh.dharna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Front extends AppCompatActivity {

    private Button button,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        button=(Button) findViewById(R.id.test);
        b=(Button) findViewById(R.id.rb);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Front.this,DharnaRegister.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Front.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}
