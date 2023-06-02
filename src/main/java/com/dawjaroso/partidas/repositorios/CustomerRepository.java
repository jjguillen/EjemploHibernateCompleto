package com.dawjaroso.partidas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
