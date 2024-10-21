package com.example.proyect.demo.infrastructure.repositories.tipoemail;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ITipoEmailService;
import com.example.proyect.demo.domain.entities.TipoEmail;

@Service
public class TipoEmailImpl implements ITipoEmailService{

    @Autowired
    private TipoEmailRepository tipoEmailRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoEmail> findAll() {
        return (List<TipoEmail>) tipoEmailRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoEmail> findById(int id) {
        return tipoEmailRepository.findById(id);
    }

    @Transactional
    @Override
    public TipoEmail save(TipoEmail tipoEmail) {
        return tipoEmailRepository.save(tipoEmail);
    }

    @Transactional
    @Override
    public Optional<TipoEmail> update(int id, TipoEmail tipoEmail) {
        Optional<TipoEmail> tipoEmailOptional = tipoEmailRepository.findById(id);
        if (tipoEmailOptional.isPresent()) {
            TipoEmail tipoEmailDb = tipoEmailOptional.orElseThrow();
            tipoEmailDb.setNombre(tipoEmail.getNombre());
            return Optional.of(tipoEmailRepository.save(tipoEmail));
        }
        return tipoEmailOptional;
    }

    @Transactional
    @Override
    public Optional<TipoEmail> delete(int id) {
        Optional<TipoEmail> tipoemailOptional = tipoEmailRepository.findById(id);
        tipoemailOptional.ifPresent(tipoEmailDb -> {
            tipoEmailRepository.delete(tipoEmailDb);
        });
        return tipoemailOptional;
    }


    
}
