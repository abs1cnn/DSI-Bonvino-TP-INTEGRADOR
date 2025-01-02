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
    private Date fechaFin;
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "idEnofilo", nullable = false)
    private Enofilo amigo;

    @ManyToOne
    @JoinColumn(name = "idBodega", nullable = false)
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "idSommelier", nullable = false)
    private Sommelier sommelier;

}