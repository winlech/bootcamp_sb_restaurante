package com.example.restaurante.caixa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    private CaixaService caixaService;

    @Autowired
    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @GetMapping
    public double getCaixa() {
        return caixaService.read();
    }
}
