package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.ProductoService;
import com.PruebaNequi.PruebaNequi.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @PostMapping("/{sucursalId}")
    public ResponseEntity<Producto> agregarSucursal(@PathVariable Long sucursalId, @RequestBody Producto producto){
        return new ResponseEntity<>(productoService.agregarProducto(sucursalId,producto), HttpStatus.CREATED);
    }

    @PutMapping("/{productoId}/{stock}")
    public ResponseEntity<Producto> modificarStock(@PathVariable Long productoId, @PathVariable int stock){
        return new ResponseEntity<>(productoService.modificarStock(productoId,stock), HttpStatus.OK);
    }

    @GetMapping("/mayor-stock/{sucursalId}")
    public ResponseEntity<Producto> obtenerProductoConMasStock(@PathVariable Long sucursalId){
        return new ResponseEntity<>(productoService.obtenerProductoConMasStock(sucursalId), HttpStatus.OK);
    }

    @DeleteMapping("{sucursalId}/{productoId}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable Long sucursalId, @PathVariable Long productoId){
        return new ResponseEntity<>(productoService.eliminarProducto(sucursalId,productoId), HttpStatus.OK);
    }
}
