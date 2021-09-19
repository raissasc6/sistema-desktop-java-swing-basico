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
public class NegocioDTO {
    int id_neg, id_cli_neg, id_prop_neg, id_cor_neg;
    String modo_neg, data_neg, situacao_neg;
    
    public NegocioDTO(){
        
    }

    public int getId_neg() {
        return id_neg;
    }

    public void setId_neg(int id_neg) {
        this.id_neg = id_neg;
    }

    public int getId_cli_neg() {
        return id_cli_neg;
    }

    public void setId_cli_neg(int id_cli_neg) {
        this.id_cli_neg = id_cli_neg;
    }

    public int getId_prop_neg() {
        return id_prop_neg;
    }

    public void setId_prop_neg(int id_prop_neg) {
        this.id_prop_neg = id_prop_neg;
    }

    public int getId_cor_neg() {
        return id_cor_neg;
    }

    public void setId_cor_neg(int id_cor_neg) {
        this.id_cor_neg = id_cor_neg;
    }

    public String getModo_neg() {
        return modo_neg;
    }

    public void setModo_neg(String modo_neg) {
        this.modo_neg = modo_neg;
    }

    public String getData_neg() {
        return data_neg;
    }

    public void setData_neg(String data_neg) {
        this.data_neg = data_neg;
    }

    public String getSituacao_neg() {
        return situacao_neg;
    }

    public void setSituacao_neg(String situacao_neg) {
        this.situacao_neg = situacao_neg;
    }

   
    
    
}
