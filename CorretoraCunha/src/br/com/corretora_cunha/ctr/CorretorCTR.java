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
import br.com.corretora_cunha.dao.CorretorDAO;
import br.com.corretora_cunha.dto.CorretorDTO;

public class CorretorCTR {
     
    CorretorDAO corretorDAO = new CorretorDAO();

    public CorretorCTR() {
    }

    public String inserirCorretor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (corretorDAO.inserirCorretor(corretorDTO)) {
                return "Corretor Cadastrado com Sucesso!!!";
            } else {
                return "Corretor NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Corretor NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirCorretor

    public String alterarCorretor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (corretorDAO.alterarCorretor(corretorDTO)) {
                return "Corretor Alterado com Sucesso!!!";
            } else {
                return "Corretor NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Corretor NÃO Alterado!!!";
        }
    }//Fecha o método alterarCorretor

    public String excluirCorretor(CorretorDTO corretorDTO) {
        try {
            if (corretorDAO.excluirCorretor(corretorDTO)) {
                return "Corretor Excluido com Sucesso!!!";
            } else {
                return "Corretor NÃO Excluido!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Corretor NÃO Excluido!!!";
        }
    }//Fecha o método excluirCorretor

    public ResultSet consultarCorretor(CorretorDTO corretorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = corretorDAO.consultarCorretor(corretorDTO , opcao);

        return rs;
    }//Fecha o método consultarCorretor

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
