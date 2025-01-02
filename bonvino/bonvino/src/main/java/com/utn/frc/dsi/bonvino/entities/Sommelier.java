package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Sommeliers")
public class Sommelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fechaValidacion;

    private String nombre;

    private String notaPresentacion;

    @OneToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "sommelier")
    private List<Resenia> resenias;

    @OneToMany(mappedBy = "sommelier")
    private List<Certificacion> certificaciones;

    @OneToMany(mappedBy = "sommelier")
    private List<Siguiendo> seguidores;
}