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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
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


    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_first_option){
            mensagem.toast("Primeira opcao");
        } else if (id == R.id.nav_second_option){
            mensagem.toast("Segunda opcao");
        }else if (id == R.id.nav_third_option){
            mensagem.toast("Terceira opcao");
        }else if (id == R.id.nav_exit){
            mensagem.toast("Voce escolheu sair");
        }


        return false;
    }
}
