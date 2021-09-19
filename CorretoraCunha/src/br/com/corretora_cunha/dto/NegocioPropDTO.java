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
public class NegocioPropDTO {
    int id_neg, id_prop;
    
    public NegocioPropDTO(){
        
    }

    public int getId_neg() {
        return id_neg;
    }

    public void setId_neg(int id_neg) {
        this.id_neg = id_neg;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
}
