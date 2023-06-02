package com.dawjaroso.partidas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
