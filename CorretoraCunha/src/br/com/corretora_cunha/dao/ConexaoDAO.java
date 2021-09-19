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
//Uso da biblioteca Driver JDBC do PostgreSQL

import java.sql.*;

public class ConexaoDAO {
    
    //Criando um atributo do tipo Connection que servira para guardar a conexao 
    //com o banco de dados
    public static Connection con = null;
    
    ConexaoDAO(){
        
    }
    
    public static void ConectDB() {
        try {
            String dsn = "corretora_cunha";
            String user = "postgres";
            String senha = "1110110001";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
           
            con = DriverManager.getConnection(url, user, senha);
            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("Erro ao abrir o banco");
            }

        } catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados!" + e.getMessage());
        }
    }

    public static void CloseDB() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados!" + e.getMessage());
        }
    }

    public static Connection getConexao() throws SQLException {
        ConectDB();
        System.out.println("banco aberto");
        System.out.println(con);
        return con;
    }
}
