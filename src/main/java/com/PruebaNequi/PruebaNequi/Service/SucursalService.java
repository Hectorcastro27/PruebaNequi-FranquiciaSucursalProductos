package com.PruebaNequi.PruebaNequi.Service;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Respository.FranquiciaRepository;
import com.PruebaNequi.PruebaNequi.Respository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Sucursal agregarSucursal(Long franquiciaId, Sucursal sucursal){
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        sucursal.setFranquicia(franquicia);
        return sucursalRepository.save(sucursal);
    }

    public List<Sucursal> listarSucursal(){
        return sucursalRepository.findAll();
    }
}
