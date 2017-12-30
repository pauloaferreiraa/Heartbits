package com.insulin.netural.medico;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_before extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    DatabaseReference myRefW;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);
        ActionBar ab = getSupportActionBar();
        ab.hide();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTitle);
        toolbar.setTitle(Dados.pessoa.getNome() + " Let's prepare ");
        toolbar.setSubtitle("your trip!");
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setTitleTextColor(Color.WHITE);



        myRef = database.getReference().child("Chat/" + Dados.nUser);

        TextView trip = (TextView) findViewById(R.id.trip);
        Destino destino = Dados.destino;

        trip.setText(destino.getNome() + " trip, " + destino.getDta_arrival() + " - " + destino.getDta_departure());

        Button tips = (Button) findViewById(R.id.tips);
        Button vacination = (Button) findViewById(R.id.vacination);
        Button kit = (Button) findViewById(R.id.kit);
        Button diseases = (Button) findViewById(R.id.diseases);

        editText = (EditText) findViewById(R.id.question);

        Button send = (Button) findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity_before.this.getApplication(), Bring_Human.class);
                intent.putExtra("msg",editText.getText().toString());
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_before.this.getApplication(), HealthTips.class);
                startActivity(intent);
            }
        });

        vacination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_before.this.getApplication(), Vacination.class);
                startActivity(intent);
            }
        });

        kit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_before.this.getApplication(), CommonDiseases.class);
                startActivity(intent);
            }
        });
    }
}
