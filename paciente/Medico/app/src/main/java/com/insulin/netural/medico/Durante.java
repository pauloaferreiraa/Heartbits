package com.insulin.netural.medico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Durante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_durante);



        setTitle(Dados.pessoa.getNome()+", you are in "+Dados.destino+"!");


        TextView trip = (TextView) findViewById(R.id.trip);
        Destino destino= Dados.destino;

        trip.setText(destino.getNome()+" trip, "+destino.getDta_arrival()+" - "+destino.getDta_departure());

        Button medicalHelp = (Button) findViewById(R.id.medicalHelp);
        Button food = (Button) findViewById(R.id.food);
        Button tips = (Button) findViewById(R.id.tips);
        Button diseases = (Button) findViewById(R.id.diseases);


        diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Durante.this.getApplication(), CommonDiseases.class);
                startActivity(intent);
            }
        });
    }
}
