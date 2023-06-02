package com.dawjaroso.partidas.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findAll();
	
	List<Order> findByStatus(String status);
	
	List<Order> findByOrderDateBetween(Date f1, Date f2);
	
	//Pedidos de todos los clientes de una ciudad
	@Query("Select o from Order o left join Customer c on o.customer=c.id where city = :city")
	List<Order> findByCityOfCustomer(@Param("city") String city);
}
