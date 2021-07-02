package com.example.restaurante.Pedido;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {
    private static final File FILE = new File("src/main/java/com/example/restaurante/Pedido/data/pedido.json");
	private final ObjectMapper mapper;

	@Autowired
    public PedidoRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Pedido> getAll(){
		List<Pedido> pedidos = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
			pedidos = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

    public void save(Pedido pedido) {
		try {
			 List<Pedido> pedidos = this.getAll();
			 pedidos.add(pedido);
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, pedidos);
			 out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pedido findById(Long id) {
		List<Pedido> pedidos = this.getAll();
		return pedidos.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst()
				.orElse(new Pedido());
	}

	public Pedido removePedidoById(Long pedidoId) {
		List<Pedido> pedidos = this.getAll();
		Pedido pedido =  pedidos.stream()
				.filter(p -> p.getId().equals(pedidoId))
				.findFirst()
				.orElse(new Pedido());
		pedidos.remove(pedido);
		try {
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, pedidos);
			 out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pedido;
	}

	public void update(Pedido pedidoAlterar) {
		try {
			 List<Pedido> pedidos = this.getAll();
			 Pedido pedido = pedidos.stream()
					 .filter(p -> p.getId().equals(pedidoAlterar.getId()))
					 .findFirst()
					 .get();
			 int index = pedidos.indexOf(pedido);
			 pedidos.get(index).setId(pedidoAlterar.getId());
			 pedidos.get(index).setMesa(pedidoAlterar.getMesa());
			 pedidos.get(index).setPratos(pedidoAlterar.getPratos());
			 pedidos.get(index).setValorTotal(pedidoAlterar.getMesa());

			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, pedidos);
			 out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
