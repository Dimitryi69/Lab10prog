package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab10.Adapter.DataAdapter;
import com.example.lab10.Room.Contact;
import com.example.lab10.Room.ContactDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contactList;
    public EditText ePhone, eName, eDesc;
    ContactDatabase db;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ePhone = findViewById(R.id.edPhone);
        eDesc = findViewById(R.id.edDesc);
        eName = findViewById(R.id.edName);
        db = App.getInstance().getDatabase();
        if (db.getContactDao().getAll().isEmpty())
        {
            contactList = new ArrayList<>();
        }
        else {
            contactList = db.getContactDao().getAll();
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ContactL);
        adapter = new DataAdapter(this, contactList);
        recyclerView.setAdapter(adapter);
    }

    public void onClickAdd(View view) {
        Contact con = new Contact(eName.getText().toString(), ePhone.getText().toString(), eDesc.getText().toString());
        db.getContactDao().insert(con);
        adapter.setList(db.getContactDao().getAll());
        adapter.notifyDataSetChanged();
    }

    public void onClickDelete(View view)
    {
        Contact contact = db.getContactDao().getById(eName.getText().toString());
        db.getContactDao().delete(contact);
        adapter.setList(db.getContactDao().getAll());
        adapter.notifyDataSetChanged();
    }

    public void onClickUpdate(View view) {
        Contact contact = db.getContactDao().getById(eName.getText().toString());
        if(contact == null)
        {
            Toast.makeText(this, "There is no such name(id)", Toast.LENGTH_SHORT).show();
        }
        else
        {
            contact.setDescription(eDesc.getText().toString());
            contact.setPhone(ePhone.getText().toString());
            db.getContactDao().update(contact);
            adapter.setList(db.getContactDao().getAll());
            adapter.notifyDataSetChanged();
        }
    }
}