package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;
    @PostMapping("/{franquiciaId}")
    public ResponseEntity<Sucursal> agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal){
        return new ResponseEntity<>(sucursalService.agregarSucursal(franquiciaId,sucursal), HttpStatus.CREATED);
    }

    @GetMapping
    private List<Sucursal> listarFranquicias(){
        return sucursalService.listarSucursal();
    }

    @PutMapping("/{sucursalId}/nombre")
    public ResponseEntity<Map<String,Object>>modificarStock(@PathVariable Long sucursalId, @RequestParam String nuevNombre){
        if(nuevNombre == null || nuevNombre.trim().isEmpty()) {

            long startTime = System.currentTimeMillis(); //tiempo de inicio

            sucursalService.modificarNombre(sucursalId, nuevNombre); //llamada al servicio

            long endTime = System.currentTimeMillis(); //tiempo de finalizacion

            long responseTime = endTime - startTime;
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST);
            response.put("Sucursal", "Cambio de Nombre exitosamente");
            response.put("tiempo_respuesta_ms", responseTime);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else{

            long startTime = System.currentTimeMillis(); //tiempo de inicio

            sucursalService.modificarNombre(sucursalId, nuevNombre); //llamada al servicio

            long endTime = System.currentTimeMillis(); //tiempo de finalizacion

            long responseTime = endTime - startTime;
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK);
            response.put("Sucursal", "Cambio de Nombre exitosamente");
            response.put("tiempo_respuesta_ms", responseTime);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        //return new ResponseEntity<>(productoService.modificarStock(productoId,stock), HttpStatus.OK);
    }
}
