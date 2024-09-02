package org.example.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Pedido> pedidos;
    private Double receitaRestaurante;
    private Integer capacidadeRestaurante;
    private Integer quantidadeClientesPresentes;

    public Restaurante(Integer capacidadeRestaurante) {
        this.pedidos = new ArrayList<>();
        this.receitaRestaurante = 0.0;
        this.capacidadeRestaurante = capacidadeRestaurante;
        this.quantidadeClientesPresentes = 0;
    }

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
        this.receitaRestaurante += pedido.getValorTotalPedido();
    }

    public List<Pedido> listarTodosOsPedidosPorStatusPedido(StatusPedido statusPedido){
        List<Pedido> listaPedidosPorStatusPedidos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if(pedido.getStatusPedido() == statusPedido) {
                listaPedidosPorStatusPedidos.add(pedido);
            }
        }
        return listaPedidosPorStatusPedidos;
    }

    public List<Pedido> listarTodosOsPedidosComItensMaiorQue(Integer quantidade){
        List<Pedido> listarPedidosComItensMaiorQueQuantidade = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getItens().size() > quantidade){
                listarPedidosComItensMaiorQueQuantidade.add(pedido);
            }
        }

        return listarPedidosComItensMaiorQueQuantidade;
    }

    public  List<Pedido> listarTodosOsPedidosValorMaiorQue(Integer ValorTotalPedido){
        List<Pedido> listarPedidosComValorMaiorQueValorTotalPedido = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getValorTotalPedido() > ValorTotalPedido){
                listarPedidosComValorMaiorQueValorTotalPedido.add(pedido);
            }
        }
        return listarPedidosComValorMaiorQueValorTotalPedido;
    }

    public void atualizarStatusPedido(Integer idPedido, StatusPedido statusPedido) throws Exception {
        Pedido pedidoEncontrado = null;
        int indexPedido = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                pedidoEncontrado = pedido;
                break;
            };
            indexPedido++;
        }

        if (pedidoEncontrado == null) return;

        pedidoEncontrado.setStatusPedido(statusPedido);

        this.pedidos.set(indexPedido, pedidoEncontrado);
    }

    public void removerPedido(Integer idPedido) throws Exception {
        Pedido pedidoEncontrado = null;
        int indexPedido = 0;
        for (var pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                pedidoEncontrado = pedido;
                break;
            }
            indexPedido++;
        }

        if (pedidoEncontrado == null) return;

        this.receitaRestaurante -= pedidoEncontrado.getValorTotalPedido();
        this.pedidos.remove(indexPedido);
    }

    public void registrarMovimentoCliente(Integer quantidadeClientes, TipoMovimento tipoMovimento){
        if (tipoMovimento == TipoMovimento.CHEGADA) {
            if (this.quantidadeClientesPresentes + quantidadeClientes <= this.capacidadeRestaurante) {
                this.quantidadeClientesPresentes += quantidadeClientes;
            }
        } else {
            if (this.quantidadeClientesPresentes - quantidadeClientes > 0) {
                this.quantidadeClientesPresentes -= quantidadeClientes;
            }
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Double getReceitaRestaurante() {
        return receitaRestaurante;
    }

    public void setReceitaRestaurante(Double receitaRestaurante) {
        this.receitaRestaurante = receitaRestaurante;
    }

    public Integer getCapacidadeRestaurante() {
        return capacidadeRestaurante;
    }

    public void setCapacidadeRestaurante(Integer capacidadeRestaurante) {
        this.capacidadeRestaurante = capacidadeRestaurante;
    }

    public Integer getQuantidadeClientesPresentes() {
        return quantidadeClientesPresentes;
    }

    public void setQuantidadeClientesPresentes(Integer quantidadeClientesPresentes) {
        this.quantidadeClientesPresentes = quantidadeClientesPresentes;
    }
}
