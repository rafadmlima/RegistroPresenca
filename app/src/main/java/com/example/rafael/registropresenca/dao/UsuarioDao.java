package com.example.rafael.registropresenca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rafael.registropresenca.model.Usuario;
import com.example.rafael.registropresenca.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAFAEL on 29/04/2017.
 */

public class UsuarioDao {
    UsuarioDao dao;
    private Usuario usuario;
    private SQLiteDatabase db;
    private DBHelper helper;
    Cursor cursor;
    private String sql =    "CREATE TABLE IF NOT EXISTS USUARIO ( " +
                            "_id               INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                            "CODIGO            VARCHAR(10)," +
                            "NOME              VARCHAR(40), " +
                            "CPF               VARCHAR(11)," +
                            "FONE              VARCHAR(14)," +
                            "CNPJEMPRESA       VARCHAR(15)," +
                            "EMAIL             VARCHAR (255), " +
                            "CEP               VARCHAR(8)," +
                            "ENDERECO          VARCHAR(300), " +
                            "NUMERO            VARCHAR(8)," +
                            "BAIRRO            VARCHAR(40)," +
                            "CIDADE            VARCHAR(30)," +
                            "UF                VARCHAR(2)," +
                            "LATLNG            VARCHAR(25)," +
                            "FORMA             VARCHAR(5)," +
                            "FORMA_TITULO      VARCHAR(40)," +
                            "SENHA             VARCHAR(100)," +
                            "IMEI              VARCHAR(20)," +
                            "NIVEL             VARCHAR(5)" +
                            "); ";
    /*  long codigo, String nome, long cpf, long fone, long cnpjEmpresa, String email,
        long cep, String endereco, int numero, String bairro, String cidade, String UF,
        String[] latLng, String forma, String forma_titulo, String senha, String imei, long nivel
     */


       //instancia um objeto da classe DBHelper no construtor
    public UsuarioDao(Context contexto){
        dao = new UsuarioDao();
        helper = new DBHelper(contexto, sql,"usuario");
    }
    public UsuarioDao(){

    }
    //insert
    public long inserir(Usuario usuario){

        long rowid = 0;

        ContentValues valores = new ContentValues();
        //valores.put("id", 1);
        valores.put("codigo", String.valueOf(usuario.getCodigo()));
        valores.put("nome", usuario.getNome());

        db = helper.getWritableDatabase();

        try {
            rowid = db.insert(DBHelper.TABLE, null, valores);

        }catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return rowid;
    }
    //select
    public List<Usuario> selecionarTodos() {
        List<Usuario> lista = new ArrayList<Usuario>();

        db = helper.getReadableDatabase();

        cursor = db.query(DBHelper.TABLE,
                new String[] {"_id, nome, senha, imei, nivel"}, null, null, null, null, "_id");

        cursor.moveToFirst();
        while (! cursor.isAfterLast()) {
            usuario = new Usuario(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
            lista.add(usuario);
            cursor.moveToNext();
        }
        cursor.close();
        helper.close();

        return lista;
    }
    //update
    public int alterar(Usuario usuario) {

        ContentValues valores = new ContentValues();
        valores.put("id", usuario.getCodigo());
        valores.put("nome", usuario.getNome());
        valores.put("senha", usuario.getSenha());
        valores.put("imei", usuario.getImei());

        db = helper.getWritableDatabase();

        int rows = db.update(DBHelper.TABLE, valores, "codigo = " + usuario.getCodigo(), null);
        helper.close();

        return rows;
    }
    //delete
    public int excluir(int codigo) {
        db = helper.getWritableDatabase();
        int rows = db.delete(DBHelper.TABLE, "codigo = ?", new String[] {String.valueOf(codigo)});
        helper.close();
        return rows;
    }

    public boolean login(Usuario userAux ){
        //implementar busca ao webservice
        boolean flag = false;
        db = helper.getReadableDatabase();

        cursor = db.query(DBHelper.TABLE,
                new String[] {"_id, nome, senha, imei, nivel"}, null, null, null, null, "_id");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            usuario = new Usuario(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
            if (usuario.getNome().equals(userAux.getNome()) && (usuario.getSenha().equals(userAux.getSenha())))
            {
                flag = true;
            }
            cursor.moveToNext();
        }
        cursor.close();
        helper.close();

        return flag;
    }

    public boolean registrarPresenca(String op, Usuario usuario) {
        boolean flag = false;
        return flag;
    }




//    @Override
//    public void login(String nome, String senha, CallBack callBack) {
//        //implementar comunicacao com webservice
//
//    }
}
