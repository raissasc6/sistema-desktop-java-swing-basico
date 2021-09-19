/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corretora_cunha.ctr;

/**
 *
 * @author ra6sa
 */
import br.com.corretora_cunha.dao.ConexaoDAO;
import br.com.corretora_cunha.dao.NegocioPropDAO;
import br.com.corretora_cunha.dto.PropriedadeDTO;
import br.com.corretora_cunha.dto.NegocioPropDTO;
import java.sql.ResultSet;

public class NegocioPropCTR {
    NegocioPropDAO negocioPropDAO = new NegocioPropDAO();

    public NegocioPropCTR() {
    }
     
     
     public String inserirNegocioProp(NegocioPropDTO negocioPropDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioPropDAO.inserirNegocioProp(negocioPropDTO)) {
                return "Propriedade Adicionada com Sucesso!!!";
            } else {
                return "Negocio NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio NÃO Cadastrado";
        }
    }//Fecha o método inserirNegocio
    
     public String excluirPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioPropDAO.excluirPropriedadeNegocioProp(propriedadeDTO)) {
                return "Propriedade Excluída com Sucesso!!!";
            } else {
                return "Propriedade NÃO Excluída!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Propriedade NÃO Excluído!!!";
        }
    }//Fecha o método excluirPropriedade
     
     public String excluirNegocioPropriedade(NegocioPropDTO negocioPropDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioPropDAO.excluirNegocioProp(negocioPropDTO)) {
                return "NegocioProp Excluído com Sucesso!!!";
            } else {
                return "Negocio Propriedade NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "e_Propriedade NÃO Excluído!!!";
        }
    }//Fecha o método excluirPropriedade
    
    public ResultSet consultarNegocioProp(NegocioPropDTO negocioPropDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = negocioPropDAO.consultarNegocioProp(negocioPropDTO, opcao);

        return rs;
    }//Fecha o método consultarPropriedade
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
