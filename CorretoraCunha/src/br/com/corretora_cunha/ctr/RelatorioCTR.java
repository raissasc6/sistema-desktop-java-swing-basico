package br.com.corretora_cunha.ctr;

import br.com.corretora_cunha.dao.ConexaoDAO;
import java.sql.*;
import java.io.InputStream;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class RelatorioCTR {

    public JFrame abrirRelatorio(String relatorio, String titulo, Map parametros) throws JRException, SQLException {

//        try {
        // Cria um Stream com os dados do relatório
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("br/com/corretora_cunha/rels/"+relatorio);
        // Gerando a impressao do relatório
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, getConexao());
       System.out.println(print);
        //Fechando o banco de dados que foi aberto para gerar o relatório
        System.out.println("Fechando o banco de dados que foi aberto para gerar o relatório");
        CloseDB();
        
        // montando a visualização do relatório
        JRViewer viewer = new JRViewer(print);
        System.out.println("oi3");
        // criando um FRAME para exibir o relatório
        JFrame frameRelatorio = new JFrame(titulo);

        // adiciona o JRViewer no JFrame
        frameRelatorio.add(viewer);

        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // retorna o JFrame com o relatório oara ser mostrado na view
        return frameRelatorio;
//        } catch (Exception e) {
//            System.out.println("Entrou erro metodo abrirRelatorio");
//            System.out.println(e.getMessage());
//            return null;
//        }
    }

     public JFrame abrirUmRelatorio(String relatorio, String titulo, Map parametros) throws JRException, SQLException {

//        try {
        // Cria um Stream com os dados do relatório
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("br/com/corretora_cunha/rels/"+relatorio);
        // Gerando a impressao do relatório
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, getConexao());
       System.out.println(print);
        //Fechando o banco de dados que foi aberto para gerar o relatório
        System.out.println("Fechando o banco de dados que foi aberto para gerar o relatório");
        CloseDB();
        
        // montando a visualização do relatório
        JRViewer viewer = new JRViewer(print);
        System.out.println("oi3");
        // criando um FRAME para exibir o relatório
        JFrame frameRelatorio = new JFrame(titulo);

        // adiciona o JRViewer no JFrame
        frameRelatorio.add(viewer);

        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // retorna o JFrame com o relatório oara ser mostrado na view
        return frameRelatorio;
//        } catch (Exception e) {
//            System.out.println("Entrou erro metodo abrirRelatorio");
//            System.out.println(e.getMessage());
//            return null;
//        }
    }

    /**
     * Método utilizado para controlar o acesso ao método ConectDB da classe
     * ConexaoDAO
     *
     * @param não recebe paramero
     * @return não possui retorno
     */
    public Connection getConexao() throws SQLException {
        return ConexaoDAO.getConexao();
    }//Fecha o metodo ConectDB

    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     *
     * @param não recebe paramero
     * @return não possui retorno
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o metodo CloseDB

}
