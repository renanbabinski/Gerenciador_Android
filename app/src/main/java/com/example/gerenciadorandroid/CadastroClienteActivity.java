package com.example.gerenciadorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CadastroClienteActivity extends AppCompatActivity {

    private EditText nome;
    private EditText endereco;
    private EditText telefone;
    private EditText cpf;
    private EditText data;
    private ClienteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        nome = findViewById(R.id.editNome);
        endereco = findViewById(R.id.editEndereco);
        telefone = findViewById(R.id.editTelefone);
        cpf = findViewById(R.id.editCPF);
        data = findViewById(R.id.editDate);
        data.setInputType(InputType.TYPE_NULL);
        dao = new ClienteDAO(this);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(data);
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
        new DatePickerDialog(CadastroClienteActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void salvar(View view){
        Cliente c = new Cliente();
        c.setNome(nome.getText().toString());
        c.setEndereco(endereco.getText().toString());
        c.setTelefone(telefone.getText().toString());
        c.setCpf(cpf.getText().toString());
        c.setData(data.getText().toString());
        long id = dao.inserir(c);
        Toast.makeText(this, "Cliente inserido com id: " + id, Toast.LENGTH_SHORT).show();
    }









}
