package com.example.rafael.registropresenca.util;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.model.Registro;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by RAFAEL on 20/05/2017.
 */

public class ListaAdapterRegistro extends BaseAdapter {
    private Context context;
    private List<Registro> lista;
    private TextView lblOperacao;
    private TextView lblHorario;
    private TextView lblTrabalhado;
    private TextView userName;
    private CircleImageView imgListUser;

    public ListaAdapterRegistro(Context context, List<Registro> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() { return lista.size(); }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        convertView  = LayoutInflater.from(context).inflate(R.layout.list_registro,parent, false);

        Registro registro = (Registro) getItem(position);

        lblOperacao = (TextView) convertView.findViewById(R.id.lblOperacao);
        lblHorario = (TextView) convertView.findViewById(R.id.lblHorario);
        lblTrabalhado = (TextView) convertView.findViewById(R.id.lblTrabalhado);
        imgListUser = (CircleImageView) convertView.findViewById(R.id.imgListUser);

        if(registro.getOperacao().equals("E")){
            convertView.setBackgroundColor(Color.parseColor("#E6E7E8"));
            lblOperacao.setText("ENTRADA");
            lblTrabalhado.setText("--:--:--");
        }else{
            convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            lblOperacao.setText("SAÍDA");
            lblTrabalhado.setText(String.valueOf(registro.getTrabalhado()));
        }

        lblHorario.setText(String.valueOf(registro.getHorario()));

        DadosUsuario.setTotalTrabalhado(registro.getTtTrabalhado());

        return  convertView;
    }

}
