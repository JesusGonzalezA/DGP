package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;

import java.util.ArrayList;

public class ActividadesActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton botonHomeActividades, botonActActividades, botonFlechaDerecha, botonFlechaIzquierda, botonObjetivos;
    ArrayList<Actividad> actividadesTest;
    TextView tituloActAct;
    Actividad actividad;
    int actividadActual = 0;;

    private void init(){
        botonActActividades = findViewById(R.id.botonActActividadesObj);
        botonHomeActividades = findViewById(R.id.botonHomeActividades);
        botonFlechaDerecha = findViewById(R.id.botonFlechaDerechaObj);
        botonFlechaIzquierda = findViewById(R.id.botonFlechaIzquierdaObj);
        botonObjetivos = findViewById(R.id.botonObjetivosActividades);
        tituloActAct = findViewById(R.id.tituloActActObj);

        actividad = new Actividad();
        generarArrayActividadesTest();
        gestiónActividadActual();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        init();

        botonActActividades.setOnClickListener(this);
        botonHomeActividades.setOnClickListener(this);
        botonFlechaDerecha.setOnClickListener(this);
        botonFlechaIzquierda.setOnClickListener(this);
        botonObjetivos.setOnClickListener(this);
    }

    private void generarArrayActividadesTest(){
        Actividad actividadAux;
        actividadesTest = new ArrayList<>();

        actividadAux = new Actividad("Atarse los cordones", "Debes atarte los cordones y enviar un vídeo", "cordones.png", "QmjQAl_-tiI");
        actividadesTest.add(actividadAux);

        actividadAux = new Actividad("Poner la lavadora", "Debes poner la lavadora y enviar un vídeo", "lavadora.png", "XGKF5hxTnfo");
        actividadesTest.add(actividadAux);
    }

    private void gestiónActividadActual() {
        actividad = Data.getData().getActividades().get(actividadActual);

        System.out.println(actividad.getDireccionFoto());

        botonActActividades.setImageResource(getResources().getIdentifier(actividad.getDireccionFoto().split("\\.")[0],"drawable",getApplicationInfo().packageName));

        tituloActAct.setText(actividad.getNombre());
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botonActActividadesObj){
            // Intent a Actividad concreta
            Intent i = new Intent(this, ActividadActivity.class);
            gestiónActividadActual();
            i.putExtra("actividad", actividad);
            startActivity(i);
        }else if(v.getId() == R.id.botonHomeActividades){
            finish();
        }else if(v.getId() == R.id.botonFlechaDerechaObj){
            /* Enlaza a actividad siguiente si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT1 (pantalla muestra ACT1)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT2
             */
            if(actividadActual+1 < Data.getData().getActividades().size()){
                actividadActual += 1;
                gestiónActividadActual();
            }
        }else if(v.getId() == R.id.botonFlechaIzquierdaObj){
            /* Enlaza a actividad anterior si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT2 (pantalla muestra ACT2)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT1
             */
            if(actividadActual-1 >= 0){
                actividadActual -= 1;
                gestiónActividadActual();
            }
        }else if(v.getId() == R.id.botonObjetivosActividades){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }
    }
}
