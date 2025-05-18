package com.TimeCraftIncorporate.Timecraft.Model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name="LogLogin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogLogin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLog;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
}
