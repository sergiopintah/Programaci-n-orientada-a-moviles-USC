package com.example.appcrud.model;

public class Empleado {

    private Long id;
    private String nombre;
    private String password;
    private String email;

    public Empleado(){
    }

    public Empleado(Long id, String nombre, String password, String email){
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "Empleado{" +
                "Id:" + id +
                ", nombre:'" + nombre + '\'' +
                ", password:'" + password + '\'' +
                ", email:'" + email + '\'' +
                '}';
    }

}
