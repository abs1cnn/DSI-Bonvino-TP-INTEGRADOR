package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Siguiendo")
public class Siguiendo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idEnofiloSeguidor")
    private Enofilo enofiloSeguidor;

    @ManyToOne
    @JoinColumn(name = "idEnofiloSeguido")
    private Enofilo enofiloSeguido;
}