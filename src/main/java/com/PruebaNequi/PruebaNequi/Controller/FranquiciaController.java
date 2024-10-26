package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Producto;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseStatus(HttpStatus.BAD_REQUEST)
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public  ResponseEntity<Map<String,Object>> agregarFranquicia(@RequestBody Franquicia franquicia){
        long startTime = System.currentTimeMillis(); //tiempo de inicio

        Franquicia franquiciacreado = franquiciaService.agregarFranquicia(franquicia); //llamada al servicio

        long endTime = System.currentTimeMillis(); //tiempo de finalizacion

        long responseTime = endTime-startTime;
        Map<String,Object> response = new HashMap<>();
        response.put("status",200);
        response.put("franquicia","Se agrego exitosamente");
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{franquiciaId}/sucursales")
    public  ResponseEntity<Map<String,Object>> agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal){
        long startTime = System.currentTimeMillis(); //tiempo de inicio

        Sucursal nuevaSucursal = franquiciaService.agregarSucursal(franquiciaId, sucursal); //llamada al servicio

        long endTime = System.currentTimeMillis(); //tiempo de finalizacion

        long responseTime = endTime-startTime;
        Map<String,Object> response = new HashMap<>();
        response.put("status",HttpStatus.OK);
        response.put("sucursal","Se agrega exitosamente");
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    private List<Franquicia> listarFranquicias(){
        return franquiciaService.listarFranquicias();
    }

    @PutMapping("/{franquiciaId}/nombre")
    public ResponseEntity<Map<String,Object>>modificarStock(@PathVariable Long franquiciaId, @RequestParam String nuevoNombre){
        if(nuevoNombre == null || nuevoNombre.trim().isEmpty()){
            long startTime = System.currentTimeMillis(); //tiempo de inicio

            franquiciaService.modificarNombre(franquiciaId, nuevoNombre); //llamada al servicio

            long endTime = System.currentTimeMillis(); //tiempo de finalizacion

            long responseTime = endTime - startTime;
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST);
            response.put("franquicia", "No se realizo el Cambio de Nombre");
            response.put("tiempo_respuesta_ms", responseTime);
            return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }else {

            long startTime = System.currentTimeMillis(); //tiempo de inicio

            franquiciaService.modificarNombre(franquiciaId, nuevoNombre); //llamada al servicio

            long endTime = System.currentTimeMillis(); //tiempo de finalizacion

            long responseTime = endTime - startTime;
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK);
            response.put("franquicia", "Cambio de Nombre exitosamente");
            response.put("tiempo_respuesta_ms", responseTime);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        //return new ResponseEntity<>(productoService.modificarStock(productoId,stock), HttpStatus.OK);
    }
}
