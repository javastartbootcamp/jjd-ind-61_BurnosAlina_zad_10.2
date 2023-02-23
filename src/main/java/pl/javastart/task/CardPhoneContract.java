package pl.javastart.task;

public class CardPhoneContract implements Contract {

    static final int SECONDS_IN_MINUTE = 60;
    private double accountBalance;
    private double smsPrice;
    private double mmsPrice;
    private double oneMinuteCallPrice;

    public CardPhoneContract(double accountBalance, double smsPrice, double mmsPrice, double oneMinuteCallPrice) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.oneMinuteCallPrice = oneMinuteCallPrice;
    }

    @Override
    public void printAccountState() {
        System.out.println("Na koncie zostało: " + accountBalance);
    }

    @Override
    public boolean canSmsBeSent() {
        if (smsPrice <= accountBalance) {
            return true;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
            return false;
        }
    }

    @Override
    public void sendSms() {
        if (canSmsBeSent()) {
            System.out.println("SMS wysłany.");
            accountBalance -= smsPrice;
        }
    }

    @Override
    public boolean canCallBeMade(int seconds) {
        double callPrice = (oneMinuteCallPrice / SECONDS_IN_MINUTE * seconds);
        return callPrice <= accountBalance;
    }

    @Override
    public void call(int seconds) {
        double callPrice = (oneMinuteCallPrice / SECONDS_IN_MINUTE * seconds);
        if (canCallBeMade(seconds)) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            accountBalance -= callPrice;
        }
    }

    @Override
    public boolean canMmsBeSent() {
        if (mmsPrice <= accountBalance) {
            return true;
        } else {
            System.out.println("Nie udało się wysłać MMSa");
            return false;
        }
    }

    @Override
    public void sendMms() {
        if (canMmsBeSent()) {
            System.out.println("MMS wysłany.");
            accountBalance -= mmsPrice;
        }
    }
}
