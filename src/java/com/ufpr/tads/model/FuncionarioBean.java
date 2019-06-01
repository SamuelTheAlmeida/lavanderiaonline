/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gsaporiti
 */
public class FuncionarioBean implements Serializable {
   private long matricula;
   private String nome;
   private String email;
   private Date dataNascimento;  
   private String senha;
   

    public FuncionarioBean() {
    }
   
    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
