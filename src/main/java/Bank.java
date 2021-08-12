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
}
