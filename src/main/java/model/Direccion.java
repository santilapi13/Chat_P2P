package model;

public class Direccion {
    private String IP;
    private String puerto;

    public Direccion(String IP) {
        this.IP = IP;
    }

    public String getIP() {
        return IP;
    }
    public String getPuerto() {
        return puerto;
    }
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
}
