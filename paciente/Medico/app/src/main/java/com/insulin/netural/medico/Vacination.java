package com.insulin.netural.medico;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Vacination extends AppCompatActivity {
    String peru= "Courses or boosters usually advised: Hepatitis A; Tetanus; Typhoid. \n\n" +
            "Other vaccines to consider: Diphtheria; Rabies; Yellow Fever. \n\n" +
            "No yellow fever vaccination certificate required for this country.";
    String india = "Courses or boosters usually advised: Diphtheria; Hepatitis A; Tetanus; Typhoid. \n\n" +
            "Ohter vaccines to consider: Cholera; Hepatitis B; Japanase Encephalitis; Rabies. \n\n" +
            "Yellow fever vaccination certificate requirements for India are specific and quite lengthy; read the full\n" +
            " details via the WHO website.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacination);
        ActionBar ab = getSupportActionBar();
        ab.hide();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTitle);
        toolbar.setTitle("Vacination");
        toolbar.setTitleTextColor(Color.WHITE);

        TextView trip = (TextView) findViewById(R.id.trip);
        Destino destino= Dados.destino;

        trip.setText("Dream trip, "+destino.getDta_arrival()+" - "+destino.getDta_departure());

        String texto;
        if(destino.getCountrySp().equals("Peru")){
            texto=peru;
        }else{
            texto=india;
        }
        TextView vacination = (TextView) findViewById(R.id.textVacination);
        vacination.setText(texto);

    }
}
