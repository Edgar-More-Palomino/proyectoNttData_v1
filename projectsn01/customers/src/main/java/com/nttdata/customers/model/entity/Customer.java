package com.nttdata.customers.model.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "clientes")
public class Customer {
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre", length = 80, nullable = false)
    private String nombre;
    @Column(name="apellido", length = 80, nullable = false)
    private String apellido;
    @Column(name="dni", length = 8, nullable = false, unique=true)
    private String dni;
    @Column(name="email", length = 60, nullable = false)
    private String email;
}
