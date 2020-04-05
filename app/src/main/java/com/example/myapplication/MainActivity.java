package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText editText1,editText2;
    public TextView result;
    float r=0;
    public Button add,subtract,multiply,divide,conCal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.editText1);;
        editText2=(EditText)findViewById(R.id.editText2);
        result=(TextView)findViewById(R.id.result);
        add=(Button)findViewById(R.id.add);
        subtract=(Button)findViewById(R.id.subtract);
        multiply=(Button)findViewById(R.id.multiply);
        divide=(Button)findViewById(R.id.divide);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String num1 = editText1.getText().toString().trim();
                String num2 = editText2.getText().toString().trim();
                add.setEnabled(!num1.isEmpty() && !num2.isEmpty());
                multiply.setEnabled(!num1.isEmpty() && !num2.isEmpty());
                subtract.setEnabled(!num1.isEmpty() && !num2.isEmpty());
                divide.setEnabled(!num1.isEmpty() && !num2.isEmpty());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1,num2;
                if(editText1.getText().toString()=="")
                    num1=0;
                else
                    num1=Float.parseFloat(editText1.getText().toString());
                if(editText2.getText().toString()=="")
                    num2=0;
                else
                    num2=Float.parseFloat(editText2.getText().toString());
                r = num1 + num2;
                result.setText("" + String.valueOf(r));
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1,num2;
                num1=Float.parseFloat(editText1.getText().toString());
                num2=Float.parseFloat(editText2.getText().toString());
                r = num1 - num2;
                result.setText("" + String.valueOf(r));
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1,num2;
                num1=Float.parseFloat(editText1.getText().toString());
                num2=Float.parseFloat(editText2.getText().toString());
                r = num1 * num2;
                result.setText("" + String.valueOf(r));
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1,num2;
                num1=Float.parseFloat(editText1.getText().toString());
                num2=Float.parseFloat(editText2.getText().toString());
                r = num1 / num2;
                result.setText("" + String.valueOf(r));
            }
        });
        conCal=(Button)findViewById(R.id.conCal);
        conCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString()!="Result"){
                    editText1.setText(String.valueOf(r));
                    editText2.setText("");
                    result.setText("");
                }
            }
        });
    }
}
