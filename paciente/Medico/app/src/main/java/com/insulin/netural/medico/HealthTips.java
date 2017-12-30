package com.insulin.netural.medico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HealthTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        setTitle("Health Tips");

        TextView trip = (TextView) findViewById(R.id.trip);
        Destino destino= Dados.destino;

        trip.setText("Dream trip, "+destino.getDta_arrival()+" - "+destino.getDta_departure());

        Button food = (Button) findViewById(R.id.food);
        Button beverages = (Button) findViewById(R.id.vacination);
        Button insects = (Button) findViewById(R.id.kit);


        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        insects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
