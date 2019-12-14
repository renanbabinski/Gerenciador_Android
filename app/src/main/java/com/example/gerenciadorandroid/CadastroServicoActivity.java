package com.example.gerenciadorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class CadastroServicoActivity extends AppCompatActivity {

    private List<Cliente> clientes;
    private ClienteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_servico);

        dao = new ClienteDAO(this);
        clientes = dao.obterTodos();

        Spinner spinner = findViewById(R.id.spinner_cliente);

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(CadastroServicoActivity.this,
                android.R.layout.simple_list_item_1, clientes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


}
