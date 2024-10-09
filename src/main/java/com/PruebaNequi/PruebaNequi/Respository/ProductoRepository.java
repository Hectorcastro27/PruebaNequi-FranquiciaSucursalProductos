package com.PruebaNequi.PruebaNequi.Respository;

import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findTopBySucursalOrderByStockDesc(Sucursal sucursal);
}
