package cl.inacap.reciclag.objetos;

import java.io.Serializable;

// Serializable es un implemento que permite que el objeto Solicitud sea enviado como parametro a otra activity
public class Solicitud implements Serializable {

    private String nombre;
    private Integer lotes;
    private String direccion;

    public Solicitud(String nombre, Integer lotes, String direccion) {
        this.nombre = nombre;
        this.lotes = lotes;
        this.direccion = direccion;
    }

    public Solicitud() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLotes() {
        return lotes;
    }

    public void setLotes(Integer lotes) {
        this.lotes = lotes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
