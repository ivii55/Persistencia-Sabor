package com.utn.Persistencia;

import com.utn.Persistencia.entidades.*;
import com.utn.Persistencia.repositorios.*;
import com.utn.Persistencia.utilidades.Estado;
import com.utn.Persistencia.utilidades.FormaPago;
import com.utn.Persistencia.utilidades.Tipo;
import com.utn.Persistencia.utilidades.TipoEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class PersistenciaApplication {

	@Autowired
	FacturaRepository facturaRepo;

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	DetallePedidoRepository detallePedidoRepo;

	@Autowired
	DomicilioRepository domicilioRepo;

	@Autowired
	PedidoRepository pedidoRepo;

	@Autowired
	ProductoRepository productoRepo;

	@Autowired
	RubroRepository rubroRepo;

	@Autowired
	UsuarioRepository usuarioRepo;

	public static void main(String[] args) {

		SpringApplication.run(PersistenciaApplication.class, args);
		System.out.println(" ---Esta funcionando---");
	}
	@Bean
	CommandLineRunner init() {
			   return args -> {

				   SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
				   SimpleDateFormat formatoHora = new SimpleDateFormat("dd-MM-yyyy hh:mm");

				   Factura factura01 = new Factura();
				   factura01.setFecha(formato.parse("2-11-2023"));
				   factura01.setNumero(3);
				   factura01.setFormaPago(FormaPago.EFECTIVO);
				   factura01.setTotal(26854);

				   Producto producto01 = new Producto();
				   producto01.setTipo(Tipo.MANUFACTURADO);
				   producto01.setTiempoEstimadoCocina(20);
				   producto01.setDenominacion("Burger");
				   producto01.setPrecioVenta(3500.00);
				   producto01.setPrecioCompra(3650.00);
				   producto01.setStockActual(10);
				   producto01.setStockMinimo(2);
				   producto01.setUnidadMedida("cm");
				   producto01.setFoto("PATH");
				   producto01.setReceta("De la Casa");

				   Rubro rubro1 = new Rubro();
				   rubro1.setDenominacion("Fast Food");
				   rubro1.getProductos().add(producto01);


				   DetallePedido detallePedido1 = new DetallePedido();
				   detallePedido1.setCantidad(4);
				   detallePedido1.setProducto(producto01);
				   detallePedido1.setSubtotal(126.25);


				   Pedido pedido1 = new Pedido();
				   // pedido1.setFecha(formato.parse("02-11-2023"));
				   pedido1.setEstado(Estado.ENTREGADO);
				   pedido1.setHoraEstimadaEntrega(formatoHora.parse("02-09-2023 14:15"));
				   pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
				   pedido1.setFactura(factura01);
				   pedido1.getDetallesPedidos().add(detallePedido1);


				   Usuario usuario01 = new Usuario();
				   usuario01.setNombre("Ivi");
				   usuario01.setPassword("1234");
				   usuario01.setRol("client");
				   usuario01.getPedidos().add(pedido1);


				   productoRepo.save(producto01);
				   rubroRepo.save(rubro1);
				   usuarioRepo.save(usuario01);
				   pedidoRepo.save(pedido1);
				   facturaRepo.save(factura01);
				   detallePedidoRepo.save(detallePedido1);

			   };
	}
}
