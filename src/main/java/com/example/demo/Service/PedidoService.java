package com.example.demo.Service;

import com.example.demo.Model.Pedido;
import com.example.demo.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    //Listar todos los pedidos
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    //Buscar pedido por ID
    public Optional<Pedido> getPedidoById(int id) {
        return pedidoRepository.findById(id);
    }

    //Crear pedido
    public Pedido addPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    //Eliminar pedido
    public boolean deletePedido(int id){
        if (pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Actualizar pedido
    public Optional<Pedido> updatePedido(int id, Pedido nuevosDatosPedido){
        if (pedidoRepository.existsById(id)){

            Pedido pedidoExistente = pedidoRepository.findById(id).get();

            pedidoExistente.setUsuario(nuevosDatosPedido.getUsuario());
            pedidoExistente.setMetodo_pago(nuevosDatosPedido.getMetodo_pago());
            pedidoExistente.setDireccion(nuevosDatosPedido.getDireccion());
            pedidoExistente.setComuna(nuevosDatosPedido.getComuna());
            pedidoExistente.setMonto_total(nuevosDatosPedido.getMonto_total());

            return Optional.of(pedidoRepository.save(pedidoExistente));
        }else{
            return Optional.empty();
        }
    }
}
