package com.hcdc.exercise3abutton_basedcalculator;

// Author: John Henly A. Montera
// [Exercise 3A] Button-Based Calculator
// Done: Feb 10, 2022

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView processdisplay; // textview process
    TextView resultdisplay; // textview result/ans

    String process = "";    //process holder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        InitiateTextViews();
    }

    private void InitiateTextViews(){
        processdisplay = (TextView)findViewById(R.id.processdisplay);
        resultdisplay = (TextView)findViewById(R.id.resultdisplay);
        processdisplay.setText("0");
        resultdisplay.setText("0");
    }

    private void setProcess(String value) // add character per event
    {
        process = process + value;
        processdisplay.setText(process);
    }

    public void equalsOnClick(View view)    // Result Event / Ans Event Displayed
    {

            Double result = null;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

            try {

                result = (double)engine.eval(process);

            } catch (ScriptException e)
            {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }
            catch (NullPointerException e){
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }

            if(result != null){
                resultdisplay.setText(String.valueOf(result.doubleValue()));
            }


    }


    public void C(View view)    // reset display and operations to zero
    {
        processdisplay.setText("0");
        process = "";
        resultdisplay.setText("0");
    }

    public void CE(View view) // reset display to zero
    {
        processdisplay.setText("0");
        resultdisplay.setText("0");
    }

    public void backspace(View view) // backspace
    {

        String proc = processdisplay.getText().toString();

        if (proc.length() > 0 && proc != "0"){

            if (proc.length() == 1){
                processdisplay.setText("0");
                process = "0";
            }
            else {
                processdisplay.setText(proc.substring(0,proc.length() - 1));
                process = processdisplay.getText().toString();
            }
        }


    }

    public void positivenegative(View view) // swap result from negative to positve or vice versa
    {

        String temp2 = processdisplay.getText().toString();
        double temp = Double.parseDouble(resultdisplay.getText().toString());

        if (temp < 0.0) {
            temp = Math.abs(temp); // negative to positive
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText(temp2);
            process = Double.toString(temp);
        }
        else {
            temp = Math.abs(temp) * -1; // positive to negative
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText(temp2);
            process = Double.toString(temp);
        }

    }

    public void onedivided(View view) { // divide one with the result

        String temp2 = processdisplay.getText().toString();
        double temp = Double.parseDouble(resultdisplay.getText().toString());

        if (resultdisplay.getText().toString() != "0"){
            temp = 1/temp;
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText(temp2 + "/1");
            process = Double.toString(temp);
        }

        else {
            temp = 1/Double.parseDouble(processdisplay.getText().toString());
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText(temp2 + "/1");
            process = Double.toString(temp);
        }

    }

    public void squaredtwo(View view){ // squared the result
        String temp2 = processdisplay.getText().toString();
        double temp = Double.parseDouble(resultdisplay.getText().toString());

        if (resultdisplay.getText().toString() != "0"){
        temp = Math.pow(temp, 2);
        resultdisplay.setText(Double.toString(temp));
        processdisplay.setText(temp2 + "^2");
        process = Double.toString(temp);}

        else {
            temp = Math.pow(Double.parseDouble(processdisplay.getText().toString()),2);
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText(temp2 + "^2");
            process = Double.toString(temp);
        }
    }

    public void squareRoot(View view) { // square root the result
        String temp2 = processdisplay.getText().toString();
        double temp = Double.parseDouble(resultdisplay.getText().toString());

        if (resultdisplay.getText().toString() != "0"){
            temp = Math.sqrt(temp);
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText("√" +temp2);
            process = Double.toString(temp);
        }

        else {
            temp = Math.sqrt(Double.parseDouble(processdisplay.getText().toString()));
            resultdisplay.setText(Double.toString(temp));
            processdisplay.setText("√" +temp2);
            process = Double.toString(temp);
        }

    }

    public void zero(View view){
        setProcess("0");
    }

    public void one(View view){
        setProcess("1");
    }

    public void two(View view){
        setProcess("2");
    }

    public void three(View view){
        setProcess("3");
    }

    public void four(View view){
        setProcess("4");
    }

    public void five(View view){
        setProcess("5");
    }

    public void six(View view){
        setProcess("6");
    }

    public void seven(View view){
        setProcess("7");
    }

    public void eight(View view){
        setProcess("8");
    }

    public void nine(View view){
        setProcess("9");
    }

    public void dot(View view){
        setProcess(".");
    }

    public void divide(View view){
        setProcess("/");
    }

    public void mulitply(View view){
        setProcess("*");
    }

    public void minus(View view){
        setProcess("-");
    }

    public void add(View view){
        setProcess("+");
    }



}