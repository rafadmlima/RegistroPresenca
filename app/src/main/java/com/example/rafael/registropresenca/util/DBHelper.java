package com.example.rafael.registropresenca.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by RAFAEL on 25/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "registroPonto.db";
    private static final int DATABASE_VERSION = 1;
    public static String SQL = "";
    public static String TABLE = "";

    public DBHelper(Context context, String sql, String tabela) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.SQL = sql;
        if(!tabela.equals("")){
            this.TABLE = tabela;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        *
        * cria a tabela, caso não exista ainda
        *
        *
        * */
        db.execSQL(SQL);
        System.out.println(SQL);
        System.out.println("|TABELA "+TABLE+" CRIADA|");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //atualiza o bd caso o numero de versão seja incrementado
        Log.w(DBHelper.class.getName(), "Atualização de versão do BD: " +
                oldVersion + " para " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
        System.out.println("|TABELA ATUALIZADA|");
    }
}
