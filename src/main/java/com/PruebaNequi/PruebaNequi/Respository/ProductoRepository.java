package com.PruebaNequi.PruebaNequi.Respository;


import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //Producto findTopBySucursalOrderByStockDesc(Sucursal sucursal);
    @Query("SELECT p FROM Producto p WHERE p.stock = (SELECT MAX(p2.stock) FROM Producto p2 WHERE p2.sucursal = p.sucursal)")
    List<Producto> findProductosConMayorStockPorSucursal();
}
