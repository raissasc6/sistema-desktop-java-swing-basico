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

import br.com.corretora_cunha.dto.AdministradorDTO;
import java.sql.*;
public class AdministradorDAO {
    public AdministradorDAO(){
        
    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_adm; //código da tabela
    
    public boolean inserirAdministrador(AdministradorDTO administradorDTO) {
        try {
            id_adm = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Insert into Administrador (nome_adm, tel_adm, email_adm, "
                    + "senha_adm) values ("
                    + "'" + administradorDTO.getNome_adm() + "', "
                    + "'" + administradorDTO.getTel_adm() + "', "
                    + "'" + administradorDTO.getEmail_adm() + "', "
                    + "'" + administradorDTO.getSenha_adm() + "')";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();
            rs.next();
            id_adm = rs.getInt("id_adm");

            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            rs.close();
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
    }//Fecha o método inserirAdministrador

    public boolean alterarAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Update Administrador set "
                    + "nome_adm = '" + administradorDTO.getNome_adm() + "', "
                    + "tel_adm = '" + administradorDTO.getTel_adm() + "',"
                    + "email_adm = '" + administradorDTO.getEmail_adm() + "', "
                    + "senha_adm = '" + administradorDTO.getSenha_adm() + "' "
                    + "where id_adm = " + administradorDTO.getId_adm();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando1.toUpperCase());            
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
    }//Fecha o método alterarAdministrador

    public boolean excluirAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando1 = "Delete from Administrador where id_adm = " + administradorDTO.getId_adm();
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando1);
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
    }//Fecha o método excluirAdministrador

    public ResultSet consultarAdministrador(AdministradorDTO administradorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando;

            switch (opcao) {
                case 1:
                    comando = "Select a* "
                            + "from Administrador a "
                            + "where a.id_adm = " + administradorDTO.getId_adm();
                    break;
                case 2:
                    comando ="Select a* "
                            + "from Administrador a "
                            + "where a.nome_adm like '" + administradorDTO.getNome_adm() + "%' "
                            + "order by c.nome_adm";
                    break;
                case 3:
                    comando ="Select a* "
                            + "from Administrador a "
                            + "where a.email_adm like '" + administradorDTO.getEmail_adm() + "%' "
                            + "order by c.email_adm";
                    break;   
                case 4:
                    comando ="Select a* "
                            + "from Administrador a "
                            + "where a.tel_adm like '" + administradorDTO.getTel_adm() + "%' "
                            + "order by c.tel_adm";
                    break;  
                
                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * from Administrador";
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());

            return rs;

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarAdministrador

    public boolean logarAdm(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Select count(u.id_adm) " +
                             "from administrador u " + 
                             "where u.email_adm = '" + administradorDTO.getEmail_adm()+ "'" +
                             " and u.senha_adm = '" + administradorDTO.getSenha_adm() + "'";

            //Executa o comando SQL no banco de Dados
            rs = null;
            rs = stmt.executeQuery(comando);
            rs.next();
            int x = rs.getInt(1);
            if(x==1){
                return true;
            }
            else{
                return false;
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }//Fecha o método logarUsuario
}
