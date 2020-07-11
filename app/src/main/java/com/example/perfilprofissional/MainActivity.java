package com.example.perfilprofissional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //Instanciacao da classe sObjetosTela
    private sObjetosTela soObjetosTela=new sObjetosTela();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Relacionando o arquivo Java com xml
        this.soObjetosTela.btn_navegacao= findViewById(R.id.btn_navegacao);
        //Ativar o listener do botão de navegação
        this.soObjetosTela.btn_navegacao.setOnNavigationItemSelectedListener(navListener);
        //Colocar o fragmento profissional como o inicial
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmento,
                new ProfissionalFragment()).commit();
    }
    private static class sObjetosTela{
        BottomNavigationView btn_navegacao;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragmentoSelecionado = null;
                    switch (item.getItemId()){
                        case R.id.nav_profissional:
                            fragmentoSelecionado = new ProfissionalFragment(); break;
                        case R.id.nav_experiencia:
                            fragmentoSelecionado= new ExperienciaFragment(); break;
                        case R.id.nav_formacao:
                            fragmentoSelecionado = new FormacaoFragment(); break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmento,
                            fragmentoSelecionado).commit();
                    return true;
                }
            };

}