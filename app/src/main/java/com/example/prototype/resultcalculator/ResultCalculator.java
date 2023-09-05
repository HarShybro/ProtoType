package com.example.prototype.resultcalculator;


import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ResultCalculator {
    public static void calculateResultOne(Context context, EditText editTextW, EditText editTextL, EditText editTextX, TextView resultOne, TextView resultTwo,
                                          TextView resultThree, TextView resultFour, TextView resultFive){



        String w = editTextW.getText().toString();
        String l = editTextL.getText().toString();
        String x = editTextX.getText().toString();

        if (!w.isEmpty() && !l.isEmpty() && !x.isEmpty()) {
            float ww = Float.parseFloat(w);
            float ll = Float.parseFloat(l);
            float xx = Float.parseFloat(x);

            float result = ww * ll;
            float result2 = (ww * ll) / 2;
            float result3 = ww * (ll / 2 - xx);
            float result4 = ((ww * xx) / 2) * (ll - xx);
            float result5 = (ww * (ll * ll)) / 8;

            resultOne.setText(String.format("%.1f", result) + " KN");
            resultTwo.setText(String.format("%.1f", result2)+" KN");
            resultThree.setText(String.format("%.1f", result3)+" KN");
            resultFour.setText(String.format("%.1f", result4)+" KN-m");
            resultFive.setText(String.format("%.1f", result5)+" KN-m");
        } else {
            Toast.makeText(context,"Fill in all the values", Toast.LENGTH_SHORT).show();
        }
        editTextW.clearFocus();
        editTextL.clearFocus();
        editTextX.clearFocus();

        // Hide the soft keyboard
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextW.getWindowToken(), 0);

    }

    public static void calculateResultTwo(Context context,EditText editTextW,EditText editTextL,EditText editTextX,EditText editTextFck,
                                   EditText editTextB,EditText editTextD,EditText EditText_Elasicity,EditText EditText_I,TextView resultSix,TextView resultSeven){

    String w = editTextW.getText().toString();
    String l = editTextL.getText().toString();
    String x = editTextX.getText().toString();
    //String fck = editTextFck.getText().toString();
    //String  b = editTextB.getText().toString();
    //String d = editTextD.getText().toString();
    String elasicity=EditText_Elasicity.getText().toString();
    String i=EditText_I.getText().toString();

        if (!w.isEmpty() && !l.isEmpty() && !x.isEmpty() && !elasicity.isEmpty() && !i.isEmpty()) {
        //float fckk = Float.parseFloat(fck);
        //float bb = Float.parseFloat(b);
        //float dd = Float.parseFloat(d);
        float ww = Float.parseFloat(w);
        float ll = Float.parseFloat(l);
        float xx = Float.parseFloat(x);
        float elasicityy =Float.parseFloat(elasicity);
        float ii= Float.parseFloat(i);

        //float E = 5000 * (float) Math.sqrt(fckk);
       // float I = bb * (dd * dd * dd) / 12;

        float result6 = (float) ((5 * (ww * Math.pow(ll,4))) / (384 * elasicityy * ii));
        float result7 = ((ww * xx) / (24 * elasicityy * ii)) * ((ll * ll * ll) - 2 * ll * (xx * xx) + (xx * xx * xx));

        resultSix.setText(String.valueOf(String.format("%.1f",result6)+" mm"));
        resultSeven.setText(String.valueOf(String.format("%.1f",result7)+" mm"));
    } else {
        Toast.makeText(context, "Fill all the values", Toast.LENGTH_SHORT).show();
    }
        EditText_Elasicity.clearFocus();
        EditText_I.clearFocus();
        // Hide the soft keyboard
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(EditText_Elasicity.getWindowToken(), 0);
}
}
