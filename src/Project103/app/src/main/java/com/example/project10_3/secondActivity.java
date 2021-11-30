package com.example.project10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        setTitle("두번째 액티비티");

        Button back_btn = findViewById(R.id.btn_return);

        Intent intent = getIntent();

        int rst = 0;
        char type = (intent.getCharExtra("rst",'a'));

        if(type == '+'){
            rst = intent.getIntExtra("num1",0) +
                    intent.getIntExtra("num2",0);
        }
        else if(type == '-'){
            rst = intent.getIntExtra("num1",0) -
                    intent.getIntExtra("num2",0);
        }
        else if(type == '*'){
            rst = intent.getIntExtra("num1",0) *
                    intent.getIntExtra("num2",0);
        }
        else if(type == '/'){
            rst = intent.getIntExtra("num1",0) /
                    intent.getIntExtra("num2",0);
        }

        int finalRst = rst;

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rst_intent = new Intent(getApplicationContext(),MainActivity.class);
                rst_intent.putExtra("rst", finalRst);
                setResult(RESULT_OK,rst_intent);
                finish();
            }
        });

    }
}