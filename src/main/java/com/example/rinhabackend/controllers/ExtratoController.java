package com.example.rinhabackend.controllers;


import com.example.rinhabackend.dtos.ExtratoDTO;
import com.example.rinhabackend.models.Extrato;
import com.example.rinhabackend.services.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

    @GetMapping("/clientes/{id}/extrato")
    public ExtratoDTO extrato(@PathVariable("id") Long id){
        return extratoService.exibeExtrato(id);
    }

}
