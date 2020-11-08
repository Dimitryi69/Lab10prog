package com.example.lab10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.R;
import com.example.lab10.Room.Contact;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Contact> phones;

    public DataAdapter(Context context, List<Contact> phones) {
        this.phones = phones;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Contact phone = phones.get(position);
        holder.nameView.setText(phone.getFullName());
        holder.phoneView.setText(phone.getPhone());
        holder.descView.setText(phone.getDescription());
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    public void setList(List<Contact> lcon) {
        phones = lcon;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, phoneView, descView;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            phoneView = (TextView) view.findViewById(R.id.phone);
            descView = (TextView) view.findViewById(R.id.desc);
        }
    }
}
