package com.example.junyeoungjeong_20170819;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {
    String arrayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = findViewById(R.id.list);

        ArrayList<HashMap <String,String>> simpleData = new ArrayList<>();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_memo",null);
        while (cursor.moveToNext()){
            HashMap<String,String> map = new HashMap<>();
            map.put("title",cursor.getString(0));
            map.put("content",cursor.getString(1));
            simpleData.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, simpleData, android.R.layout.simple_list_item_2,new String[]{"title", "content"},
                new int []{android.R.id.text1,android.R.id.text2});
        list.setAdapter(adapter);
        db.close();




    }
}
