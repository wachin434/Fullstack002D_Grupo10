package com.TimeCraftIncorporate.Timecraft.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Data // gettes and setters
@NoArgsConstructor //Constructores vacios
@AllArgsConstructor //Constructores con paramentros
public class Usuario {

    @Id //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(length = 15, nullable = false)
    private String nombre;

    @Column(length = 15, nullable = true)
    private String segundoNombre;

    @Column(length = 15, nullable = false)
    private String apellido;

    @Column(length = 15, nullable = false)
    private String segundoApellido;

    @Column(length = 30, nullable = false)
    private String correo;

    @Column(length = 10, nullable = false)
    private String contrasenia;

    @Column(length = 10, nullable = false)
    private String zonaHoraria;


    @Column(length = 15, nullable = false)
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;


}

