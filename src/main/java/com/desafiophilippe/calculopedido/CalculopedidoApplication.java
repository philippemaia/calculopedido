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

		System.out.println("------------------------------------------------------------");

		Order order1 = new Order(1034,150.00,20.0);
		System.out.println("Pedido código " + order1.getCode());
		System.out.println("Valor total: " + dinheiro.format(orderService.total(order1)));

		System.out.println("------------------------------------------------------------");

		Order order2 = new Order(2282,800.00,10.0);
		System.out.println("Pedido código " + order2.getCode());
		System.out.println("Valor total: " + dinheiro.format(orderService.total(order2)));

		System.out.println("------------------------------------------------------------");

		Order order3 = new Order(1309,95.90,0.0);
		System.out.println("Pedido código " + order3.getCode());
		System.out.println("Valor total: " + dinheiro.format(orderService.total(order3)));

	}
}
