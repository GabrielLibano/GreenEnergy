package com.gabriellibano.greenenergy.greenenergy.service;
import java.util.List;
import java.util.Optional;


import com.gabriellibano.greenenergy.greenenergy.model.Dispositivos;
import com.gabriellibano.greenenergy.greenenergy.repository.DispositivosRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DispositivosService {
    private final DispositivosRepository dispositivosRepository;

    public List<Dispositivos> list() {
        return dispositivosRepository.findAll();
    }

    public Dispositivos save(Dispositivos dispositivos) {
        return dispositivosRepository.save(dispositivos);
    }

    public boolean existsById(Long id) {
        return dispositivosRepository.existsById(id);
    }

    public void delete(Long id) {
        dispositivosRepository.deleteById(id);
    }

    public Optional<Dispositivos> findById(Long id) {
        return dispositivosRepository.findById(id);
    }

}
