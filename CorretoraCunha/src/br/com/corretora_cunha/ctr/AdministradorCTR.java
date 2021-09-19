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
import br.com.corretora_cunha.dao.AdministradorDAO;
import br.com.corretora_cunha.dto.AdministradorDTO;
public class AdministradorCTR {
     AdministradorDAO administradorDAO = new AdministradorDAO();

    public AdministradorCTR() {
    }

    public String inserirAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (administradorDAO.inserirAdministrador(administradorDTO)) {
                return "Administrador Cadastrado com Sucesso!!!";
            } else {
                return "Administrador NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirAdministrador

    public String alterarAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (administradorDAO.alterarAdministrador(administradorDTO)) {
                return "Administrador Alterado com Sucesso!!!";
            } else {
                return "Administrador NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Alterado!!!";
        }
    }//Fecha o método alterarAdministrador

    public String excluirAdministrador(AdministradorDTO administradorDTO) {
        try {
            if (administradorDAO.excluirAdministrador(administradorDTO)) {
                return "Administrador Excluido com Sucesso!!!";
            } else {
                return "Administrador NÃO Excluido!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Excluido!!!";
        }
    }//Fecha o método excluirAdministrador

    public ResultSet consultarAdministrador(AdministradorDTO administradorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = administradorDAO.consultarAdministrador(administradorDTO , opcao);

        return rs;
    }//Fecha o método consultarAdministrador

    public boolean logarAdm(AdministradorDTO administradorDTO) {

        return administradorDAO.logarAdm(administradorDTO);

    }//Fecha o método consultarUsuario
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}
