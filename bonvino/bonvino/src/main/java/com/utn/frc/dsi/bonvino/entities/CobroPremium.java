package com.utn.frc.dsi.bonvino.entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CobroPremium")
public class CobroPremium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "esAnual")
    private Boolean esAnual;

    @Column(name = "fechaPago")
    private Date fechaPago;

    @Column(name = "monto")
    private Float monto;

    @Column(name = "nroOperacionMercadoPago")
    private String nroOperacionMercadoPago;

    @Column(name = "idUsuario")
    private Integer idUsuario;

}