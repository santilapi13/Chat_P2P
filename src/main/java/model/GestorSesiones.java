package model;

public interface GestorSesiones {
    Sesion getSesionActual();
    void setSesionActual(Sesion sesionActual);
    void addNuevaSesion(Sesion sesion);
}
