package Project.pkg305;

import java.io.*;
import java.net.*;
import java.util.*;

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
    public User(String phone, String email) {
        this.Phone = phone;
        this.UserEmail = email;
    }

    public User(String UserName, String userPassword, int UserID) {
        this.UserName = UserName;
        this.userPassword = userPassword;
        this.UserID = UserID;
    }

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

    public static User Login(String username, String password)  {

        user1 = MainClass.user;
        for (int i = 0; i < user1.size(); i++) {
            if (user1.get(i).getuserPassword().equals(password) && user1.get(i).getUserName().equals(username)) {
////                 (1) Create Socket obj 
//                try {
//                    System.out.println("in user");
//                    Socket s = new Socket("127.0.0.1", 8800);
//                    System.out.println("in user");
//                } catch (UnknownHostException e) {
//                    System.err.println("Host not found");
//                } catch (java.net.ConnectException e) {
//                    System.err.println("There are no connection at this port");
//                } catch (IOException e) {
//                    System.err.println(e.getMessage());
//                }

                return user1.get(i);
            }
        }

        return null;
//            // (1) Create Socket obj   
//            Socket s = new Socket("127.0.0.1", 8800);

        // (2) Create input stream obj (Scanner)
        //    Scanner in = new Scanner(s.getInputStream());
        // (3) Create output stream obj (PrintWriter)
        //  PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //   Scanner userInput = new Scanner(System.in);
//            while (true) {
//                String str = "";
//
//                str = in.nextLine();
//                System.out.println("Server says: " + str);
//
//                System.out.print("Enter your message: ");
//                str = userInput.nextLine();
//
//                out.println(str);
//
//                // (4) break if user enters BYE
//                if (str.equals("BYE")) {
//                    break;
//                }
//            }
//
//            // (5) close the socket
//            s.close();
    }
}
