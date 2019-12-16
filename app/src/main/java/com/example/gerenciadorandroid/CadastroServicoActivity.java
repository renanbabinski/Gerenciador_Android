package com.example.gerenciadorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CadastroServicoActivity extends AppCompatActivity {

    private List<Cliente> clientes;
    private ClienteDAO dao;
    private EditText dataEntrada;
    private EditText dataSaida;


    private Spinner nomeCliente;
    private EditText problemaRelatado;
    private EditText senha;
    private EditText tipo;
    private EditText marca;
    private EditText modelo;
    private EditText ns;
    private EditText acessorios;
    private EditText problemaEncontrado;
    private EditText solucao;
    private EditText tecnico;
    private ServicoDAO daos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_servico);


        daos = new ServicoDAO(this);
        dao = new ClienteDAO(this);
        clientes = dao.obterTodos();
        dataEntrada = findViewById(R.id.editDateEntrada);
        dataEntrada.setInputType(InputType.TYPE_NULL);
        dataSaida = findViewById(R.id.edit_DateSaida);
        dataSaida.setInputType(InputType.TYPE_NULL);

        problemaRelatado = findViewById(R.id.edit_problem);
        senha = findViewById(R.id.edit_password);
        tipo = findViewById(R.id.edit_tipo);
        marca = findViewById(R.id.edit_marca);
        modelo = findViewById(R.id.edit_model);
        ns = findViewById(R.id.edit_ns);
        acessorios = findViewById(R.id.edit_acessorios);
        problemaEncontrado = findViewById(R.id.edit_findproblems);
        solucao = findViewById(R.id.edit_solution);
        tecnico = findViewById(R.id.edit_tecnico);
        nomeCliente = findViewById(R.id.spin_cliente);

        Spinner spinner = findViewById(R.id.spin_cliente);

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(CadastroServicoActivity.this,
                android.R.layout.simple_list_item_1, clientes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        dataEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(dataEntrada);
            }
        });
        dataSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(dataSaida);
            }
        });
    }

    private void showDateDialog(final EditText date_in){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(CadastroServicoActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void salvar(View view){
        Servico s = new Servico();
        s.setCliente(nomeCliente.toString());
        s.setDataEntrada(dataEntrada.getText().toString());
        s.setDataSaida(dataSaida.getText().toString());
        s.setProblemaRelatado(problemaRelatado.getText().toString());
        s.setSenha(senha.getText().toString());
        s.setTipo(tipo.getText().toString());
        s.setMarca(marca.getText().toString());
        s.setModelo(modelo.getText().toString());
        s.setNs(ns.getText().toString());
        s.setAcessorios(acessorios.getText().toString());
        s.setProblemaEncontrado(problemaEncontrado.getText().toString());
        s.setSolucao(solucao.getText().toString());
        s.setTecnico(tecnico.getText().toString());
        long id = daos.inserir(s);
        Toast.makeText(this, "Serviço inserido com ID: "+ id, Toast.LENGTH_SHORT).show();
    }


}
