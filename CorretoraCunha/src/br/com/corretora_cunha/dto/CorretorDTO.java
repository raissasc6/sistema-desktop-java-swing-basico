/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corretora_cunha.dto;

/**
 *
 * @author ra6sa
 */
public class CorretorDTO {
    int id_cor;
    String nome_cor, tel_cor, cidade_cor, email_cor, cresci_cor;
    
    public CorretorDTO(){
        
    }

    public int getId_cor() {
        return id_cor;
    }

    public void setId_cor(int id_cor) {
        this.id_cor = id_cor;
    }

    public String getCresci_cor() {
        return cresci_cor;
    }

    public void setCresci_cor(String cresci_cor) {
        this.cresci_cor = cresci_cor;
    }

    public String getNome_cor() {
        return nome_cor;
    }

    public void setNome_cor(String nome_cor) {
        this.nome_cor = nome_cor;
    }

    public String getTel_cor() {
        return tel_cor;
    }

    public void setTel_cor(String tel_cor) {
        this.tel_cor = tel_cor;
    }

    public String getCidade_cor() {
        return cidade_cor;
    }

    public void setCidade_cor(String cidade_cor) {
        this.cidade_cor = cidade_cor;
    }

    public String getEmail_cor() {
        return email_cor;
    }

    public void setEmail_cor(String email_cor) {
        this.email_cor = email_cor;
    }
    
    
}
