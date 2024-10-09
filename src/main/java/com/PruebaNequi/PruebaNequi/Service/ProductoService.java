package com.PruebaNequi.PruebaNequi.Service;

import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Respository.ProductoRepository;
import com.PruebaNequi.PruebaNequi.Respository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;


    public Producto agregarProducto(Long sucursalId, Producto producto){
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }

    public boolean eliminarProducto(Long sucursalId, Long productoId){
        var producto = productoRepository.findById(productoId);
        if(producto.get().getSucursal().getId().equals(sucursalId)){
            productoRepository.deleteById(productoId);
            return true;
        }
        return false;
    }

    public Producto modificarStock(Long productoId, int nuevoStock){
        Producto producto = productoRepository.findById(productoId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoConMasStock(Long sucursalId){
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        return productoRepository.findTopBySucursalOrderByStockDesc(sucursal);
    }
}
