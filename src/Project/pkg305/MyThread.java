package Project.pkg305;

public class MyThread implements Runnable {

    String desc;
    User us;
    Consultation con;

    public MyThread( User us, Consultation con) {
        this.con=con;
        this.us= us;
       // this.desc= desc;

    }

    @Override
    public void run() {
        Consultation.BookConsultation(us,con);
    }
//     public static void main(String[] args){
//         System.out.println("-------------");
//         
//        DBConnection.GetCustomers();
//        DBConnection.GetLawyers();
//        DBConnection.GetConsultations();
//        Thread t1= new Thread(new MyThread( DBConnection.Customer.get(0),DBConnection.Consultation.get(0))); 
//        Thread t2= new Thread(new MyThread(DBConnection.Customer.get(1),DBConnection.Consultation.get(1)));
//        Thread t3= new Thread(new MyThread(DBConnection.Customer.get(2),DBConnection.Consultation.get(2)));
//
//       t3.start();
//       t1.start();
//       t2.start();
//        
//     }

}
