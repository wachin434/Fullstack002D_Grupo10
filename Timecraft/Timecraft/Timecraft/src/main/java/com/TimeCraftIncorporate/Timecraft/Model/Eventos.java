package com.TimeCraftIncorporate.Timecraft.Model;


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
@Table(name = "Eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eventos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEventos;

    @ManyToOne
    @JoinColumn(name= "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "idEstado",nullable = false)
    private Estado estado;
}

