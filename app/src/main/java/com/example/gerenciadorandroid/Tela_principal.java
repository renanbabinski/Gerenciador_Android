package com.example.gerenciadorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

    }
    public void gClientes(View view){
        Intent it = new Intent(this, ListarClientesActivity.class);
        startActivity(it);
    }
    public void gServicos(View view){
        Intent it = new Intent(this, CadastroServicoActivity.class);
        startActivity(it);
    }
}
