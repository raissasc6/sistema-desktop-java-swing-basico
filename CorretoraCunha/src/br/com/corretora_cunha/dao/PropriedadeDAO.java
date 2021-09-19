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
import java.sql.*;
public class PropriedadeDAO {
    public PropriedadeDAO(){
        
    }
     //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    Statement stmt = null;
    //pegar o id inserido automaticamente na tabela
    int id_prop; //código da tabela
    
    public boolean inserirPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            id_prop = 0;
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Insert into Propriedade (nome_prop, tipo_prop, fonte_prop, "
                    + "cidade_prop, estado_prop, rua_prop, num_prop, coordenada_prop, "
                    + "benfeitoria_prop, proprietario_prop, situacao_prop, area_prop, "
                    + "area_reserva_prop, valor_prop, data_prop, complemento_prop, "
                    + "atividade_prop, pasta_prop, unidade_prop, matricula_prop) values ("
                    + "'" + propriedadeDTO.getNome_prop() + "', "
                    + "'" + propriedadeDTO.getTipo_prop() + "', "
                    + "'" + propriedadeDTO.getFonte_prop() + "', "
                    + "'" + propriedadeDTO.getCidade_prop() + "', "
                    + "'" + propriedadeDTO.getEstado_prop() + "', "
                    + "'" + propriedadeDTO.getRua_prop() + "', "
                    + "'" + propriedadeDTO.getNum_prop() + "', "
                    + "'" + propriedadeDTO.getCoordenada_prop() + "', "
                    + "'" + propriedadeDTO.getBenfeitoria_prop() + "', "
                    + "'" + propriedadeDTO.getProprietario_prop() + "', "
                    + "'" + propriedadeDTO.getSituacao_prop() + "', "
                    + "'" + propriedadeDTO.getArea_prop() + "', "
                    + "'" + propriedadeDTO.getArea_reserva_prop() + "', "
                    + "'" + propriedadeDTO.getValor_prop() + "', "
                    + "'" + propriedadeDTO.getData_prop() + "', "
                    + "'" + propriedadeDTO.getComplemento_prop() + "', "
                    + "'" + propriedadeDTO.getAtividade_prop() + "', "
                    + "'" + propriedadeDTO.getPasta_prop() + "', "
                    + "'" + propriedadeDTO.getUnidade_prop() + "', "
                    + "'" + propriedadeDTO.getMatricula_prop() + "') ";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();
            rs.next();
            id_prop = rs.getInt("id_prop");

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
    }//Fecha o método inserirPropriedade

    public boolean alterarPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando1 = "Update Propriedade set "
                    + "nome_prop = '" + propriedadeDTO.getNome_prop() + "', "
                    + "tipo_prop = '" + propriedadeDTO.getTipo_prop() + "', "
                    + "fonte_prop = '" + propriedadeDTO.getFonte_prop() + "', "
                    + "cidade_prop = '" + propriedadeDTO.getCidade_prop() + "', "
                    + "estado_prop = '" + propriedadeDTO.getEstado_prop() + "', "
                    + "rua_prop = '" + propriedadeDTO.getRua_prop() + "', "
                    + "num_prop = '" + propriedadeDTO.getNum_prop() + "', "
                    + "coordenada_prop = '" + propriedadeDTO.getCoordenada_prop() + "', "
                    + "benfeitoria_prop = '" + propriedadeDTO.getBenfeitoria_prop() + "', "
                    + "proprietario_prop = '" + propriedadeDTO.getProprietario_prop() + "', "
                    + "situacao_prop = '" + propriedadeDTO.getSituacao_prop() + "', "
                    + "area_prop = '" + propriedadeDTO.getArea_prop() + "', "
                    + "area_reserva_prop = '" + propriedadeDTO.getArea_reserva_prop() + "', "
                    + "valor_prop = '" + propriedadeDTO.getValor_prop() + "', "
                    + "data_prop = '" + propriedadeDTO.getData_prop() + "', "
                    + "complemento_prop = '" + propriedadeDTO.getComplemento_prop() + "', "
                    + "atividade_prop = '" + propriedadeDTO.getAtividade_prop() + "', "
                    + "pasta_prop = '" + propriedadeDTO.getPasta_prop() + "', "
                    + "unidade_prop = '" + propriedadeDTO.getUnidade_prop() + "', "
                    + "matricula_prop = '" + propriedadeDTO.getMatricula_prop() + "' "
                    
                    + "where id_prop = " + propriedadeDTO.getId_prop();

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
    }//Fecha o método alterarPropriedade

    public boolean excluirPropriedade(PropriedadeDTO propriedadeDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando1 = "Delete from Propriedade where id_prop = " + propriedadeDTO.getId_prop();
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
    }//Fecha o método excluirPropriedade

    public ResultSet consultarPropriedade(PropriedadeDTO propriedadeDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando;

            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from Propriedade p "
                            + "where p.id_prop = " + propriedadeDTO.getId_prop();
                    break;
                case 2:
                    comando ="Select p.* "
                            + "from Propriedade p "
                            + "where p.nome_prop like '" + propriedadeDTO.getNome_prop() + "%' "
                            + "order by p.nome_prop";
                    break;
                case 3:
                    comando ="Select p.* "
                            + "from Propriedade p "
                            + "where p.cidade_prop like '" + propriedadeDTO.getCidade_prop() + "%' "
                            + "and p.tipo_prop like '" + propriedadeDTO.getTipo_prop() + "%' "
                            + "order by p.cidade_prop";
                    break;   
                case 4:
                    comando ="Select p.* "
                            + "from Propriedade p "
                            + "where p.area_prop like '" + propriedadeDTO.getArea_prop() + "%' "
                            + "order by p.area_prop";
                    break; 
                case 5:
                    comando ="Select p.* "
                            + "from Propriedade p "
                            + "where p.proprietario_prop like '" + propriedadeDTO.getProprietario_prop() + "%' "
                            + "order by p.proprietario_prop";
                    break;  
                case 6:
                    comando ="Select * "
                            + "from Propriedade order by estado_prop";
                    break;  
                case 7:
                    comando ="Select * "
                            + "from Propriedade "
                            + "where Propriedade.tipo_prop like '" + propriedadeDTO.getTipo_prop() + "%' "
                            + "order by Propriedade.tipo_prop";
                    break;  
                
                default://qualquer valor diferente de 1 ou 2
                    comando = "Select * from Propriedade";
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());

            return rs;

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarPropriedade

}
