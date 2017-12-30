package com.insulin.netural.medico;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hello extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    ArrayList<Map<String, Object>> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hello);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        myRef = database.getReference().child("Chat/");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTitle);
        toolbar.setTitle("Hello!");
        toolbar.setTitleTextColor(Color.WHITE);

        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nomeEt = (EditText) findViewById(R.id.name);
                EditText ageEt = (EditText) findViewById(R.id.age);
                EditText sexEt = (EditText) findViewById(R.id.sex);

                String nome = nomeEt.getText().toString();
                String age = ageEt.getText().toString();
                String sex = sexEt.getText().toString();

                Dados.addPessoa(new Pessoa(nome, age, sex));

                Dados.nUser = map.size();

                myRef = database.getReference().child("Chat/" + Dados.nUser).child("lida/");
                myRef.setValue("true");
                myRef = database.getReference().child("Chat/" + Dados.nUser).child("nome/");
                myRef.setValue(nome);


                Intent intent = new Intent(Hello.this.getApplication(), Destination.class);
                startActivity(intent);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                map = (ArrayList<Map<String, Object>>) dataSnapshot.getValue();
                if (map == null)
                    map = new ArrayList<Map<String, Object>>();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
