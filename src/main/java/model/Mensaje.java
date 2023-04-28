package model;

public class Mensaje {
    private int ID;
    private String texto;
    private String hora;
    private Informacion emisor;

    public Mensaje(int ID, String texto, String hora, Informacion emisor) {
        this.ID = ID;
        this.texto = texto;
        this.hora = hora;
        this.emisor = emisor;
    }
}
