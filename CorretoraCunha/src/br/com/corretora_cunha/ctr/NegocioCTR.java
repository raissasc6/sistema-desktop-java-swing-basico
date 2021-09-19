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
import br.com.corretora_cunha.dao.NegocioDAO;
import br.com.corretora_cunha.dto.NegocioDTO;

public class NegocioCTR {
    NegocioDAO negocioDAO = new NegocioDAO();

    public NegocioCTR() {
    }

    public String inserirNegocio(NegocioDTO negocioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioDAO.inserirNegocio(negocioDTO)) {
                return "Negocio Cadastrado com Sucesso!!!";
            } else {
                return "Negocio NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirNegocio

    public String alterarNegocio(NegocioDTO negocioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioDAO.alterarNegocio(negocioDTO)) {
                return "Negocio Alterado com Sucesso!!!";
            } else {
                return "Negocio NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio NÃO Alterado!!!";
        }
    }//Fecha o método alterarNegocio

    public String excluirNegocio(NegocioDTO negocioDTO) {
        try {
            if (negocioDAO.excluirNegocio(negocioDTO)) {
                return "Negocio Excluido com Sucesso!!!";
            } else {
                return "Negocio NÃO Excluido!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio NÃO Excluido!!!";
        }
    }//Fecha o método excluirNegocio

    public ResultSet consultarNegocio(NegocioDTO negocioDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = negocioDAO.consultarNegocio(negocioDTO , opcao);

        return rs;
    }//Fecha o método consultarNegocio

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
