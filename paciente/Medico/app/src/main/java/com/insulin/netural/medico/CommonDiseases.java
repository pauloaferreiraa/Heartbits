package com.insulin.netural.medico;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class CommonDiseases extends AppCompatActivity {

    String peru= "Besides diseases preventable by vaccination, you should also be careful about the following diseases: \n" +
            "- Animal bites and wounds \n" +
            "- Traveler's diarrhea \n" +
            "- Chikungunya \n" +
            "- Dengue \n" +
            "- Zyka";
    String india = "Besides diseases prevented by vaccination, you should alo be careful about the following diseases: \n" +
            "- Multidrug-resistant bacteria \n" +
            "- Animal bites and wounds \n" +
            "- Travelers' diarrhea \n" +
            "- Chikungunya \n" +
            "- Dengue \n" +
            "- H5N1 Avian Influenza \n" +
            "- Zyka";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_diseases);
        ActionBar ab = getSupportActionBar();
        ab.hide();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTitle);
        toolbar.setTitle("Common Diseases");
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
        Log.d("nome",texto);
        TextView d = (TextView) findViewById(R.id.textDiseases);
        d.setText(texto);

    }
}
