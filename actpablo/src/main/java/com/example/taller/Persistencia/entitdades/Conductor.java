package com.example.taller.Persistencia.entitdades;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class Conductor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private BigInteger cedula;
    @Column
    private int edad;
    @Column
    private String nacionalidad;

    @Column
    private String sexo;
    @Column
    private boolean estado = true; // Indica si está habilitado o deshabilitado
}



