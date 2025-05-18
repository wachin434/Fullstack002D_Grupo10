package com.TimeCraftIncorporate.Timecraft.Model;


import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Evento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(length = 20, nullable = false)
    private String titulo;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date fecha;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(nullable = false)
    private Time hora;

    @Column(nullable = false)
    private Integer duracionMin;

}
