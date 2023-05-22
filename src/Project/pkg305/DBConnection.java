package Project.pkg305;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection {
    public static void CreatConnection (){
        Connection con = null;
            try {

                // (1) set the path for the database
                String ConnectionURL = "jdbc:mysql://localhost:3306";

                // (2) create connection
                con = DriverManager.getConnection(ConnectionURL, "root", "1234");

                // (3) create statment object
                Statement st = con.createStatement();

//                // (4) excute sql statment
//                st.executeUpdate("CREATE DATABASE ShathaAlharbi2006080" );
//
//                System.out.println("1 row(s) affacted");
//
//                // (5) close connection
//                con.close();
            } catch (SQLException s) {
                System.out.println("SQL statement is not executed!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
