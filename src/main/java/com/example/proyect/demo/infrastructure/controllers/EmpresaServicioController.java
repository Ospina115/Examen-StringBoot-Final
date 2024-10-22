// package com.example.proyect.demo.infrastructure.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.proyect.demo.application.services.IEmpresaServicioService;
// import com.example.proyect.demo.domain.entities.EmpresaServicio;




// @RestController
// @RequestMapping("/empservicio")
// public class EmpresaServicioController {

//     @Autowired
//     private IEmpresaServicioService empresaServicioService;

//      @GetMapping
//     public List<EmpresaServicio> list(){
//         return empresaServicioService.findAll();
//     }

//     @PostMapping()
//     public ResponseEntity<?> create(@RequestBody EmpresaServicio empresaServicio) {
//         return ResponseEntity.status(HttpStatus.CREATED).body(empresaServicioService.save(empresaServicio));
//     }
// }
