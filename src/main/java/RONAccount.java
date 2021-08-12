public class RONAccount implements Account{
    private float ronAmount;
    private String accountNr;

    public RONAccount(){
        ronAmount = 0;
    }

    @Override
    public boolean deposit(float amount) {
        if(amount > 1000){
            ronAmount+=amount;
        }
        return false;
    }

    @Override
    public boolean withdrawal(float amount){
        if(ronAmount < amount)
            return false;
        else{
            ronAmount-=amount;
            return true;
        }
    }

    @Override
    public float checkSold() {
        return ronAmount;
    }
}
