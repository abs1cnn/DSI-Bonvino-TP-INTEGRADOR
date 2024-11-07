package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Resenias")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "esPremium")
    private Boolean esPremium;

    @Column(name = "fechaResenia")
    private Date fechaResenia;

    @Column(name = "puntaje")
    private Integer puntaje;

    @ManyToOne
    @JoinColumn(name = "idVinos")
    private Vino vino;

    @ManyToOne
    @JoinColumn(name = "idSommelier")
    private Sommelier sommelier;
}