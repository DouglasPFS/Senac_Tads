package Agendamento.dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author João Pedro
 */
public class Conexao {

    static private Connection conexao;
    static public Statement statement;
    static public ResultSet resultset;
    static public PreparedStatement prep;

    public static void conecta() throws Exception {
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:Banco_PI2.db");
        
        
        statement = conexao.createStatement();
        
      
        //conexao.setAutoCommit(false);
        conexao.setAutoCommit(true);
    }
    
    public static void exec(String sql) throws Exception {
        resultset = statement.executeQuery(sql);
    }

    public static void desconecta() {
        boolean result = true;
        try {
            conexao.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel "
                    + "fechar o banco de dados: " + fecha);
            result = false;
        }
    }
}

