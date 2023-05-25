package Project.pkg305;

import static Project.pkg305.DBConnection.CreatConnection;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    String UserName = null;
    String userPassword = null;
    String UserEmail = null;
    String Phone;
    int UserID;
    ArrayList<Consultation> Customer_Consultation = new ArrayList<>();
    static ArrayList<User> user1 = new ArrayList<>();

    public User() {

    }

    //Constructer to initialize phone and email
    public User(String UserName, String userPassword, String phone, String email, int UserID) {
        this.UserName = UserName;
        this.userPassword = userPassword;
        this.Phone = phone;
        this.UserEmail = email;
        this.UserID = UserID;
        //  DBConnection.User1.add (this);
    }

    //Constructer to initialize phone and email
    public User(String phone, String email, int UserID) {
        this.Phone = phone;
        this.UserEmail = email;
        this.UserID = UserID;
    }

//    public User(String UserName, String userPassword, int UserID) {
//        this.UserName = UserName;
//        this.userPassword = userPassword;
//        this.UserID = UserID;
//    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String i) {
        this.UserName = i;
    }

    public String getuserPassword() {
        return userPassword;
    }

    public void setuserPassword(String i) {
        this.userPassword = i;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String y) {
        this.UserEmail = y;

    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void AddConsultation(Consultation con) {

        Customer_Consultation.add(con);
    }

    public Consultation getConsultation(int i) {

        return Customer_Consultation.get(i);
    }

    public void deletConsultation(int i) {

        Customer_Consultation.remove(i);
    }

    @Override
    public String toString() {
        return UserName + " " + userPassword + " " + UserID;
    }

    public static User Login(String username, String password) {
        User user = null;
        ResultSet resultSet = null;

        int id = DBConnection.searchUser(username, password);
        if (id != -1) {
            if (id < 20) {
                for (int i = 0; i < DBConnection.lawyer.size(); i++) {
                    if (id == (DBConnection.lawyer.get(i).getUserID())) // return list.get(i);
                    {
                        return DBConnection.lawyer.get(i);
//                        try {
//                            // (1) Create Socket obj   
//                            Socket s = new Socket("localhost", 8800);
//                            return DBConnection.lawyer.get(i);
//                        } catch (IOException ex) {
//                            System.out.println("issue in login interface connection");
//                        }
                    }
                }
            } else {

                for (int i = 0; i < DBConnection.Customer.size(); i++) {
                    if (id == (DBConnection.Customer.get(i).getUserID())) // return list.get(i);
                    {
                        // (1) Create Socket obj  
                        
                        return DBConnection.Customer.get(i);
//                                                try {
                            // (1) Create Socket obj   
//                            Socket s = new Socket("localhost", 8800);
//                           return DBConnection.Customer.get(i);
//                        } catch (IOException ex) {
//                            System.out.println("issue in login interface connection");
//                        }
                        
                    }
                }
            }

        }
        return null;
    }
}

//                
//                try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
//                    PreparedStatement statement = con.prepareStatement("SELECT * FROM Lawyer WHERE Id=?");
//                    statement.setInt(1, id);
//                    resultSet = statement.executeQuery();
//                    if (resultSet.next()) {
//                        user = new Lawyer(username, password, resultSet.getString("Name"),
//                                resultSet.getString("Phone"), resultSet.getString("Email"),
//                                resultSet.getString("Degree"), resultSet.getString("Specialty"),
//                                resultSet.getString("Cases_type"), resultSet.getDouble("Price"),
//                                resultSet.getInt("Num_of_consultations"), id,
//                                resultSet.getDouble("Lawyer_rate"));
//                        return user;
//
//                    }
//
//                } catch (Exception sqlEx) {
//                    System.out.println(sqlEx);
//                }
//                try (Connection con = CreatConnection(); Statement st = con.createStatement();) {
//                    PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE Id=?");
//                    statement.setInt(1, id);
//                    resultSet = statement.executeQuery();
//                    if (resultSet.next()) {
//
//                        user = new Customers(username, password, resultSet.getString("Name"),
//                                resultSet.getString("Phone"), resultSet.getString("Email"), id);
//                        return user;
//                    }
//                } catch (Exception sqlEx) {
//                    System.out.println(sqlEx);
//                }
//    public static User Login(String username, String password)  {
//
//        user1 = MainClass.user;
//        for (int i = 0; i < user1.size(); i++) {
//            if (user1.get(i).getuserPassword().equals(password) && user1.get(i).getUserName().equals(username)) {
//////                 (1) Create Socket obj 
////                try {
////                    System.out.println("in user");
////                    Socket s = new Socket("127.0.0.1", 8800);
////                    System.out.println("in user");
////                } catch (UnknownHostException e) {
////                    System.err.println("Host not found");
////                } catch (java.net.ConnectException e) {
////                    System.err.println("There are no connection at this port");
////                } catch (IOException e) {
////                    System.err.println(e.getMessage());
////                }
//
//                return user1.get(i);
//            }
//        }
//
//        return null;
////            // (1) Create Socket obj   
////            Socket s = new Socket("127.0.0.1", 8800);
//
//        // (2) Create input stream obj (Scanner)
//        //    Scanner in = new Scanner(s.getInputStream());
//        // (3) Create output stream obj (PrintWriter)
//        //  PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//        //   Scanner userInput = new Scanner(System.in);
////            while (true) {
////                String str = "";
////
////                str = in.nextLine();
////                System.out.println("Server says: " + str);
////
////                System.out.print("Enter your message: ");
////                str = userInput.nextLine();
////
////                out.println(str);
////
////                // (4) break if user enters BYE
////                if (str.equals("BYE")) {
////                    break;
////                }
////            }
////
////            // (5) close the socket
////            s.close();
//    }
//}
///////////////////////////////////////////
//            
//            while (DBConnection.Users.next()) {
//                if (name.equals(username) && pass.equals(password)) {
//
//                    int id = DBConnection.Users.getInt("Id");
//                    if (id < 20) {
//
//                        while (DBConnection.Lawyers.next()) {
//                            int lawyerId = DBConnection.Lawyers.getInt("Id");
//                            if (id == lawyerId) {
//                                user = new Lawyer(username, password, DBConnection.Lawyers.getString("Name"),
//                                    DBConnection.Lawyers.getString("Phone"), DBConnection.Lawyers.getString("Email"),
//                                   DBConnection.Lawyers.getString("Degree"), DBConnection.Lawyers.getString("Specialty"),
//                                 DBConnection.Lawyers.getString("Cases_type"), DBConnection.Lawyers.getDouble("Price"),
//                          DBConnection.Lawyers.getInt("Num_of_consultations"), lawyerId,
//                                DBConnection.Lawyers.getDouble("Lawyer_rate"));
//
//                            }
//                        }
//                    } else {
//                        while (DBConnection.Customers.next()) {
//                            int CustomerId = DBConnection.Customers.getInt("Id");
//                            if (id == CustomerId) {
//                                user = new Customers(username, password, DBConnection.Customers.getString("Name"),
//                            DBConnection.Customers.getString("Phone"), DBConnection.Customers.getString("Email"), CustomerId);
//
//                            }
//                        }
//
//                    }
//                   return user;
//                }
//            }
