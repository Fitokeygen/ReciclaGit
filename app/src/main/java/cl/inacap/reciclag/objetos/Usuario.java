package cl.inacap.reciclag.objetos;

import java.io.Serializable;

public class Usuario implements Serializable{

    private Integer id;
    private String email;
    private String contraseña;

    public Usuario(Integer id, String email, String contraseña) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
