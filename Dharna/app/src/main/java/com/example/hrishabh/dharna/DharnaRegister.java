package com.example.hrishabh.dharna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DharnaRegister extends AppCompatActivity {

    private EditText name, topic, place, date, time, desc;
    private Button submit;
    private ImageView img;
    private int year,month,day;
    private static final int DIALOG_ID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharna_register);

        name = (EditText) findViewById(R.id.name);
        topic = (EditText) findViewById(R.id.topic);
        place = (EditText) findViewById(R.id.place);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        desc = (EditText) findViewById(R.id.des);
        submit = (Button) findViewById(R.id.sub);
        img = (ImageView) findViewById(R.id.cale);





    }
}


