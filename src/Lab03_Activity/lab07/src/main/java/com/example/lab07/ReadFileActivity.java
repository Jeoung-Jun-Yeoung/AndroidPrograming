package com.example.lab07;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        TextView textView = findViewById(R.id.fileResult);

        //내부저장공간 파일 접근
       // File file = new File(getFilesDir(),"myfile.txt");
       File file = new File(Environment.getStorageDirectory().getAbsolutePath()+"/mya/mf.txt");
        try{
            BufferedReader reader =  new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            textView.setText(buffer.toString());
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}