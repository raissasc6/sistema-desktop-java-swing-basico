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
import br.com.corretora_cunha.dto.CorretorDTO;
import br.com.corretora_cunha.dto.NegocioCorDTO;
import java.sql.*;
public class NegocioCorDAO {
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_neg; //código da tabela
    
    public boolean inserirNegocioCor(NegocioCorDTO negocioCorDTO) {
        try {
            id_neg = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into Negocio_Corretor (id_neg, id_cor) values ("
                    + "'" + negocioCorDTO.getId_neg() + "', "
                    + "'" + negocioCorDTO.getId_cor() + "')";

           
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
    }//Fecha o método inserirNegocioCor

    public boolean excluirCorretorNegocioCor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from Negocio_Corretor where id_cor = " + corretorDTO.getId_cor();

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
   
    public boolean excluirNegocioCor(NegocioCorDTO negocioCorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from Negocio_Corretor where id_neg = " + negocioCorDTO.getId_neg();

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
    
    public ResultSet consultarNegocioCor(NegocioCorDTO negocioCorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando;

            switch (opcao) {
                case 1:
                    comando = "Select nc.*, n.*, c.* from Negocio_Corretor nc, Negocio n, Corretor c"
                            + " where nc.id_neg = n.id_neg and "
                            + "nc.id_cor = c.id_cor and"
                            + " nc.id_neg = " + negocioCorDTO.getId_neg();
                    break;
                case 2:
                    comando = "Select nc.*, n.*, c.* from Negocio_Corretor nc, Negocio n, Corretor c"
                            + " where nc.id_neg = n.id_neg and "
                            + "nc.id_cor = c.id_cor and"
                            + " nc.id_neg = " + negocioCorDTO.getId_neg();
                    break;

                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * "
                            + "from Negocio_Corretor ";
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
