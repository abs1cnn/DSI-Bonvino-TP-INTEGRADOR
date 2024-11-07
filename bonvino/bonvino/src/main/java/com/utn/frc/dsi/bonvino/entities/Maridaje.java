package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Maridajes")
public class Maridaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    @ManyToMany(mappedBy = "maridajes")
    private List<Vino> vinos;
}