package pl.javastart.task.phonelogic;

public class NoLimitContract implements Contract {

    private double monthlyPayment;

    public NoLimitContract(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void printAccountState() {
        System.out.println("Miesięczny abonament: " + monthlyPayment);
    }

    public boolean canSmsBeSent() {
        return true;
    }

    @Override
    public void sendSms() {
        System.out.println("SMS wysłany");
    }

    @Override
    public boolean canCallBeMade(int seconds) {
        return true;
    }

    @Override
    public void call(int seconds) {
        System.out.println("Rozmowa trwała " + seconds + " sekund");
    }

    @Override
    public boolean canMmsBeSent() {
        return true;
    }

    @Override
    public void sendMms() {
        System.out.println("MMS wysłany");
    }
}
