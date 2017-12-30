package com.insulin.netural.medico;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

//import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Destination extends AppCompatActivity {
    Spinner citySp;
    Map<String, String[]> cidades= new HashMap<>();
    String[] cityItm;
    Spinner countrySp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        ActionBar ab = getSupportActionBar();
        ab.hide();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTitle);
        toolbar.setTitle("Where are you");
        toolbar.setSubtitle("travelling to?");
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setTitleTextColor(Color.WHITE);

        cidades.put("Índia",new String[] {"Nova Dehli", "Bombaim", "Bangalore"});
        cidades.put("Peru",new String[] {"Lima", "Cusco"});


        setTitle("Destination");
        citySp = (Spinner) findViewById(R.id.city);
        countrySp = (Spinner) findViewById(R.id.country);
        String[] countryItm = new String[]{"Índia", "Peru"};
        if(countrySp==null){
            Log.d("ola","spinner null");
        }
        ArrayAdapter<String> countryAdp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countryItm);
        countrySp.setAdapter(countryAdp);


        countrySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                actualiza();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText tripNomeEt = (EditText) findViewById(R.id.name);

                String nome = tripNomeEt.getText().toString();

                String city = citySp.getSelectedItem().toString();
                String country = countrySp.getSelectedItem().toString();

                EditText dta_arrivalEt = (EditText) findViewById(R.id.dta_arrival);
                EditText dta_departureEt = (EditText) findViewById(R.id.dta_departure);

                String dta_arrival = dta_arrivalEt.getText().toString();
                String dta_departure = dta_departureEt.getText().toString();

                Date hoje = Calendar.getInstance().getTime();

                Dados.destino = new Destino(nome, dta_arrival, dta_departure,city,country);
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    Date arr = formatter.parse(dta_arrival);
                    Date dep = formatter.parse(dta_departure);
                    if (hoje.after(arr) && hoje.before(dep)) {
                        Intent intent = new Intent(Destination.this.getApplication(), Durante.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Destination.this.getApplication(), activity_before.class);
                        startActivity(intent);
                    }
                } catch (ParseException e) {
                    Intent intent = new Intent(Destination.this.getApplication(), activity_before.class);
                    startActivity(intent);
                }


            }
        });
    }

    private void actualiza(){
        cityItm = cidades.get(countrySp.getSelectedItem());
        ArrayAdapter<String> cityAdp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cityItm);
        citySp.setAdapter(cityAdp);
    }
}
