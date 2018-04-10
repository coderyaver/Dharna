package com.example.hrishabh.dharna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DharnaRegister extends AppCompatActivity {
    private Button button;
    private EditText name,topic,place,disc,date,time;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharna_register);

        button=(Button) findViewById(R.id.sub);
        name=(EditText) findViewById(R.id.name);
        topic=(EditText) findViewById(R.id.topic);
        place=(EditText) findViewById(R.id.place);
        disc=(EditText) findViewById(R.id.dis);
        date=(EditText) findViewById(R.id.date);
        image=(ImageView) findViewById(R.id.cale);
        time=(EditText) findViewById(R.id.time);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
