public class Client {
    private String cnp;
    private String password;
    private Account ronAccount;
    private Account euroAccount;

    public Client(String cnp, String password, String ronAmount, String euroAmount){
        this.cnp = cnp;
        this.password = password;
        AccountFactory accountFactory= new AccountFactory();
        ronAccount = accountFactory.getType(ronAmount);
        euroAccount = accountFactory.getType(euroAmount);
    }

}
