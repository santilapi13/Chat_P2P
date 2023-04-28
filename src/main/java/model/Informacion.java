package model;

public class Informacion {
    private String IP;
    private int puerto;
    private String username;

    public Informacion(String IP, int puerto, String username) {
        this.IP = IP;
        this.puerto = puerto;
        this.username = username;
    }

    public String getIP() {
        return IP;
    }
    public int getPuerto() {
        return puerto;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
