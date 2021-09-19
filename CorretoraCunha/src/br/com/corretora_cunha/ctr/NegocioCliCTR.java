/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corretora_cunha.ctr;

import br.com.corretora_cunha.dao.ConexaoDAO;
import br.com.corretora_cunha.dao.NegocioCliDAO;
import br.com.corretora_cunha.dto.ClienteDTO;
import br.com.corretora_cunha.dto.NegocioCliDTO;
import java.sql.ResultSet;


/**
 *
 * @author ra6sa
 */
public class NegocioCliCTR {
     NegocioCliDAO negocioCliDAO = new NegocioCliDAO();

    public NegocioCliCTR() {
    }
     
     
     public String inserirNegocioCli(NegocioCliDTO negocioCliDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCliDAO.inserirNegocioCli(negocioCliDTO)) {
                return "Cliente Adicionado com Sucesso!!!";
            } else {
                return "Negocio NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio --NÃO Cadastrada";
        }
    }//Fecha o método inserirNegocio
    
     public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCliDAO.excluirClienteNegocioCli(clienteDTO)) {
                return "Cliente Excluído com Sucesso!!!";
            } else {
                return "Cliente NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Excluído!!!";
        }
    }//Fecha o método excluirCliente
     
     public String excluirNegocioCliente(NegocioCliDTO negocioCliDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCliDAO.excluirNegocioCli(negocioCliDTO)) {
                return "NegocioCli Excluído com Sucesso!!!";
            } else {
                return "Negocio Cliente NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "e_Cliente NÃO Excluído!!!";
        }
    }//Fecha o método excluirCliente
    
    public ResultSet consultarNegocioCli(NegocioCliDTO negocioCliDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = negocioCliDAO.consultarNegocioCli(negocioCliDTO, opcao);

        return rs;
    }//Fecha o método consultarCliente
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
