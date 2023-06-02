package com.dawjaroso.partidas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Orderdetail;


@Repository
public interface OrderDetailRepository extends JpaRepository<Orderdetail, Long>{

}
