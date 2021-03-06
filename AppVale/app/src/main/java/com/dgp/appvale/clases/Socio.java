package com.dgp.appvale.clases;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
    private ArrayList<Actividad> actividades;
    private int contrasenia = 000000;

    public Socio(){
        super("Nombre socio", "Apellido socio", new Date(), 1);
    }

    public Socio(String nombre, String apellidos, Date fechaNacimiento, int ID){
        super(nombre, apellidos, fechaNacimiento, ID);
    }

    public Socio(String nombre, String apellidos, Date fechaNacimiento, int ID, int contrasenia){
        super(nombre, apellidos, fechaNacimiento, ID);
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString(){
        String socio = "";

        socio += "ID: " + this.getID() + "\n";
        socio += "Nombre: " + this.getNombre() + "\n";
        socio += "Apellido: " + this.getApellidos() + "\n";
        socio += "Fecha Nacimiento: " + this.getFechaNacimiento() + "\n";
        socio += "Contraseña: " + this.contrasenia + "\n";

        return socio;
    }

}
