package com.example.reginelae.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Contacts");

    EditText Etname, Etnumber;
    Button BtnAddContact, DeleteContacts;

    String name;
    Contacts contact;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Etname = (EditText) findViewById(R.id.name);
        Etnumber = (EditText) findViewById(R.id.number);
        BtnAddContact = (Button) findViewById(R.id.add);
        DeleteContacts = (Button) findViewById(R.id.delete);

        ArrayList<Contacts> values = new ArrayList<>();
        final ArrayAdapter<Contacts> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);

        listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);


        DeleteContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact(myRef);
            }
        });


        BtnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number;
                appendContact(myRef);

            }
        });
    }



    private void appendContact(DatabaseReference AddContacts) {

        String number;
        String name;

        number = Etnumber.getText().toString();
        name = Etname.getText().toString();

        String key = AddContacts.push().getKey();
        Contacts contact = new Contacts(name, number);
        AddContacts.child(key).setValue(contact);

        listview = (ListView) findViewById(R.id.list_view);
        ListAdapter adapter = null;
        listview.setAdapter(adapter);
    }


    private void deleteContact(final DatabaseReference AddContacts) {
        Query deleteQuery = AddContacts.orderByChild("Contacts").equalTo(null);
        deleteQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().removeValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("MainActivity", "deleteItem()- onCancelled(), error" + databaseError.getMessage());
            }
        });

    }

}
