package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.ProductoService;
import com.PruebaNequi.PruebaNequi.Service.SucursalService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
@Data
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @PostMapping
    public ResponseEntity<Map<String,Object>> agregarProducto(@RequestBody Producto producto){
        long startTime = System.currentTimeMillis(); //tiempo de inicio

        Producto productoCreado = productoService.agregarProducto(producto); //llamada al servicio

        long endTime = System.currentTimeMillis(); //tiempo de finalizacion

        long responseTime = endTime-startTime;
        Map<String,Object> response = new HashMap<>();
        response.put("status","success");
        response.put("producto",productoCreado);
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/sucursales/{sucursalId}")
    public ResponseEntity<Map<String,Object>> agregarProductoSucursal(
            @PathVariable Long sucursalId,
            @RequestBody Producto producto){
        long startTime = System.currentTimeMillis(); //tiempo de inicio

        Producto productoEnSucursalCreado = productoService.agregarProductoSurcusal(sucursalId, producto); //llamada al servicio

        long endTime = System.currentTimeMillis(); //tiempo de finalizacion

        long responseTime = endTime-startTime;
        Map<String,Object> response = new HashMap<>();
        response.put("status","success");
        response.put("producto","Se agrego exitosamente");
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        //return new ResponseEntity<>(productoService.agregarProductoSurcusal(sucursalId,producto), HttpStatus.CREATED);
    }

    @PutMapping("/{productoId}/{stock}")
    public ResponseEntity<Map<String,Object>>modificarStock(@PathVariable Long productoId, @PathVariable int stock){
        long startTime = System.currentTimeMillis(); //tiempo de inicio

        Producto productoActualizado = productoService.modificarStock(productoId, stock); //llamada al servicio

        long endTime = System.currentTimeMillis(); //tiempo de finalizacion

        long responseTime = endTime-startTime;
        Map<String,Object> response = new HashMap<>();
        response.put("status","success");
        response.put("producto","Stock Actualizando exitosamente");
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.OK);
        //return new ResponseEntity<>(productoService.modificarStock(productoId,stock), HttpStatus.OK);
    }

    @GetMapping("/mayor-stock")
    public ResponseEntity<List<Producto>> obtenerProductoConMasStock(){
        List<Producto> productos = productoService.obtenerProductoConMasStock();
        return ResponseEntity.ok(productos);
        //return new ResponseEntity<>(productoService.obtenerProductoConMasStock(productos), HttpStatus.OK);
    }

    @DeleteMapping("{sucursalId}/{productoId}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable Long sucursalId, @PathVariable Long productoId){
        return new ResponseEntity<>(productoService.eliminarProducto(sucursalId,productoId), HttpStatus.OK);
    }
}
