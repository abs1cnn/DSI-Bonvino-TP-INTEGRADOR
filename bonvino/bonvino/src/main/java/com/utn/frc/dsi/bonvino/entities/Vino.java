package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Vinos")
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "aniada")
    private Integer aniada;
    @Column(name = "imagenEtiqueta")
    private String imagenEtiqueta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "notaDeCataBodega")
    private Integer notaDeCataBodega;
    @Column(name = "precioArs")
    private Float precioArs;

    @ManyToOne
    @JoinColumn(name = "idVino", nullable = false)
    private Bodega bodega;

    @ManyToMany
    @JoinTable(
            name = "VinoXVarietal",
            joinColumns = @JoinColumn(name = "idVino"),
            inverseJoinColumns = @JoinColumn(name = "idVarietal")
    )
    private List<Varietal> varietales;
    @ManyToMany
    @JoinTable(
            name = "VinoXMaridaje",
            joinColumns = @JoinColumn(name = "idVino"),
            inverseJoinColumns = @JoinColumn(name = "idMaridaje")
    )
    private List<Maridaje> maridajes;

    @OneToMany(mappedBy = "vino")
    private List<Resenia> resenias;

    @ManyToOne
    @JoinColumn(name = "idEnofilo", nullable = false)
    private Enofilo enofilo;

}