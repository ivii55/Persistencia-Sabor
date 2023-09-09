package com.utn.Persistencia.entidades;

import com.utn.Persistencia.utilidades.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Tipo tipo;

    private int tiempoEstimadoCocina;

    private String denominacion;

    private Double precioVenta;

    private Double precioCompra;

    private int stockActual;

    private int stockMinimo;

    private String unidadMedida;

    private String foto;

    private String receta;


}
