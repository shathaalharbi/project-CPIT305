package Project.pkg305;

import java.util.ArrayList;

public class Customers extends User {

    String Name;

    public Customers(String Name, String phone, String email, int id) {
        super(phone, email, id);
        this.Name = Name;

    }

    //Method that takes the name enterd by user and th array list to serach by lawyer name 
    public static Lawyer searchForLawyer(String name) {
        for (int i = 0; i < DBConnection.lawyer.size(); i++) {

            if (DBConnection.lawyer.get(i).getNames().equals(name)) {
                return DBConnection.lawyer.get(i);
            }
        }
        return null;
    }

    public static Customers searchForCustomer(int n) {
        System.out.println(DBConnection.Customer.size());
        for (int i = 0; i < DBConnection.Customer.size(); i++) {
            if (DBConnection.Customer.get(i).getUserID() == n) {
                System.out.println("what the ");
                return DBConnection.Customer.get(i);
            }
        }
        return null;
    }

    public static Lawyer searchForLawyer(int n) {
        for (int i = 0; i < DBConnection.lawyer.size(); i++) {

            if (DBConnection.lawyer.get(i).getUserID() == n) {
                return DBConnection.lawyer.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return "Name: " + Name + " , Email: " + super.getUserEmail();
    }
}

//        
//        try (Connection con = CreatConnection(); PreparedStatement statement = con.prepareStatement("SELECT * FROM Lawyer WHERE Name=?");) {
//            statement.setString(1, name);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                s = "-----------------------------------\n"
//                        + "The Lawyer name is: " + resultSet.getString("Name") + "\n" + "Email: " + resultSet.getString("Email") + "\n"
//                        + "The Degree is: " + resultSet.getString("Degree") + "\n" + "The Specialty is: " + resultSet.getString("Specialty") + "\n" + "The Case Type is : "
//                        + resultSet.getString("Cases_type") + "\n" + "The Consultations price is: " + resultSet.getDouble("Price") + "\n" + "The number Of Consultations is: "
//                        + resultSet.getInt("Num_of_consultations") + "\nThe Lawyer rate is: " + resultSet.getDouble("Lawyer_rate")
//                        + "\n-----------------------------------\n";
//            }
//
//        } catch (Exception sqlEx) {
//            System.out.println(sqlEx);
//        }
//public static String searchForLawyer(String name, ArrayList<Lawyer> list) {
////        for(int i=0;i<list.size();i++){
////            if(name.equalsIgnoreCase(list.get(i).getNames()))
////               // return list.get(i);
////        }
//        //  return null;
//    }
//}
