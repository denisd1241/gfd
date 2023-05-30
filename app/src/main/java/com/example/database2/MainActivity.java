package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double arr[];
    double res;
    private TextView textView3, textView4;
    private EditText editTextText2, editTextText3;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editTextText3);
        String text = editText.getText().toString();

        button = findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраняем информацию из поля editTextText3

                // получаем директорию для сохранения файла
                File dir = getApplicationContext().getFilesDir();
                String fileName = "example";

// формируем имя файла в виде текущей даты и времени

// создаем объект файла
                File file = new File(dir, fileName + ".txt");

                try {
                    // открываем поток для записи в файл
                    FileOutputStream fos = new FileOutputStream(file);
                    // записываем информацию из поля в файл
                    String text = editText.getText().toString();
                    fos.write((text + "\n").getBytes());
                    // закрываем поток
                    fos.close();
                    // выводим сообщение об успешном сохранении в Toast
                    Toast.makeText(getApplicationContext(), "Файл успешно сохранен", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    // выводим сообщение об ошибке в Toast
                    Toast.makeText(getApplicationContext(), "Ошибка сохранения файла", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                // здесь можно выполнить дополнительные действия с сохраненной информацией
            }
        });

    }
    public void startNewActivity(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
    public void startNewActivity2(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}