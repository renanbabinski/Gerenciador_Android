package com.example.gerenciadorandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table servico(id integer primary key autoincrement," +
                "cliente varchar(50), dataEntrada varchar(50), dataSaida varchar(50), problemarelatado varchar(50), senha varchar(50), " +
                "tipo varchar(50), marca varchar(50), modelo varchar(50), ns varchar(50), acessorios varchar(50), problemasencontrados varchar(50), " +
                "solucao varchar(50), tecnico varchar(50))");
        db.execSQL("create table cliente(id integer primary key autoincrement," +
                "nome varchar(50), endereco varchar(100), telefone varchar(50), cpf varchar(50), data date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
