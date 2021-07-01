package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.Pedido;
import com.example.restaurante.Pedido.PedidoDTO;
import com.example.restaurante.caixa.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private final MesaService mesaService;
    private final CaixaService caixaService;

    @Autowired
    public MesaController(MesaService mesaService, CaixaService caixaService) {

        this.mesaService = mesaService;
        this.caixaService = caixaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesa(@PathVariable Long id) {
        Mesa mesa = mesaService.getMesa(id);
        HttpStatus status = HttpStatus.OK;

        if (mesa == null)
            status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(mesa, status);
    }

    @GetMapping("/{id}/pedidos")
    public ResponseEntity<MesaPedidoDTO> getPedidos(@PathVariable Long id) {
        MesaPedidoDTO mesaPedidoDTO = mesaService.getPedidos(id);
        HttpStatus status = HttpStatus.OK;

        if (mesaPedidoDTO == null)
            status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(mesaPedidoDTO, status);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Double> fecharMesa(@PathVariable Long id) {
        Double valorConta = mesaService.fecharPedido(id);
        caixaService.save(valorConta);
        return new ResponseEntity<>(valorConta, HttpStatus.OK);
    }


}
