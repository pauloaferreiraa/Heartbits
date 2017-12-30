package com.insulin.netural.medico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    String[] value;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    DatabaseReference myRefW;
    DatabaseReference myRefN;
    List<Mensagem> mensagens = new ArrayList<>();
    ListView historico;
    EditText editText;
    Button enviar;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Medical Assistance");
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("Pessoa");
        historico = (ListView) findViewById(R.id.historico);
        myRef = database.getReference().child("Chat/" + pos);
        editText = findViewById(R.id.editText);
        enviar = findViewById(R.id.button);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mensagens == null) {
                    mensagens = new ArrayList<>();
                }

                myRefW = database.getReference().child("Chat/" + pos).child("Chat/").child(mensagens.size() + "/").child("msg/");

                myRefW.setValue(editText.getText().toString());
                myRefW = database.getReference().child("Chat/" + pos).child("Chat/").child(mensagens.size() + "/").child("user/");
                myRefW.setValue("medico");

                editText.setText("");

            }
        });

        // Defined Array values to show in ListView


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Gson gson = new Gson();

                if (map == null) {
                    map = new HashMap<String, Object>();

                } else {

                    mensagens.clear();
                    //lista mensagens 0 -> msg user
                    ArrayList<Map<String, String>> listMsgUser = (ArrayList<Map<String, String>>) map.get("Chat");
                    if (listMsgUser != null) {
                        for (Map<String, String> a : listMsgUser) {
                            parserMap(a);
                        }

                    }
                }
                myRefN = database.getReference().child("Chat/" + pos).child("lida/");
                myRefN.setValue("true");
                atualiza();


            }

            public void onCancelled(DatabaseError error) {


            }

        });

    }

    private void parserMap(Map<String, String> mapa) {

        String user = mapa.get("user");
        String txt = mapa.get("msg");
        mensagens.add(new Mensagem(user, txt));

    }


    public void atualiza() {

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        value = new String[mensagens.size()];
        int i = 0;
        for (Mensagem m : mensagens) {
            value[i] = m.toString();
            i++;
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, value);


        // Assign adapter to ListView
        historico.setAdapter(adapter1);

        // ListView Item Click Listener
        historico.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // ListView Clicked item value
                String itemValue = (String) value[position];


            }

        });
    }


}