package com.example.gerenciadorandroid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {
    private List<Cliente> clientes;
    private Activity activity;
    public ClienteAdapter(Activity activity, List<Cliente> clientes) {
        this.activity = activity;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item, parent, false);

        TextView nome = v.findViewById(R.id.txt_nome);
        TextView endereco = v.findViewById(R.id.txt_endereco);
        TextView telefone = v.findViewById(R.id.txt_telefone);
        TextView cpf = v.findViewById(R.id.txt_cpf);
        TextView data = v.findViewById(R.id.txt_data);

        Cliente c = clientes.get(position);

        nome.setText(c.getNome());
        endereco.setText(c.getEndereco());
        telefone.setText(c.getTelefone());
        cpf.setText(c.getCpf());
        data.setText(c.getData());


        return v;
    }
}
