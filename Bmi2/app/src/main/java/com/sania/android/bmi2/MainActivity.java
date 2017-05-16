package com.sania.android.bmi2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.custom_font);
        TextView txt2 = (TextView) findViewById(R.id.num);
        TextView txt3 = (TextView) findViewById(R.id.bmi);
        TextView txt4 = (TextView) findViewById(R.id.height);
        TextView txt5 = (TextView) findViewById(R.id.button);
        Typeface font = Typeface.createFromAsset(getAssets(), "GeosansLight.ttf");
        Typeface font5 = Typeface.createFromAsset(getAssets(), "GeosansLight.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "GeosansLight.ttf");
        Typeface font3 = Typeface.createFromAsset(getAssets(), "GeosansLight.ttf");
        Typeface font4 = Typeface.createFromAsset(getAssets(), "GeosansLight.ttf");
        txt.setTypeface(font);
        txt2.setTypeface(font2);
        txt3.setTypeface(font3);
        txt4.setTypeface(font4);
        txt5.setTypeface(font5);
    }

    public void calculate(View view) {

        EditText et = (EditText) findViewById(R.id.et1);
        EditText ett = (EditText) findViewById(R.id.et2);
        TextView txt2 = (TextView) findViewById(R.id.num);
        TextView txt3 = (TextView) findViewById(R.id.bmi);
        EditText in=(EditText) findViewById(R.id.inches);

        View v1 = findViewById(R.id.strip);
        String s = et.getText().toString();
        String ss = ett.getText().toString();
        String inch=in.getText().toString();

        if(TextUtils.isEmpty(s)) {
            et.setError("Required Field");
            return;
        }
        if(TextUtils.isEmpty(inch)){
            in.setError("Required Field");
            return;
        }
        if(TextUtils.isEmpty(ss)) {
            ett.setError("Required Field");
            return;
        }

        double w, bmi;
        String bm;
        int h,h1;

        h = Integer.parseInt(s);
        h1=Integer.parseInt(inch);
        w = Double.parseDouble(ss);

        if(h>8){
            et.setError("Invalid input");
            return;
        }

        if(h1>12){
            //Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
            in.setError("Invalid input");
            return;
        }

        if(w>1230||w<3)
        {
            ett.setError("Invalid Input");
            return;
        }
        h=h*12+h1;


        //n1=n1*0.3048;

        bmi = (w * 703) / (h * h);

        if (bmi < 18.5) {
            txt2.setTextColor(Color.parseColor("#FFFF00"));
            txt3.setTextColor(Color.parseColor("#FFFF00"));
            v1.setBackgroundColor(Color.parseColor("#FFFF00"));

        }
        if (bmi >= 18.5 && bmi <= 24.9) {
            txt2.setTextColor(Color.parseColor("#76FF03"));
            txt3.setTextColor(Color.parseColor("#76FF03"));
            v1.setBackgroundColor(Color.parseColor("#76FF03"));
        }
        if (bmi > 24.9 && bmi <= 29.9) {
            txt2.setTextColor(Color.parseColor("#FF5722"));
            txt3.setTextColor(Color.parseColor("#FF5722"));
            v1.setBackgroundColor(Color.parseColor("#FF5722"));
        }
        if (bmi >= 30) {
            txt2.setTextColor(Color.parseColor("#D50000"));
            txt3.setTextColor(Color.parseColor("#D50000"));
            v1.setBackgroundColor(Color.parseColor("#D50000"));
        }
        int i;
        i = (int) Math.round(bmi);
        bm = String.valueOf(i).toString();
        txt2.setText(bm);
    }
}
