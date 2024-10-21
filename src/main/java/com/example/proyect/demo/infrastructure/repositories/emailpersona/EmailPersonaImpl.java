package com.example.proyect.demo.infrastructure.repositories.emailpersona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IEmailPersonaService;
import com.example.proyect.demo.domain.entities.EmailPersona;

@Service
public class EmailPersonaImpl implements IEmailPersonaService{

    @Autowired
    private EmailPersonaRepository emailPersonaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EmailPersona> findAll() {
        return (List<EmailPersona>) emailPersonaRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<EmailPersona> findById(int id) {
        return emailPersonaRepository.findById(id);
    }

    @Transactional
    @Override
    public EmailPersona save(EmailPersona emailPersona) {
        return emailPersonaRepository.save(emailPersona);
    }

    @Transactional
    @Override
    public Optional<EmailPersona> update(int id, EmailPersona emailPersona) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaRepository.findById(id);
        if (emailPersonaOptional.isPresent()) {
            EmailPersona emailPersonaDb = emailPersonaOptional.orElseThrow();
            emailPersonaDb.setEmail(emailPersona.getEmail());
            emailPersonaDb.setPersona(emailPersona.getPersona());;
            emailPersonaDb.setTipoEmails(emailPersona.getTipoEmails());
            return Optional.of(emailPersonaRepository.save(emailPersona));
        }
        return emailPersonaOptional;
    }

    @Transactional
    @Override
    public Optional<EmailPersona> delete(int id) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaRepository.findById(id);
        emailPersonaOptional.ifPresent(emailPersonaDb -> {
            emailPersonaRepository.delete(emailPersonaDb);
        });
        return emailPersonaOptional;
    }

}
