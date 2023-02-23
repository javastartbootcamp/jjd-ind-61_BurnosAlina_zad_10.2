package pl.javastart.task;

public class Phone {

    Contract contract;
    private int smsCounter = 0;
    private int mmsCounter = 0;
    private int callSecondsCounter = 0;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    void printAccountState() {
        System.out.println("=== STAN KONTA ===\nWysłanych SMSów: " + smsCounter + "\nWysłanych MMSów: " + mmsCounter +
                "\nLiczba sekund rozmowy: " + callSecondsCounter);
        contract.printAccountState();
    }

    void sendSms() {
        if (contract.canSmsBeSent()) {
            contract.sendSms();
            smsCounter++;
        }
    }

    void call(int seconds) {
        if (contract.canCallBeMade(seconds)) {
            contract.call(seconds);
            callSecondsCounter += seconds;
        } else {
            System.out.println("Połączenie nie może być zrealizowane");
        }
    }

    void sendMms() {
        if (contract.canMmsBeSent()) {
            contract.sendMms();
            mmsCounter++;
        }
    }
}
