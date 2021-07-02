package com.example.restaurante.Pedido;

import com.example.restaurante.Mesa.Mesa;
import com.example.restaurante.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

//    @PostMapping("/mesa")
//    public ResponseEntity<Pedido> addPedido(@RequestBody PedidoDTO pedidoDto) {
//        Pedido pedido = pedidoService.addPedido(pedidoDto);
//
//        HttpStatus status = HttpStatus.OK;
//
//        if (pedido == null)
//            status = HttpStatus.NOT_ACCEPTABLE;
//
//        return new ResponseEntity<>(pedido, status);
//    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoDTO pedidoDto) {
        Pedido pedido = pedidoService.createPedido(pedidoDto);

        HttpStatus status = HttpStatus.OK;

        if (pedido == null)
            status = HttpStatus.NOT_ACCEPTABLE;

        return new ResponseEntity<>(pedido, status);
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        pedidoService.updatePedido(pedido);

        return pedido;
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable Long pedidoId) {
        return new ResponseEntity<>(pedidoService.deletePedido(pedidoId), HttpStatus.OK);
    }
}
