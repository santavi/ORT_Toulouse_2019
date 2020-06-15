package ort.csi.fxminiproj.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBModelConnector {
    public static Connection getConnection() throws SQLException 
    {
        
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ort_javafx?zeroDateTimeBehavior=convertToNull&characterEncoding=latin1&useFastDateParsing=false&useConfigs=maxPerformance","root","SqlAdmin");
            return conn;
       
        
    }
}
