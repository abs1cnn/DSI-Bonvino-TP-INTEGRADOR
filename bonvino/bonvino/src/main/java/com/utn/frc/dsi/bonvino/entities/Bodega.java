package com.utn.frc.dsi.bonvino.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Bodegas")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "historia")
    private String historia;

    @Column(name = "periodoActualizacion")
    private Integer periodoActualizacion;


    @Column(name = "coordenada")
    private String coordenadas;

    @ManyToOne
    @JoinColumn(name = "idRegionVitivinicola", nullable = false)
    private RegionVitivinicola regionVitivinicola;

    @OneToMany(mappedBy = "bodega")
    private List<Vino> vinos;

    @ManyToMany
    @JoinTable(
            name = "BodegaXEvento",
            joinColumns = @JoinColumn(name = "idBodega"),
            inverseJoinColumns = @JoinColumn(name = "idNovedadEvento")
    )
    private List<NovedadEvento> novedadEventos;

    @OneToMany(mappedBy = "bodega")
    private List<Siguiendo> seguidores;

}