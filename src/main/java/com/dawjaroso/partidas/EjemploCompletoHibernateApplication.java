package com.dawjaroso.partidas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dawjaroso.partidas.modelos.Order;
import com.dawjaroso.partidas.repositorios.CustomerRepository;
import com.dawjaroso.partidas.repositorios.EmployeeRepository;
import com.dawjaroso.partidas.repositorios.OfficeRepository;
import com.dawjaroso.partidas.repositorios.OrderDetailRepository;
import com.dawjaroso.partidas.repositorios.OrderRepository;
import com.dawjaroso.partidas.repositorios.PaymentRepository;
import com.dawjaroso.partidas.repositorios.ProductRepository;
import com.dawjaroso.partidas.repositorios.ProductlineRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class EjemploCompletoHibernateApplication implements CommandLineRunner {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductlineRepository productlineRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EjemploCompletoHibernateApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) {
		 
		List<Order> pedidos = orderRepository.findByStatus("shipped");
		pedidos.stream()
			.forEach( p -> System.out.println(p.getOrderNumber()));
		 
		System.out.println("------------------------------------------");
	 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Order> pedidosPorFecha;
		try {
			pedidosPorFecha = orderRepository.findByOrderDateBetween(formatter.parse("06-01-2003"), formatter.parse("06-01-2004"));
			pedidosPorFecha.stream()
			.forEach( p -> System.out.println(p.getOrderNumber()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------------------------------------");
		List<Order> pedidosVegas = orderRepository.findByCityOfCustomer("Las Vegas");
		pedidosVegas.stream()
			.forEach( p -> System.out.println(p.getOrderNumber()));
		
		
		System.out.println("------------------------------------------");
		List<Order> pedidosTodos = orderRepository.findAll();
		pedidosTodos.stream()
			.filter( o -> o.getCustomer().getCity().equals("Las Vegas"))
			.sorted( (o1,o2) -> o1.getOrderDate().compareTo(o2.getOrderDate()))
			.forEach( p -> System.out.println(p.getOrderNumber()));
		
		
	}

}
