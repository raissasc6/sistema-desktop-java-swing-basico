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
public class AdministradorDTO {
    int id_adm;
    String nome_adm, tel_adm, email_adm, senha_adm;
    
    public AdministradorDTO(){
        
    }

    public int getId_adm() {
        return id_adm;
    }   

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getNome_adm() {
        return nome_adm;
    }

    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
    }

    public String getTel_adm() {
        return tel_adm;
    }

    public void setTel_adm(String tel_adm) {
        this.tel_adm = tel_adm;
    }

    public String getEmail_adm() {
        return email_adm;
    }

    public void setEmail_adm(String email_adm) {
        this.email_adm = email_adm;
    }

    public String getSenha_adm() {
        return senha_adm;
    }

    public void setSenha_adm(String senha_adm) {
        this.senha_adm = senha_adm;
    }
    
}
