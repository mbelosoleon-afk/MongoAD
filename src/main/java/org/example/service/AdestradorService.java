package org.example.service;

import org.example.model.Adestrador;
import org.example.repository.AdestradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdestradorService {


    private final AdestradorRepository adestradorRepo;
    @Autowired
    public AdestradorService(AdestradorRepository adestradorRepository) {
        this.adestradorRepo = adestradorRepository;
    }

    public void crearAdestrador(Adestrador a){
        adestradorRepo.save(a);
    };

    public Adestrador buscarAdestrador(String id){
        return adestradorRepo.findById(id).orElse(null);
    }

    public List<Adestrador> buscarAdestradores(){
        return adestradorRepo.findAll();
    }
}
