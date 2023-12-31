package com.utn.Persistencia.entidades;


import com.utn.Persistencia.utilidades.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private Date fecha;

    private int numero;

    private Double descuento;

    private FormaPago formaPago;

    private int total;




}
