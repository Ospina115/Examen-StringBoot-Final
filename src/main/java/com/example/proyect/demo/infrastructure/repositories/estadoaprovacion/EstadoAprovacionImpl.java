package com.example.proyect.demo.infrastructure.repositories.estadoaprovacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IEstadoAprovacionService;
import com.example.proyect.demo.domain.entities.EstadoAprovacion;

@Service
public class EstadoAprovacionImpl implements IEstadoAprovacionService{

    @Autowired
    private EstadoAprovacionRepository estadoAprovacionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EstadoAprovacion> findAll() {
        return (List<EstadoAprovacion>) estadoAprovacionRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<EstadoAprovacion> finById(int id) {
        return estadoAprovacionRepository.findById(id);
    }

    @Transactional
	@Override
	public EstadoAprovacion save(EstadoAprovacion estadoAprovacion) {
		return estadoAprovacionRepository.save(estadoAprovacion);
	}

    @Transactional
    @Override
    public Optional<EstadoAprovacion> update(int id, EstadoAprovacion estadoAprovacion) {
        Optional<EstadoAprovacion> estadoAprovacionOptional = estadoAprovacionRepository.findById(id);
        if (estadoAprovacionOptional.isPresent()) {
            EstadoAprovacion estadoAprovacionDb = estadoAprovacionOptional.orElseThrow();
            estadoAprovacionDb.setNombre(estadoAprovacion.getNombre());
            return Optional.of(estadoAprovacionRepository.save(estadoAprovacionDb));
        }
        return estadoAprovacionOptional;
    }

    @Transactional
    @Override
    public Optional<EstadoAprovacion> delete(int id) {
        Optional<EstadoAprovacion> estadoAprovacionOptional = estadoAprovacionRepository.findById(id);
        estadoAprovacionOptional.ifPresent(estadoAprovacionDb -> {
            estadoAprovacionRepository.delete(estadoAprovacionDb);
        });
        return estadoAprovacionOptional;
    }

    

}
