package com.utn.frc.dsi.bonvino.entities;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contrasena;
    private String nombre;
    private Boolean premium;
    @Transient
    @OneToOne
    private CobroPremium cobroPremium;
}