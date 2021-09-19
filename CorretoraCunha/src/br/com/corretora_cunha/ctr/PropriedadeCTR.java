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
import java.sql.*;
import br.com.corretora_cunha.dao.ConexaoDAO;
import br.com.corretora_cunha.dao.PropriedadeDAO;
import br.com.corretora_cunha.dto.PropriedadeDTO;
public class PropriedadeCTR {
    PropriedadeDAO propriedadeDAO = new PropriedadeDAO();

    public PropriedadeCTR() {
    }

    public String inserirPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (propriedadeDAO.inserirPropriedade(propriedadeDTO)) {
                return "Propriedade Cadastrado com Sucesso!!!";
            } else {
                return "Propriedade NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Propriedade NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirPropriedade

    public String alterarPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (propriedadeDAO.alterarPropriedade(propriedadeDTO)) {
                return "Propriedade Alterado com Sucesso!!!";
            } else {
                return "Propriedade NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Propriedade NÃO Alterado!!!";
        }
    }//Fecha o método alterarPropriedade

    public String excluirPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            if (propriedadeDAO.excluirPropriedade(propriedadeDTO)) {
                return "Propriedade Excluido com Sucesso!!!";
            } else {
                return "Propriedade NÃO Excluido!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Propriedade NÃO Excluido!!!";
        }
    }//Fecha o método excluirPropriedade

    public ResultSet consultarPropriedade(PropriedadeDTO propriedadeDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = propriedadeDAO.consultarPropriedade(propriedadeDTO , opcao);

        return rs;
    }//Fecha o método consultarPropriedade

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
