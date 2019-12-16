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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CadastroServicoActivity extends AppCompatActivity {

    private List<Cliente> clientes;
    private ClienteDAO dao;
    private EditText dataEntrada;
    private EditText dataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_servico);

        dao = new ClienteDAO(this);
        clientes = dao.obterTodos();
        dataEntrada = findViewById(R.id.editDateEntrada);
        dataEntrada.setInputType(InputType.TYPE_NULL);
        dataSaida = findViewById(R.id.edit_DateSaida);
        dataSaida.setInputType(InputType.TYPE_NULL);

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


}
