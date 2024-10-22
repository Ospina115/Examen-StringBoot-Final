// package com.example.proyect.demo.infrastructure.repositories.empresaservicio;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.proyect.demo.application.services.IEmpresaServicioService;
// import com.example.proyect.demo.domain.entities.EmpresaServicio;

// @Service
// public class EmpresaServicioImpl implements IEmpresaServicioService{

//     @Autowired
//     private EmpresaServicioRepository empresaServicioRepository;

//     @Transactional(readOnly = true)
//     @Override
//     public List<EmpresaServicio> findAll() {
//         return (List<EmpresaServicio>) empresaServicioRepository.findAll();
//     }

//     @Transactional
//     @Override
//     public EmpresaServicio save(EmpresaServicio empresaServicio) {
//         return empresaServicioRepository.save(empresaServicio);
//     }

// }
