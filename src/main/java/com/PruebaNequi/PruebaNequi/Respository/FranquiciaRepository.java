package com.PruebaNequi.PruebaNequi.Respository;


import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}