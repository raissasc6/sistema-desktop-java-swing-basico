/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corretora_cunha.dao;

/**
 *
 * @author ra6sa
 */
import br.com.corretora_cunha.dto.PropriedadeDTO;
import br.com.corretora_cunha.dto.NegocioPropDTO;
import java.sql.*;

public class NegocioPropDAO {
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_neg; //código da tabela
    
    public boolean inserirNegocioProp(NegocioPropDTO negocioPropDTO) {
        try {
            id_neg = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into Negocio_Propriedade (id_neg, id_prop) values ("
                    + "'" + negocioPropDTO.getId_neg() + "', "
                    + "'" + negocioPropDTO.getId_prop() + "')";

           
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();

            //Fecha o statement
         
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirNegocioProp

    public boolean excluirPropriedadeNegocioProp(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from Negocio_Propriedade where id_prop = " + propriedadeDTO.getId_prop();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirProduto
   
    public boolean excluirNegocioProp(NegocioPropDTO negocioPropDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from Negocio_Propriedade where id_neg = " + negocioPropDTO.getId_neg();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirProduto
    
    public ResultSet consultarNegocioProp(NegocioPropDTO negocioPropDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando;

            switch (opcao) {
                case 1:
                    comando = "Select nc.*, n.*, p.* from Negocio_Propriedade nc, Negocio n, Propriedade p"
                            + " where nc.id_neg = n.id_neg and "
                            + "nc.id_prop = p.id_prop and"
                            + " nc.id_neg = " + negocioPropDTO.getId_neg();
                    break;
                case 2:
                    comando = "Select nc.*, n.*, p.* from Negocio_Propriedade nc, Negocio n, Propriedade p"
                            + " where nc.id_neg = n.id_neg and "
                            + "nc.id_prop = p.id_prop and"
                            + " nc.id_neg = " + negocioPropDTO.getId_neg();
                    break;

                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * "
                            + "from Negocio_Propriedade ";
            }

            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());

            return rs;

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

}
