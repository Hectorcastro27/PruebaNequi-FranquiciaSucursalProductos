package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
