package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import com.utn.frc.dsi.bonvino.entities.Pais;
import lombok.*;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;
    @OneToMany(mappedBy = "provincia")
    private List<RegionVitivinicola> regionVitivinicolas;
}