package org.example.restaurante;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Integer idPedido;
    private String nomeCliente;
    private Double valorTotalPedido;
    private StatusPedido statusPedido;
    private List<String> itens;
    private Date dataPedido;


    public Pedido(Integer idPedido, String nomeCliente, Double valorTotalPedido, List<String> itens) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.valorTotalPedido = valorTotalPedido;
        this.statusPedido = StatusPedido.PREPARANDO;
        this.itens = itens;
        this.dataPedido = new Date();
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(Double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
}
