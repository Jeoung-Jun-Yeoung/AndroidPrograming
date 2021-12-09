package com.example.junyeoungjeong_20170819;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int db_version = 1;
    public DBHelper(Context context) {
        super(context, "memodb", null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSQL = "create table tb_memo (" + "_id integer primary key autoincrement, "
                +"title, " +
                "content)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i == db_version){
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }
}
