package resources;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
	
public class ConnectDB {

	private static Connection connection = null;
    private static Session session = null;
    public static ArrayList list = new ArrayList();  
    
    public static Object get_dataUsername(String query, String database) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object username = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            switch (database) {
              case "prod":
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;
               case "staging":
              	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                   break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
            	username = rs.getObject("username");
           }
            
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
        
        return username;
    }     
    
      public static Object db_brandsItem(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object output = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              if (rs.next()) {
              	output = rs.getObject("brands_item");
             }
              
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
      
      public static Object db_productItem(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object output = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              if (rs.next()) {
              	output = rs.getObject("prod_item");
             }
              
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
      
      public static String arrayProdName(String query, String database) {
	      
 		 Connection con = null;
 	     Statement stmt = null;
 	     ResultSet rs = null;
 	     Object output = null;
 	     String prodname = null;
 	     ArrayList<prodName> product_Name;
 	     product_Name = new ArrayList<prodName>();
 	      try {
 	            Class.forName("com.mysql.jdbc.Driver");

 	            switch (database) {
 	                case "prod":
 	                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
 	                    break;
 	                case "staging":
 	                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
 	                    break;
 	                default:
 	                    throw new Exception("No Database with that name");
 	            }

 	            stmt = (Statement) con.createStatement();
 	            rs = stmt.executeQuery(query);


 	            while (rs.next()) {
 	                output = rs.getObject("prod_item");
 	                prodName pn = new prodName(output.toString());
 	                product_Name.add(pn);
 	            }

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

 	        prodname = product_Name.get(0).getProdName();
// 	          prnt = output.toString();

 	        return prodname;
      }   
      
      
      public static Object get_dataPoint(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object sumpoint = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              if (rs.next()) {
            	  sumpoint = rs.getObject("user_total_point");
             }
              
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
          
          return sumpoint;
      }     
}