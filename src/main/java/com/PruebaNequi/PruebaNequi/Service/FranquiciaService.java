package com.PruebaNequi.PruebaNequi.Service;

import com.PruebaNequi.PruebaNequi.Entity.Franquicia;
import com.PruebaNequi.PruebaNequi.Respository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia agregarFranquicia(Franquicia franquicia){
        return franquiciaRepository.save(franquicia);
    }

    public List<Franquicia> listarFranquicias(){
        return franquiciaRepository.findAll();
    }
}
