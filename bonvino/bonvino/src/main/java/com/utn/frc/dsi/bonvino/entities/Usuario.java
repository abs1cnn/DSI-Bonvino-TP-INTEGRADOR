package com.utn.frc.dsi.bonvino.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "usuario")
    private List<CobroPremium> cobroPremium;

}