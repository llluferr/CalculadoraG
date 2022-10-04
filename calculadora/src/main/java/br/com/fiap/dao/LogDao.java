package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class LogDao {
    
    public void inserir(br.com.fiap.model.Log Log) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        var stm = con.prepareStatement("INSERT INTO DDD_CALCULADORA_TB_LOG VALUES (?, ?, ? ,?)");
        stm.setDouble(1, Log.getNumero1());
        stm.setDouble(1, Log.getNumero2());
        stm.setString(3, Log.getOperacao());
        stm.setDouble(4, Log.getResultado());
        
        stm.execute();
        stm.close();
    }

}
