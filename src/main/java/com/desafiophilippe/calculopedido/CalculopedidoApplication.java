package com.desafiophilippe.calculopedido;

import com.desafiophilippe.entities.Order;
import com.desafiophilippe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
@ComponentScan({"com.desafiophilippe"})
public class CalculopedidoApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(CalculopedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale localeBr = Locale.of("pt","BR");
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBr);

		Order order = new Order(1034,150.00,20.0);
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: " + dinheiro.format(orderService.total(order)));

	}
}
