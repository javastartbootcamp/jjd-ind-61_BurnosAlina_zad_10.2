package pl.javastart.task.phonelogic;

public class Phone {

    Contract contract;
    private int smsCounter = 0;
    private int mmsCounter = 0;
    private int callSecondsCounter = 0;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===\nWysłanych SMSów: " + smsCounter + "\nWysłanych MMSów: " + mmsCounter +
                "\nLiczba sekund rozmowy: " + callSecondsCounter);
        contract.printAccountState();
    }

    public void sendSms() {
        if (contract.canSmsBeSent()) {
            contract.sendSms();
            smsCounter++;
        }
    }

    public void call(int seconds) {
        if (contract.canCallBeMade(seconds)) {
            contract.call(seconds);
            callSecondsCounter += seconds;
        } else {
            System.out.println("Połączenie nie może być zrealizowane");
        }
    }

    public void sendMms() {
        if (contract.canMmsBeSent()) {
            contract.sendMms();
            mmsCounter++;
        }
    }
}
