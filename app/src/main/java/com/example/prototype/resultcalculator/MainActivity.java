package com.example.prototype.resultcalculator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.example.prototype.Calculator.CaclutorTwo;
import com.example.prototype.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {

    //LinearLayout parentLayout;
    ScrollView parent;

    TextInputLayout EditText_W,EditText_L,EditText_X,EditText_Elasicity,EditText_I;

    TableLayout tableLayout,tableLayout2;

    LinearLayout linearLayout;

    TextView result_one, result_two, result_three, result_four,result_five,result_six,result_seven;
    EditText EditText_ww,EditText_xx,EditText_ll,EditText_e,EditText_i, EditText_fck,EditText_B,EditText_D;

    TextView textView_X;

    Button btn1;

    SeekBar seekBar_L;



    Button button;
    ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);
        parent=findViewById(R.id.parentLayout);

//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.diagram);
//        imageView=findViewById(R.id.imageView);
//        imageView.setImageBitmap(bitmap);

        result_one=findViewById(R.id.result_one);
        result_two=findViewById(R.id.result_two);
        result_three=findViewById(R.id.result_three);
        result_four=findViewById(R.id.result_four);
        result_five=findViewById(R.id.result_five);
        result_six=findViewById(R.id.result_six);
        result_seven=findViewById(R.id.result_seven);

        EditText_W=findViewById(R.id.EditText_W);
        EditText_ww=EditText_W.getEditText();
        EditText_L=findViewById(R.id.EditText_L);
        EditText_ll=EditText_L.getEditText();
        EditText_X=findViewById(R.id.EditText_X);
        EditText_xx=EditText_X.getEditText();



        EditText_Elasicity=findViewById(R.id.EditText_Elasticity);
        EditText_e=EditText_Elasicity.getEditText();
        EditText_I=findViewById(R.id.EditText_Inertia);
        EditText_i=EditText_I.getEditText();
        tableLayout=findViewById(R.id.tableLayout);
        tableLayout2=findViewById(R.id.tableLayout2);
        linearLayout=findViewById(R.id.linearLayout_additional);

        seekBar_L=findViewById(R.id.SeekBar_L);





        seekBar_L.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String s = Objects.requireNonNull(EditText_L.getEditText()).getText().toString();
                if(s.equals("")&&s.isEmpty()){
                seekBar_L.setEnabled(false);
                Toast.makeText(MainActivity.this, "Fill the Length(L)", Toast.LENGTH_SHORT).show();
                }else{
                    seekBar.setEnabled(true);
                    float value = Float.parseFloat(s);
                    float newValue = value * progress / seekBar.getMax();
                    int roundValue = Math.round(newValue);
                   // EditText_X.setText(String.format("%.1f", newValue));
//                    EditText_X.getEditText(String.valueOf(roundValue));
                    EditText_xx.setText(String.valueOf(roundValue));
                }




            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        EditText_ll.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this case
            }

            @Override
            public void afterTextChanged(Editable s) {
                String L_value = s.toString();
                if (L_value.isEmpty()) {
                    EditText_xx.setText("");
                    seekBar_L.setProgress(0);// Set empty value if EditText_L is empty
                } else {
                    float value = Float.parseFloat(L_value);
                    seekBar_L.setMax((int) value);
                    seekBar_L.setProgress((int) value / 2);
                    if (value % 2 == 0) {
                        int result_1 = (int) (value / 2);
                        EditText_xx.setText(String.valueOf(result_1));
                    } else {
                        float result = value / 2.0f;
                        EditText_xx.setText(String.valueOf(result));
                    }
                }
            }
        });
        if (EditText_xx != null) {
            EditText_xx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "use seekbar", Toast.LENGTH_SHORT).show();
                }
            });
        }



    }



    public void CalculateResult_One(View v){
        ResultCalculator.calculateResultOne(MainActivity.this,EditText_ww,EditText_ll,EditText_xx,result_one,result_two,result_three,result_four,result_five);
        tableLayout.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);

    }

    public void CalculateResult_Two(View view) {
        ResultCalculator.calculateResultTwo(MainActivity.this, EditText_ww, EditText_ll, EditText_xx, EditText_fck, EditText_B, EditText_D,EditText_e,EditText_i,result_six, result_seven);
        tableLayout2.setVisibility(View.VISIBLE);
    }



}
