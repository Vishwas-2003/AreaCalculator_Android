package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.icu.number.Precision;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        setContentView(R.layout.activity_main);
        EditText edttxt1 = findViewById(R.id.edt1);
        EditText edttxt2=findViewById(R.id.edt2);
        EditText edttxt3=findViewById(R.id.edt3);

        Button slt_btn=findViewById(R.id.name_btn);
        Button btn=findViewById(R.id.cal_btn);

        TextView rslt=findViewById(R.id.rst);

        double pi=3.14159265359;

        slt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt1 = edttxt1.getText().toString().toLowerCase().replaceAll("\\s", "");
                edttxt2.setText("");
                edttxt3.setText("");
                rslt.setHint("");

                edttxt2.setVisibility(View.GONE);
                edttxt3.setVisibility(View.GONE);
                btn.setVisibility(View.GONE);

                if (txt1.isEmpty()) {
                    edttxt1.setHint("REQUIRED FIELD");
                    edttxt2.setHint("");
                    edttxt3.setHint("");
                }
                else if (txt1.equalsIgnoreCase("rectangle")) {
                    edttxt2.setHint("Enter Length");
                    edttxt3.setHint("Enter Breadth");
                    edttxt2.setVisibility(View.VISIBLE);
                    edttxt3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("square")) {
                    edttxt2.setHint("Enter Side");
                    edttxt2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("triangle")) {
                    edttxt2.setHint("Enter Base");
                    edttxt3.setHint("Enter Height");
                    edttxt2.setVisibility(View.VISIBLE);
                    edttxt3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("circle")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("cone")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt3.setHint("Enter Height");
                    edttxt2.setVisibility(View.VISIBLE);
                    edttxt3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("cylinder")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt3.setHint("Enter Height");
                    edttxt2.setVisibility(View.VISIBLE);
                    edttxt3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("cone")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt3.setHint("Enter Slant Height");
                    edttxt2.setVisibility(View.VISIBLE);
                    edttxt3.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("sphere")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else if (txt1.equalsIgnoreCase("hemisphere")) {
                    edttxt2.setHint("Enter Radius");
                    edttxt2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }

                else {
                    edttxt1.setText("");

                    edttxt1.setHint("Enter a valid Input");
                    edttxt2.setHint("");
                    edttxt3.setHint("");
                }

            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String txt1 = edttxt1.getText().toString().toLowerCase().replaceAll("\\s", "");

                    double exp1 = 1.0, exp2 = 1.0;


                    exp1 = Double.parseDouble(edttxt2.getText().toString());
                    if(edttxt3.getText().toString().isEmpty() || txt1.equalsIgnoreCase("square") || txt1.equalsIgnoreCase("circle"))
                        exp2=1.0;
                    else
                        exp2 = Double.parseDouble(edttxt3.getText().toString());


                    DecimalFormat df=new DecimalFormat("00.00");
                    double result = 0.0,result1=0.0;
                    switch (txt1) {
                        case "rectangle":
                            result = (exp1 * exp2);

                            rslt.setHint("Area:\n" + df.format(result)+" Square Units");
                            break;

                        case "square":
                            result = exp1 * exp1;
                            rslt.setHint("Area:\n" + df.format(result)+" Square Units");
                            break;
                        case "triangle":
                            result = 0.5 * exp1 * exp2;
                            rslt.setHint("Area:\n" + df.format(result)+" Square Units");
                            break;
                        case "circle":
                            result = pi * exp1 * exp1;
                            rslt.setHint("Area:\n" + df.format(result)+" Square Units");
                            break;
                        case "cylinder":
                            result = pi * 2 * exp1 * exp2;
                            result1=(pi*2*exp1)*(exp1+exp2);
                            rslt.setHint("Curved Surface Area:\n" + df.format(result) +" Square Units\n" + "\nTotal Surface Area:\n" + df.format(result1)+" Square Units");
                            break;
                        case "cone":
                            result = pi * exp2 * exp1;
                            result1=(pi*exp1)*(exp1+exp2);
                            rslt.setHint("Curved Surface Area:\n" + df.format(result)+" Square Units\n" + "\nTotal Surface Area:\n" + df.format(result1)+" Square Units");
                            break;
                        case "sphere":
                            result = pi * 4 * Math.pow(exp1,2);
                            rslt.setHint("Curved Surface Area:\n" + df.format(result)+" Square Units");
                            break;
                        case "hemisphere":
                            result = pi * 2 * exp1 *exp1;

                            result1=3*pi*Math.pow(exp1,2);
                            rslt.setHint("Curved Surface Area:\n" + df.format(result)+" Square Units\n" + "\nTotal Surface Area:\n" + df.format(result1)+" Square Units");
                            break;
                        default:
                            rslt.setHint("Wrong Input");
                            break;
                    }
                }
                catch(Exception e){}
            }

        });







    }
}