package com.example.reginelae.firebase;

import android.os.Bundle;
import android.provider.Contacts;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Contacts");

    EditText etName, etNumber;
    Button btnAdd, btnSearch, btnDelete;
    ListView listView;

    String name;
    Contacts contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.name);
        etNumber = (EditText)findViewById(R.id.number);
        btnAdd = (Button) findViewById(R.id.add);
        btnSearch = (Button) findViewById(R.id.search);
        btnDelete = (Button) findViewById(R.id.delete);

        ArrayList<Contacts> values = new ArrayList<>();
        final ArrayAdapter<Contacts> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);





//        Firebase.setAndroidContext(this);
//        Firebase myFirebase = new Firebase("https://blazing-torch-3465.firebaseio.com/");
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        friendsDatabase = FirebaseDatabase
//
//        myRef.setValue("Hello, world!");
//        myRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
//            @Override
//            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is:" + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//        });
//
//

//
//        myFirebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                System.out.println(+ snapshot.getChildrenCount());
//                for (DataSnapshot postSnapshot: snapshot.getChildren+ " - " + post.getTitle());
//            }()) {
//                    BlogPost post= postSnapshot.getValue(BlogPost.class);
//                    System.out.println(post.getAuthor()
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                System.out.println("The read failed: " + firebaseError.getMessage());
//            }
//        });
//
//        myFirebase.addChildEventListener(new ChildEventListener() {
//            // Retrieve new posts as they are added to the database
//            @Override
//            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
//                BlogPost newPost = snapshot.getValue(BlogPost.class);
//                System.out.println("Author: " + newPost.getAuthor());
//                System.out.println("Title: " + newPost.getTitle());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//
//            //... ChildEventListener also defines onChildChanged, onChildRemoved,
//            //    onChildMoved and onCanceled, covered in later sections.
//        });

//        myFirebase.child("lastname").setValue("soco");
//        myFirebase.child("firstname").setValue("regine");
//
//      setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

    }
}
