/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.model;

import java.io.Serializable;


public class TipoRoupaBean implements Serializable {
    
   private int idTipoRoupa;
   private double preco;
   private String descricao;
   private int prazoLavagem;
   

    public TipoRoupaBean() {
    }
   
    public int getIdTipoRoupa() {
        return idTipoRoupa;
    }

    public void setIdTipoRoupa(int idTipoRoupa) {
        this.idTipoRoupa = idTipoRoupa;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
      public int getPrazoLavagem() {
        return prazoLavagem;
    }

    public void setPrazoLavagem(int prazoLavagem) {
        this.prazoLavagem = prazoLavagem;
    }
 
}
