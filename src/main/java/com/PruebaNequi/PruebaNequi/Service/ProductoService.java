package com.PruebaNequi.PruebaNequi.Service;

import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Respository.ProductoRepository;
import com.PruebaNequi.PruebaNequi.Respository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;

    public Producto agregarProducto(Producto producto){
        return productoRepository.save(producto);
    }
    //metodo para agregar un producto a una sucursal
    public Producto agregarProductoSurcusal(Long sucursalId, Producto producto){
        // buscar la sucursal a la que se va agregar el producto
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        // asocia el producto con la sucursal
        producto.setSucursal(sucursal);

        sucursal.getProducto().add(producto);
        return productoRepository.save(producto); // guarda y devuelve el producto creado
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
        Producto producto = productoRepository.findById(productoId).
                orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        // actualiza el stock del producto
        producto.setStock(nuevoStock);
        return productoRepository.save(producto); // guarda el producto actualizando
    }

    public List<Producto> obtenerProductoConMasStock(){
        //Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        return productoRepository.findProductosConMayorStockPorSucursal();
    }
}
