package com.dawjaroso.partidas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
