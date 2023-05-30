package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MainActivity2 extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // получаем директорию, в которой находится файл
        File dir = getApplicationContext().getFilesDir();
// указываем имя файла
        String fileName = "example.txt";
// создаем объект файла
        File file = new File(dir, fileName);
        StringBuilder sb = new StringBuilder();
        {
        try {
            // открываем поток для чтения из файла
            FileInputStream fis = new FileInputStream(file);
            // создаем буфер для чтения данных
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            // читаем данные построчно
            String line, arr[];
            double cnt=0;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            // закрываем потоки
            reader.close();
            fis.close();
            // выводим сообщение в Toast
            Toast.makeText(getApplicationContext(), "Прочитано: " + sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // выводим сообщение об ошибке в Toast
            Toast.makeText(getApplicationContext(), "Ошибка чтения файла", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }}
        listView = findViewById(R.id.list_view);
        // определяем массив типа String
        String[] words = sb.toString().split("\n");
        final String[] catNames = words;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, catNames);

        listView.setAdapter(adapter);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void startNewActivity2(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}