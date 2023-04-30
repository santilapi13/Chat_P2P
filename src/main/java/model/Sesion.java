package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sesion {
    private LocalDate fecha;
    private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
    private Informacion local;
    private Informacion remoto;

    public Informacion getRemoto() {
        return remoto;
    }

    public Sesion(Informacion local, Informacion remoto) {
        this.fecha = LocalDate.now();
        this.local = local;
        this.remoto = remoto;
    }

    public void addMensaje(String mensaje, boolean enviadoPorLocal) {
        if (enviadoPorLocal)
            this.mensajes.add(new Mensaje(mensajes.size(), mensaje, LocalTime.now().toString(), local));
        else
            this.mensajes.add(new Mensaje(mensajes.size(), mensaje, LocalTime.now().toString(), remoto));
    }

}
