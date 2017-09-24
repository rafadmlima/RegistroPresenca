package com.example.rafael.registropresenca.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.util.Mensagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private List<String> nomes = new ArrayList<String>();
    FloatingActionButton fab;
    private String titleScreen = "Tela Administrativa";
    private Mensagem mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initiComponents();
            }

    public void initiComponents(){

        setTitle(titleScreen);
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }



}
