package com.example.gerenciadorandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("telefone", cliente.getTelefone());
        values.put("cpf", cliente.getCpf());
        values.put("data", cliente.getData());
        return banco.insert("cliente", null, values);
    }


    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[]{"id","nome","endereco","telefone","cpf","data"},
                null,null,null,null,null);
        while(cursor.moveToNext()){
            Cliente c = new Cliente();
            c.setId(cursor.getInt(0));
            c.setNome(cursor.getString(1));
            c.setEndereco(cursor.getString(2));
            c.setTelefone(cursor.getString(3));
            c.setCpf(cursor.getString(4));
            c.setData(cursor.getString(5));
            clientes.add(c);
        }
        return clientes;
    }

    public void excluir(Cliente c){
        banco.delete("cliente", "id = ?", new String[]{c.getId().toString()});
    }

    public void atualizar(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("telefone", cliente.getTelefone());
        values.put("cpf", cliente.getCpf());
        values.put("data", cliente.getData());
        banco.update("cliente", values, "id = ?", new String[]{cliente.getId().toString()});
    }







}
