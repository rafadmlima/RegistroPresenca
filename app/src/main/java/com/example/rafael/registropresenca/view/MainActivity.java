package com.example.rafael.registropresenca.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.rafael.registropresenca.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> nomes = new ArrayList<String>();
    FloatingActionButton fab;
    private String titleScreen = "Tela Administrativa";

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
