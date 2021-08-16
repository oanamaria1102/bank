import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients;

    public Bank(ArrayList<Client> clients){
        this.clients = clients;
    }

    public void createClientBankAccount(String cnp, String password, String confirmPassword){
        if(password.equals(confirmPassword))
        {
            Client client = new Client(cnp, password, "RON", "EURO");
            clients.add(client);
        }
    }

    public void closeAccount(Client c){
        
    }

    public void deleteClients(){

    }


//    try{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con=DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/bank","root","root");
//        Statement stmt=con.createStatement();
//        ResultSet rs=stmt.executeQuery("select * from emp");
//        while(rs.next())
//            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//        con.close();
//    }catch(Exception e){ System.out.println(e);}
}
