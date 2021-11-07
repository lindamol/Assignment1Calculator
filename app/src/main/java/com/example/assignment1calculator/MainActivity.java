package com.example.assignment1calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Calculator calobj = new Calculator();
    TextView resultview;
    Button buttonequal;
    String text = "";
    String histext = "";
    double result = 0;
    TextView historyText;
    Button advancebutton;
    Button buttonC;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        historyText = findViewById(R.id.historyText);
        resultview = findViewById(R.id.resultText);
        resultview.setText("");
        advancebutton = findViewById(R.id.buttonadvance);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        buttonC = findViewById(R.id.buttonC);
        buttonequal = findViewById(R.id.buttonequal);
        Button buttonsub = findViewById(R.id.buttonminus);
        Button buttonadd = findViewById(R.id.buttonplus);
        Button buttonmultiply = findViewById(R.id.buttonmultiply);
        Button buttondivide = findViewById(R.id.buttondivide);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonequal.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttonadd.setOnClickListener(this);
        buttonmultiply.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        advancebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttontitle = button.getText().toString();
        if(v == buttonC){
            resultview.setText("");
            text = "";
            calobj.calArray.clear();
            histext = "";
        }
        else if(v == advancebutton){
            System.out.println("Mode value is"+mode+"");
            if(mode ==0)//for Display History
            {  mode=1;
                advancebutton.setText("STANDARD-WITH HISTORY");
            }
            else{//std mode
                mode=0;
                advancebutton.setText("ADVANCE-WITH HISTORY");
                historyText.setText(" ");
                calobj.historyArray.clear();
            }
        }
        else if (v == buttonequal) {
            result = calobj.calculate();
            calobj.printarray();
            text = text + " = " + result;
            if(mode == 1){ // For History Mode
                calobj.pushtoHistoryArray(text);
                for (String object:calobj.historyArray) {
                    System.out.println("My History array is "+object+" ");
                    histext = histext + object + "\n";
                    historyText.setText(histext) ;
                }
            }
            resultview.setText(text);
        }
        else {
            text = text + buttontitle;
            resultview.setText(text);
            calobj.pushtoArray(buttontitle);
            calobj.printarray();
        }
    }

}
