package com.insulin.netural.medico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
    String[] value;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Chat/");
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Medical Assistance");
        lista = (ListView) findViewById(R.id.lista);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                ArrayList<Map<String, String>> map = (ArrayList<Map<String, String>>) dataSnapshot.getValue();
                Gson gson = new Gson();

                if (map == null) {
                     map = new ArrayList<Map<String, String>>();

                } else {
                    value = new String[map.size()];


                   int i=0;
                   Boolean not=false;
                    for (Map<String, String> m : map) {
                        for (Map.Entry<String,String> entry : m.entrySet()){

                            if(entry.getKey().equals("lida") && String.valueOf(entry.getValue()).equals("false") ){
                                not=true;
                            }

                            if(entry.getKey().equals("nome")){
                                if(not){
                                    value[i] = entry.getValue().toString()+"                      *";
                                    not = false;
                                }else{
                                value[i]=entry.getValue().toString();}
                                i++;
                            }
                        }

                    }
                    atualiza();
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });


    }

    public void atualiza() {

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, value);


        // Assign adapter to ListView
        lista.setAdapter(adapter);

        // ListView Item Click Listener
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // ListView Clicked item value
                String itemValue = (String) value[position];

                //chamar nova e passar o argumento
                Intent intent = new Intent(MainActivity.this.getApplication(), Main2Activity.class);
                intent.putExtra("Pessoa", position);
                startActivity(intent);
            }

        });
    }

}




