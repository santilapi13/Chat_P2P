package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sesion {
    private LocalDate fecha;
    private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();

    public Sesion() {
        this.fecha = LocalDate.now();
    }

    public void addMensaje(String mensaje, Informacion usuario) {
        this.mensajes.add(new Mensaje(mensajes.size(), mensaje, LocalTime.now().toString(), usuario));
    }

}
