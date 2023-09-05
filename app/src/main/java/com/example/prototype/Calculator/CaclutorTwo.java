package com.example.prototype.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prototype.R;
import org.mariuszgromada.math.*;
import org.mariuszgromada.math.mxparser.Expression;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CaclutorTwo extends AppCompatActivity {
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caclutor_two);
        display=findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    public void update(String strtoAdd){
        String oddStr=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oddStr.substring(0,cursorPos);
        String rightStr=oddStr.substring(cursorPos);

        // Check if the input is a valid decimal point
        if (strtoAdd.equals(".") && !isValidDecimalInput(oddStr, leftStr, rightStr)) {
            return; // Don't update the display
        }

        // Check if the input is a valid operator
        if (isOperator(strtoAdd) && !isValidOperatorInput(oddStr, leftStr, rightStr)) {
            return; // Don't update the display
        }

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strtoAdd);
            display.setSelection(cursorPos+1);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strtoAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }
    private boolean isValidDecimalInput(String oddStr, String leftStr, String rightStr) {
        // Check if the left part of the string already contains a decimal point
        if (leftStr.contains(".")) {
            // Find the last occurrence of the decimal point
            int lastDecimalIndex = leftStr.lastIndexOf(".");
            // Check if there are more than five characters after the last decimal point
            if (leftStr.length() - (lastDecimalIndex + 1) >= 5) {
                return false;
            }
        }

        // Check if the right part of the string contains an operator or a decimal point
        if (rightStr.contains("+") || rightStr.contains("-") || rightStr.contains("*")
                || rightStr.contains("/") || rightStr.contains(".") || rightStr.contains("^")) {
            return false;
        }

        return true;
    }
    private boolean isValidOperatorInput(String oddStr, String leftStr, String rightStr) {
        // Check if the right part of the string already ends with an operator
        if (rightStr.endsWith("+") || rightStr.endsWith("-") || rightStr.endsWith("*")
                || rightStr.endsWith("/") || rightStr.endsWith(".") || rightStr.endsWith("^")) {
            return false;
        }

        // Check if the left part of the string is empty or ends with an operator
        if (leftStr.isEmpty() || leftStr.endsWith("+") || leftStr.endsWith("-")
                || leftStr.endsWith("*") || leftStr.endsWith("/") || leftStr.endsWith(".")
                || leftStr.endsWith("^")) {
            return false;
        }

        return true;
    }
    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")
                || str.equals(".") || str.equals("^");
    }

    public void zeroBTN(View view){
        update("0");
    }
    public void oneBTN(View view){
        update("1");
    }
    public void twoBTN(View view){
        update("2");
    }
    public void threeBTN(View view){
        update("3");
    }
    public void fourBTN(View view){
        update("4");
    }
    public void fiveBTN(View view){
        update("5");
    }
    public void sixBTN(View view){
        update("6");
    }
    public void sevenBTN(View view){
        update("7");
    }
    public void eightBTN(View view){
        update("8");
    }
    public void nineBTN(View view){
        update("9");
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void addBTN(View view){
        update("+");
    }
    public void subtractBTN(View view){
        update("-");
    }
    public void divideBTN(View view){
        update("/");
    }
    public void multiplyBTN(View view){
        update("*");
    }
    public void decimalBTN(View view){
        update(".");
    }
    public void parBTN(View view){
        int curPos = display.getSelectionStart();
        int openPar=0;
        int closePar=0;
        int textLength=display.getText().length();

        for(int i=0; i<curPos; i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closePar+=1;
            }
        }

        if(openPar == closePar || display.getText().toString().substring(textLength-1,textLength).equals("(")){
            update("(");
        }
        else if(closePar < openPar && !display.getText().toString().substring(textLength-1,textLength).equals(")")){
            update(")");
        }
        display.setSelection(curPos+1);

    }
    public void expBTN(View view){
        update("^");
    }
    public void plusMinusBTN(View view){
        update("-");
    }
    public void equalBTN(View view){
        String userExpression=display.getText().toString();

        Expression exp=new Expression(userExpression);
        double result = exp.calculate();
        long longResult = (long) result; // Convert the result to a long

        // Check if the result is a whole number (no decimal places)
        if (result == longResult) {
            display.setText(String.valueOf(longResult));
        } else {
            display.setText(String.valueOf(result));
        }

        display.setSelection(display.getText().length());
//        String result=String.valueOf(exp.calculate());
//
//        display.setText(result);
//        display.setSelection(result.length());
    }
    public void backBTN(View view){
        int curPos=display.getSelectionStart();
        int textLen=display.getText().length();

        if(curPos != 0 && textLen !=0){
            SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
            selection.replace(curPos-1,curPos,"");
            display.setText(selection);
            display.setSelection(curPos-1);
        }
    }
}