package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Enofilo")
public class Enofilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "imagenPerfil")
    private String imagenPerfil;

    @OneToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "amigo")
    private List<Siguiendo> seguidores;

    @OneToMany(mappedBy = "enofilos")
    private List<Resenia> resenias;

    @OneToMany(mappedBy = "enofilo")
    private List<Vino> vinos;
}