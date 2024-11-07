package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import com.utn.frc.dsi.bonvino.entities.Pais;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToOne
    private Pais pais;
}