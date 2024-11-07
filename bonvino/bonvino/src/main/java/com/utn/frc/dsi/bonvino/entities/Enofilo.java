package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

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

}