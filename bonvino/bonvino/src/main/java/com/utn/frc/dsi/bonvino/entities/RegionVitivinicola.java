package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RegionVitinicolas")
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;

    @OneToMany(mappedBy = "regionVinicola")
    private List<Bodega> bodegas;


}