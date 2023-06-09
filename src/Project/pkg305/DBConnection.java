package Project.pkg305;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    //decler array list from lawyer class type to save the lawyer
    public static ArrayList<Lawyer> lawyer = new ArrayList<>();
    //decler array list from Customer class type to save the Customer
    public static ArrayList<Customers> Customer = new ArrayList<>();
    // public static ArrayList<User> User1 = new ArrayList<>();
    //decler array list from Consultation class type to save the Consultation
    public static ArrayList<Consultation> Consultation = new ArrayList<>();

    //Method to create connectin and the database
    public static Connection CreatConnection() {
        Connection con = null;
        try {

            // set the path for the database
            String ConnectionURL = "jdbc:mysql://localhost:3306/LwyerAdviceApp";
            //String ConnectionURL = "jdbc:mysql://localhost:3306";

            // create connection
            con = DriverManager.getConnection(ConnectionURL, "root", "1234");

            ////// this 2 lines is to creat the database 
            //Statement st = con.createStatement();
            //st.executeUpdate("CREATE DATABASE LwyerAdviceApp");
            return con;

        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    //Method to create tables
    public static void CreatTables() {
        String createTableSQL1 = "";
        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {

            //Lawyer table
            createTableSQL1 = "CREATE TABLE Lawyer "
                    + "(Name VARCHAR(250) ,"
                    + "  Phone VARCHAR(20) ,"
                    + "  Email VARCHAR(250) ,"
                    + "  Degree VARCHAR(250) ,"
                    + "  Specialty VARCHAR(250) ,"
                    + "  Cases_type VARCHAR(250) ,"
                    + "  Price DOUBLE NOT NULL,"
                    + "  Num_of_consultations INT ,"
                    + "  Id INT NOT NULL,"
                    + "  Lawyer_rate DOUBLE DEFAULT 5,"
                    + "  PRIMARY KEY (Id));";

            st.executeUpdate(createTableSQL1);

            //Customer table
            createTableSQL1 = "CREATE TABLE Customer ("
                    + "  Name VARCHAR(250) ,"
                    //                    + "  UserName VARCHAR(250) ,"
                    //                    + "  Password VARCHAR(250) ,"
                    + "  Email VARCHAR(250) ,"
                    + "  Phone VARCHAR(20) ,"
                    + "  Id INT ,"
                    + "  PRIMARY KEY (Id) );";

            st.executeUpdate(createTableSQL1);

            //Users table
            createTableSQL1 = "CREATE TABLE Users ("
                    + "  UserName VARCHAR(250) ,"
                    + "  Password VARCHAR(250) ,"
                    + "  Id INT ,"
                    + "  PRIMARY KEY (Id) );";

            st.executeUpdate(createTableSQL1);

            //Consultation table
            createTableSQL1 = "CREATE TABLE Consultation ("
                    + "  Id INT NOT NULL ,"
                    + "  Lawyer_id INT ,"
                    + "  customer_id INT ,"
                    + "  Date VARCHAR(250),"
                    + "  Day VARCHAR(250),"
                    + "  Time VARCHAR(250),"
                    + "  Available VARCHAR(250) ,"
                    + "  PRIMARY KEY (Id));";

            st.executeUpdate(createTableSQL1);

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }

    }

    //This methos will delet the table to reinsert it again when the mainCalss run again
    public static void DeletTables() {
        String createTableSQL1 = "";
        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {

            createTableSQL1 = "DROP TABLE Lawyer;";
            st.executeUpdate(createTableSQL1);

            createTableSQL1 = "DROP TABLE Customer;";
            st.executeUpdate(createTableSQL1);

            createTableSQL1 = "DROP TABLE Users;";
            st.executeUpdate(createTableSQL1);

            createTableSQL1 = "DROP TABLE Consultation;";
            st.executeUpdate(createTableSQL1);

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
    }

    //This mwthod will (1) drop the tables (2) Create the tables (3) insert the rows
    public static void inserting() {
        String createTableSQL1 = "";

        DeletTables();
        CreatTables();

        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {

            //Insert into Lawyer table
            createTableSQL1 = "INSERT INTO Lawyer "
                    + "(Name, Phone, Email, Degree, Specialty, Cases_type, Price, Num_of_consultations, Id)VALUES "
                    + "('Ahmed Alghamdi', '0503472498', 'AhmedAlghamdi@gmail.com', 'Bachelor', 'Law', 'financial cases', 150, 30, 1),"
                    + "('Khaled Alshehri', '0504768952', 'KhaledAlshehri@gmail.com', 'Master', 'Islamic studies', 'Commercial cases', 190, 34, 2),"
                    + "('Yusef Alghamdi', '0557687843', 'YusefAlghamdi@gmail.com', 'Bachelor', 'Law', 'Criminal cases', 180, 20, 3),"
                    + "('Rahaf Alhashmy', '0552736883','RahafAlhashmy@gmail.com', 'Master', 'Law', 'Personal status cases', 200, 50, 4);";

            st.executeUpdate(createTableSQL1);

            //Insert into Customer table
            createTableSQL1 = "INSERT INTO Customer (Name, Phone, Email,Id) VALUES "
                    + "('Sara Alharbi','0569474467','SaraAlharbi@gmail.com',20),"
                    + "('Leen Alzahrani','0589651775','LeenAlzahrani@gmail.com',22),"
                    + "('Hossam Albishi','0569474467','HossamAlbishi@gmail.com',24);";

            st.executeUpdate(createTableSQL1);

            //Insert into Users table
            createTableSQL1 = "INSERT INTO Users VALUES "
                    + "('Ahmed','A12234',1),"
                    + "('Khaled','K12234',2),"
                    + "('Yusef','Y12234',3),"
                    + "('Rahaf','R12234',4),"
                    + "('Sara','S12234',20),"
                    + "('Leen','L12234',22),"
                    + "('Hossam','H12234',24);";

            st.executeUpdate(createTableSQL1);

            //Insert into Consultation table
            createTableSQL1 = "INSERT INTO Consultation "
                    + "(Id , Lawyer_id , Date , Day , Time, Available )VALUES "
                    + "(100,1,'10:00am','Monday','16/07','Available'),"
                    + "(101,2,'1:15pm','Thursday','20/07','Available'),"
                    + "(103,3,'9:00pm','Sunday','24/07','Available'),"
                    + "(104,4,'9:30am','Wednesday','28/07','Available');";

            st.executeUpdate(createTableSQL1);

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
    }

    //This method will search for the user in user tables using his UserName & Password
    public static int searchUser(String UserName, String Password) {
        try (Connection con = CreatConnection(); PreparedStatement statement = con.prepareStatement("SELECT * FROM lwyeradviceapp.users WHERE UserName=? AND Password=?");) {

            statement.setString(1, UserName);
            statement.setString(2, Password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                return id;
            }

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
        return -1;
    }

     //This method will copy the lawyer table into Arraylist
    public static void GetLawyers() {

        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
            String selectSQL = "SELECT * FROM Lawyer";
            ResultSet resultSet = st.executeQuery(selectSQL);
            while (resultSet.next()) {
                lawyer.add(new Lawyer(resultSet.getString("Name"),
                        resultSet.getString("Phone"), resultSet.getString("Email"),
                        resultSet.getString("Degree"), resultSet.getString("Specialty"),
                        resultSet.getString("Cases_type"), resultSet.getDouble("Price"),
                        resultSet.getInt("Num_of_consultations"), resultSet.getInt("Id"),
                        resultSet.getDouble("Lawyer_rate")));

            }

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
    }

    //This method will copy the Customer table into Arraylist
    public static void GetCustomers() {

        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
            String selectSQL = "SELECT * FROM Customer";
            ResultSet resultSet = st.executeQuery(selectSQL);
            while (resultSet.next()) {
                Customer.add(new Customers(resultSet.getString("Name"),
                        resultSet.getString("Phone"), resultSet.getString("Email"), resultSet.getInt("Id")));
            }

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }

    }

    //This method will copy the Consultation table into Arraylist
    public static void GetConsultations() {

        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
            String selectSQL = "SELECT * FROM Consultation";
            ResultSet resultSet = st.executeQuery(selectSQL);
            while (resultSet.next()) {

                Consultation.add(new Consultation(resultSet.getInt("Id"),
                        resultSet.getInt("Lawyer_id"), resultSet.getString("Date"), resultSet.getString("Day"), resultSet.getString("Time"),
                        resultSet.getString("Available")));
            }

        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }

    }

    //This method will update the Consultation stat 
    public static void updateConsultation(int id) {
        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
            PreparedStatement statement = con.prepareStatement(
                    "UPDATE Consultation SET Available = 'Not Available' WHERE Id = ?");
            statement.setInt(1, id);
            // Execute the update query
            int rowsUpdated = statement.executeUpdate();

            // Print the number of rows updated
            System.out.println(rowsUpdated + " rows updated.");
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }

    }
   //This method will search for the Customer in Customer tables using his Id
    public static String SearchCustomer(int id) {
        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM Customer WHERE Id = ?");
            statement.setInt(1, id);
            // Execute the update query
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "Name: " + resultSet.getString("Name") + " , Email: " + resultSet.getString("Email");
            } else {
                return "No customer found with ID " + id;
            }
            //return "Name: " + resultSet.getString("Name") + " , Email: " + resultSet.getString("Email");
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
        return "";
    }
}
//    public static void main(String[] args) throws IOException, SQLException {
//        PrintWriter p = new PrintWriter("Descrption.txt");
//        p.close();
//
//        //DBConnection.CreatConnection();
//        // DBConnection.CreatTables();
//        DBConnection.inserting();
//
//////        
////         DBConnection.GetCustomers();
////         DBConnection.GetLawyers();
////         DBConnection.GetConsultations();
//        try (ServerSocket s = new ServerSocket(8800)) {
//            System.out.println("Application Running...");
//            int i = 1;
//            while (true) {
//                Socket incom = s.accept();
//                System.out.println("Client Number: " + i);
//                System.out.println("Client connect via: " + incom.getInetAddress());
//                i++;
//
//            }
//
//        }
//    }
//}
//////////////////////////////////////////////////////
//    public static ResultSet searchCustomer(int id) {
//        try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
//            PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE Id=?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            return resultSet;
//
//        } catch (Exception sqlEx) {
//            System.out.println(sqlEx);
//        }
//
//        return null;
//    }
//}
