package com.example.rafael.registropresenca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rafael.registropresenca.model.Registro;
import com.example.rafael.registropresenca.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAFAEL on 12/08/2017.
 */

public class RegistroDao {
    RegistroDao dao;
    private Registro registro;
    private SQLiteDatabase db;
    private DBHelper helper;
    Cursor cursor;
    private String sql =    "CREATE TABLE IF NOT EXISTS REGISTRO ( " +
            "_id               INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "EMPRESA           VARCHAR(14)," +
            "COLABORADOR       VARCHAR(11), " +
            "DATA              VARCHAR(10)," +
            "DATA_REUNIAO      VARCHAR(10)," +
            "OPERACAO          VARCHAR(1)," +
            "MOTIVO            VARCHAR (255), " +
            "HORARIO           VARCHAR(8)," +
            "STATUS            VARCHAR(1), " +
            "TRABALHADO        VARCHAR(8)," +
            "COORDENADAS       VARCHAR(20)," +
            "TT_TRABALHADO     VARCHAR(8)," +
            "); ";

    //instancia um objeto da classe DBHelper no construtor
    public RegistroDao(Context contexto){
        dao = new RegistroDao();
        helper = new DBHelper(contexto, sql, "registro");
    }
    public RegistroDao() {

    }
    //insert
    public long inserir(Registro registro){

        long rowid = 0;

        ContentValues valores = new ContentValues();
        //valores.put("id", 1);
        valores.put("empresa", registro.getEmpresa());
        valores.put("colaborador", registro.getColaborador());
        valores.put("data",registro.getData());
        valores.put("data_reuniao", registro.getData_reuniao());
        valores.put("operacao", registro.getOperacao());
        valores.put("motivo", registro.getMotivo());
        valores.put("horario", registro.getHorario());
        valores.put("status", registro.getStatus());
        valores.put("trabalhado", registro.getTrabalhado());
        valores.put("coordenadas", registro.getCoordenadas());
        valores.put("ttTrabalhado", registro.getTtTrabalhado());

        db = helper.getWritableDatabase();

        try {
            rowid = db.insert(DBHelper.TABLE, null, valores);

        }catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return rowid;
    }
    //select
    public List<Registro> selecionarTodos() {
        List<Registro> lista = new ArrayList<Registro>();

        db = helper.getReadableDatabase();

        cursor = db.query(DBHelper.TABLE,
                new String[] {"id, empresa, colaborador, data, data_reuniao", "operacao", "motivo", "horario", "status", "trabalhado", "coordenadas", "ttTrabalhado"}, null, null, null, null, "id");

        cursor.moveToFirst();
        while (! cursor.isAfterLast()) {
            registro = new Registro(cursor.getLong(0),
                                    cursor.getLong(1),
                                    cursor.getLong(2),
                                    cursor.getString(3),
                                    cursor.getString(4),
                                    cursor.getString(5),
                                    cursor.getString(6),
                                    cursor.getString(7),
                                    cursor.getString(8),
                                    cursor.getString(9),
                                    cursor.getString(10),
                                    cursor.getString(11) );
            lista.add(registro);
            cursor.moveToNext();
        }
        cursor.close();
        helper.close();

        return lista;
    }
}
