package com.dgp.appvale.clases;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Data{
    Socio socio;
    ArrayList<Objetivo> objetivos;
    ArrayList<Actividad> actividades;
    ArrayList<Actividad> actividadesObjetivos;
    Solucion solucion;

    boolean registrado = false;

    private static final Data data = new Data();

    public  static Data getData(){
        return data;
    }

    private Data(){
        socio = new Socio();
        objetivos = new ArrayList<>();
        actividades = new ArrayList<>();
        actividadesObjetivos = new ArrayList<>();
        solucion = new Solucion();
    }

    private Data(Socio socio, ArrayList<Objetivo> objetivos, ArrayList<Actividad> actividades){
        this();
        this.socio = socio;
        this.objetivos = objetivos;
        this.actividades = actividades;
    }

    public void setSocio(Socio socio){
        this.socio = socio;
    }

    public void setRegistrado(boolean registrado){ this.registrado = registrado; }

    public Socio getSocio() { return socio; }

    public ArrayList<Objetivo> getObjetivos(){ return objetivos; }

    public ArrayList<Actividad> getActividades(){ return actividades; }

    public ArrayList<Actividad> getActividadesObjetivos(){ return actividadesObjetivos; }

    public Solucion getSolucion(){ return solucion; }

    public void clearActividadesObjetivos(){ actividadesObjetivos.clear(); }

    @Override
    public String toString(){
        String d = "";

        d += socio.toString();

        for(int i=0; i<actividades.size(); i++)
            d += actividades.get(i).toString();

        return d;
    }

/*
    cargarSocio(JSON)
    getIdSocio()

    cargarObjetivos(JSON)
    cargarActividades(JSON)

    getNombreSocio()
    getApellidosSocio()
    getFechNacimientoSocio()

    getObjetivos()
    getObtivo(id) *Optativo

    getActividades()
    getActividad(idActividad)

    setSolucion(Video)
*/
}