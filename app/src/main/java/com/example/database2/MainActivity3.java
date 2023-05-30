package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity3 extends AppCompatActivity {
    double arr[];
    private TextView textView3, textView4;
    private EditText editTextText2, editTextText;
    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView3 = findViewById(R.id.textView3);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        button = findViewById(R.id.button);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1 = Float.parseFloat(editTextText.getText().toString());
                double num2 = Float.parseFloat(editTextText2.getText().toString());
                //str(tan((float(data)/ 2 * pi/180))* float(data2))
                double res = Math.tan(num2 / 2 * Math.PI / 180) * num1;
                String result = String.format("%.3f", res);
                textView3.setText(String.valueOf(result));

            }
        });

    }
    public void startNewActivity(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);}
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

