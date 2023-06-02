package com.dawjaroso.partidas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawjaroso.partidas.modelos.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{

}
