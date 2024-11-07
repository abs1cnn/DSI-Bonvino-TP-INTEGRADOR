package com.utn.frc.dsi.bonvino.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Certificacion")
public class Certificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "institucionOtorgante")
    private String institucionOtorgante;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "adjuntoUrl")
    private String adjuntoUrl;


}