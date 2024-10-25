package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
        response.put("status",200);
        response.put("sucursal","Se agrega exitosamente");
        response.put("tiempo_respuesta_ms",responseTime);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    private List<Franquicia> listarFranquicias(){
        return franquiciaService.listarFranquicias();
    }
}
