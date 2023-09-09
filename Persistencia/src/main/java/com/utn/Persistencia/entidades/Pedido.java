package com.utn.Persistencia.entidades;

import com.utn.Persistencia.utilidades.Estado;
import com.utn.Persistencia.utilidades.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fecha;

    private Estado estado;

    private Date horaEstimadaEntrega;

    private TipoEnvio tipoEnvio;

    private Double total;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    private Factura factura;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List < DetallePedido > detallesPedidos = new ArrayList<>();

}
