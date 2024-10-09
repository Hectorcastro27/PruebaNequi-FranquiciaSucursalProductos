package com.PruebaNequi.PruebaNequi.Controller;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {
    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public  ResponseEntity<Franquicia> agregarFranquicia(@RequestBody Franquicia franquicia){
        return new ResponseEntity<>(franquiciaService.agregarFranquicia(franquicia), HttpStatus.CREATED);
    }

    @GetMapping
    private List<Franquicia> listarFranquicias(){
        return franquiciaService.listarFranquicias();
    }
}
