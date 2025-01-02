package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Varietales")
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "porcentajeComposicion")
    private String porcentajeComposicion;

    @OneToOne
    private TipoUva tipoUva;

    @ManyToMany(mappedBy = "varietales")
    private List<Vino> vinos;
}