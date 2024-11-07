package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "imagenPerfil")
    private String imagenPerfil;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "sommelier")
    private List<Resenia> resenias;

    @ManyToMany
    @JoinTable(
            name = "CertificacionesXSommeliers",
            joinColumns = @JoinColumn(name = "idSommelier"),
            inverseJoinColumns = @JoinColumn(name = "idCertificacion")
    )
    private List<Certificacion> certificaciones;
}