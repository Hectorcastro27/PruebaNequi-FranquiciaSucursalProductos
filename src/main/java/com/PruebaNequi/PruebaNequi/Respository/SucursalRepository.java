package com.PruebaNequi.PruebaNequi.Respository;

import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
