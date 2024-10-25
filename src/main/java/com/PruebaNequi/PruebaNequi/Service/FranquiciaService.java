package com.PruebaNequi.PruebaNequi.Service;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Entity.Sucursal;
import com.PruebaNequi.PruebaNequi.Respository.FranquiciaRepository;
import com.PruebaNequi.PruebaNequi.Respository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Franquicia agregarFranquicia(Franquicia franquicia){
        return franquiciaRepository.save(franquicia);
    }

    public Sucursal agregarSucursal(Long franquiciaId, Sucursal sucursal){
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        sucursal.setFranquicia(franquicia);
        franquicia.getSucursales().add(sucursal);

        return sucursalRepository.save(sucursal);
    }

    public List<Franquicia> listarFranquicias(){
        return franquiciaRepository.findAll();
    }
}
