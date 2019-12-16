package com.example.gerenciadorandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ServicoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ServicoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Servico servico){
        ContentValues values = new ContentValues();
        values.put("cliente", "teste");
        values.put("dataEntrada", servico.getDataEntrada());
        values.put("dataSaida", servico.getDataSaida());
        values.put("problemarelatado", servico.getProblemaRelatado());
        values.put("senha", servico.getSenha());
        values.put("tipo", servico.getTipo());
        values.put("marca", servico.getMarca());
        values.put("modelo", servico.getModelo());
        values.put("ns", servico.getNs());
        values.put("acessorios", servico.getAcessorios());
        values.put("problemasencontrados", servico.getProblemaEncontrado());
        values.put("solucao", servico.getSolucao());
        values.put("tecnico", servico.getTecnico());
        return banco.insert("servico", null, values);
    }
}
