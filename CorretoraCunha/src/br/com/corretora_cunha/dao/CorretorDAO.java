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
import java.sql.*;

public class CorretorDAO {
    public CorretorDAO(){
        
    }
     //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_cor; //código da tabela
    
    public boolean inserirCorretor(CorretorDTO corretorDTO) {
        try {
            id_cor = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Insert into Corretor (nome_cor, tel_cor, email_cor, "
                    + "cidade_cor, cresci_cor) values ("
                    + "'" + corretorDTO.getNome_cor() + "', "
                    + "'" + corretorDTO.getTel_cor() + "', "
                    + "'" + corretorDTO.getEmail_cor() + "', "
                    + "'" + corretorDTO.getCidade_cor() + "',"
                    + "'" + corretorDTO.getCresci_cor() + "')";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();
            rs.next();
            id_cor = rs.getInt("id_cor");

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
    }//Fecha o método inserirCorretor
    
    public boolean alterarCorretor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Update Corretor set "
                    + "nome_cor = '" + corretorDTO.getNome_cor() + "', "
                    + "tel_cor = '" + corretorDTO.getTel_cor() + "',"
                    + "email_cor = '" + corretorDTO.getEmail_cor() + "', "
                    + "cidade_cor = '" + corretorDTO.getCidade_cor() + "', "
                    + "cresci_cor = '" + corretorDTO.getCresci_cor() + "' "
                    + "where id_cor = " + corretorDTO.getId_cor();

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
    }//Fecha o método alterarCorretor

    public boolean excluirCorretor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando1 = "Delete from Corretor where id_cor = " + corretorDTO.getId_cor();
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
    }//Fecha o método excluirCorretor

    public ResultSet consultarCorretor(CorretorDTO corretorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando;

            switch (opcao) {
                case 1:
                    comando = "Select c.* "
                            + "from Corretor c "
                            + "where c.id_cor = " + corretorDTO.getId_cor();
                    break;
                case 2:
                    comando ="Select c.* "
                            + "from Corretor c "
                            + "where c.nome_cor like '" + corretorDTO.getNome_cor() + "%' "
                            + "order by c.nome_cor";
                    break;
                case 3:
                    comando ="Select c.* "
                            + "from Corretor c "
                            + "where c.cidade_cor like '" + corretorDTO.getCidade_cor() + "%' "
                            + "order by c.nome_cor";
                    break;   
                case 4:
                    comando ="Select c.* "
                            + "from Corretor c "
                            + "where c.tel_cor like '" + corretorDTO.getTel_cor() + "%' "
                            + "order by c.tel_cor";
                    break;  
                
                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * from Corretor";
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());

            return rs;

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarCorretor

}
