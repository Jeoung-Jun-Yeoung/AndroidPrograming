package com.example.junyeoungjeong_20170819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdditonActivity extends AppCompatActivity implements View.OnClickListener{

    EditText pr_ed;
    EditText sol_ed;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additon);

        btn = findViewById(R.id.btn_pr_add);
        pr_ed = findViewById(R.id.problem_insert);
        sol_ed = findViewById(R.id.sloved_insert);


        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String title = pr_ed.getText().toString();
        String content = sol_ed.getText().toString();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo (title, content) values (?,?)", new String[]{title,content});
        db.close();
        Toast.makeText(getApplicationContext(), "문제가 등록되었습니다.", Toast.LENGTH_LONG).show();
        finish();
    }
}
