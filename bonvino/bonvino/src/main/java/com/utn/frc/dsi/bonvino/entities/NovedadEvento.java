package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NovedadEventos")
public class NovedadEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codDescPremiun;
    private String descripcion;
    private Boolean esSoloPremium;
    private Date fechaHoraEvento;
    private String nombreEvento;

    @ManyToMany
    private List<Bodega> bodegas;
}
