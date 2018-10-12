package controller;

import java.sql.*;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class configapp {
	
    public static String getApID(String email,String database){
        Object o=configapp.getfromDatabase("SELECT a.apli_id FROM application_data as a INNER JOIN applicant_data as b on a.apli_ap_id=b.ap_id WHERE b.ap_email_address='"+email+"';", database);
        return o.toString();
    }
    
	
	public static Object getfromDatabase(String query, String database) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            switch (database) {
                case "local":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/tuingtuing", "root", "");
                    break;
               case "dev":
                  con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;                   
              case "hotfix":
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;
               case "staging":
//                  con = DriverManager.getConnection("jdbc:mysql://10.0.0.13/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
//            if (rs.next()) {
//            	output = rs.getObject("asp_code_sent");
//            }
            
        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
        	try {
				rs.close();
				stmt.close();
	            con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return output;
    }
	
}
