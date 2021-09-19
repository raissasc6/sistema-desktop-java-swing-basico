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
import br.com.corretora_cunha.dao.ConexaoDAO;
import br.com.corretora_cunha.dao.NegocioCorDAO;
import br.com.corretora_cunha.dto.CorretorDTO;
import br.com.corretora_cunha.dto.NegocioCorDTO;
import java.sql.ResultSet;

public class NegocioCorCTR {
    NegocioCorDAO negocioCorDAO = new NegocioCorDAO();

    public NegocioCorCTR() {
    }
     
     
     public String inserirNegocioCor(NegocioCorDTO negocioCorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCorDAO.inserirNegocioCor(negocioCorDTO)) {
                return "Corretor Adicionado com Sucesso!!!";
            } else {
                return "Negocio NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Negocio NÃO Cadastrado";
        }
    }//Fecha o método inserirNegocio
    
     public String excluirCorretor(CorretorDTO corretorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCorDAO.excluirCorretorNegocioCor(corretorDTO)) {
                return "Corretor Excluído com Sucesso!!!";
            } else {
                return "Corretor NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Corretor NÃO Excluído!!!";
        }
    }//Fecha o método excluirCorretor
     
     public String excluirNegocioCorretor(NegocioCorDTO negocioCorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (negocioCorDAO.excluirNegocioCor(negocioCorDTO)) {
                return "NegocioCor Excluído com Sucesso!!!";
            } else {
                return "Negocio Corretor NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "e_Corretor NÃO Excluído!!!";
        }
    }//Fecha o método excluirCorretor
    
    public ResultSet consultarNegocioCor(NegocioCorDTO negocioCorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = negocioCorDAO.consultarNegocioCor(negocioCorDTO, opcao);

        return rs;
    }//Fecha o método consultarCorretor
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
