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
import br.com.corretora_cunha.dto.ClienteDTO;
import java.sql.*;

public class ClienteDAO {
    
    public ClienteDAO() {

    }
   
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_cli; //código da tabela
    
    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            id_cli = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Insert into Cliente (nome_cli, tel_cli, email_cli, "
                    + "cidade_cli) values ("
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getTel_cli() + "', "
                    + "'" + clienteDTO.getEmail_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "')";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();
            rs.next();
            id_cli = rs.getInt("id_cli");

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
    }//Fecha o método inserirCliente

    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Update Cliente set "
                    + "nome_cli = '" + clienteDTO.getNome_cli() + "', "
                    + "tel_cli = '" + clienteDTO.getTel_cli() + "',"
                    + "email_cli = '" + clienteDTO.getEmail_cli() + "', "
                    + "cidade_cli = '" + clienteDTO.getCidade_cli() + "' "
                    + "where id_cli = " + clienteDTO.getId_cli();

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
    }//Fecha o método alterarCliente

    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando1 = "Delete from Cliente where id_cli = " + clienteDTO.getId_cli();
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
    }//Fecha o método excluirCliente

    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
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
                            + "from Cliente c "
                            + "where c.id_cli = " + clienteDTO.getId_cli();
                    break;
                case 2:
                    comando ="Select * "
                            + "from Cliente "
                            + "where Cliente.nome_cli like '" + clienteDTO.getNome_cli() + "%' "
                            + "order by Cliente.nome_cli";
                    break;
                case 3:
                    comando ="Select c.* "
                            + "from Cliente c "
                            + "where c.cidade_cli like '" + clienteDTO.getCidade_cli() + "%' "
                            + "order by c.nome_cli";
                    break;   
                case 4:
                    comando ="Select * "
                            + "from Cliente "
                            + "where Cliente.tel_cli like '" + clienteDTO.getTel_cli() + "%' "
                            + "order by Cliente.tel_cli";
                    break;  
                case 5:
                    comando ="Select * "
                            + "from Cliente ";
                    break;      
                case 6:
                    comando = "SELECT max(id_cli) as max_id FROM Cliente";
                    break;
                
                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * from Cliente order by Cliente.nome_cli";
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());

            return rs;

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarCliente

}
