package com.aluracursos.screenmatch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

    @GetMapping("/series")
    public String mostrarMensaje(){
        return "ESTE ES MI PRIMER MENSAJE EN MI APLICACION WEB";
    }
}
