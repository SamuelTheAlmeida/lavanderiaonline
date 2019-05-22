/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author s123
 */
public class PedidoLavagemBean implements Serializable{
   private long id;
   private Long numero;
   private List<TipoRoupaBean> roupasPedido; 
   private int prazo;
   private double valorTotal;
   private EstadoBean estado;
   private ClienteBean cliente;

    public PedidoLavagemBean() {
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public List<TipoRoupaBean> getRoupasPedido() {
        return roupasPedido;
    }

    public void setRoupasPedido(List<TipoRoupaBean> roupasPedido) {
        this.roupasPedido = roupasPedido;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }
   
   
}
