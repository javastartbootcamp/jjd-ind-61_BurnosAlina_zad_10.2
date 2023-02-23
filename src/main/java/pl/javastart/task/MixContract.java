package pl.javastart.task;

public class MixContract extends CardPhoneContract {

    private int smsAmount;
    private int mmsAmount;
    private double callMinutesAmount;

    public MixContract(double accountBalance, double smsPrice, double mmsPrice, double callPrice,
                       int smsAmount, int mmsAmount, double callMinutesAmount) {
        super(accountBalance, smsPrice, mmsPrice, callPrice);
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.callMinutesAmount = callMinutesAmount;
    }

    @Override
    public void printAccountState() {
        System.out.println("Zostało SMSów: " + smsAmount + "\nZostało MMSów: " + mmsAmount +
                "\nZostało minut: " + callMinutesAmount);
        super.printAccountState();
    }

    @Override
    public void sendSms() {
        if (smsAmount > 0) {
            System.out.println("SMS wysłany");
            smsAmount--;
        } else {
            super.sendSms();
        }
    }

    @Override
    public void call(int seconds) {
        if (seconds <= callMinutesAmount * SECONDS_IN_MINUTE) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            callMinutesAmount = ((callMinutesAmount * SECONDS_IN_MINUTE) - seconds) / SECONDS_IN_MINUTE;
        } else {
            super.call(seconds);
        }
    }

    @Override
    public void sendMms() {
        if (mmsAmount > 0) {
            System.out.println("MMS wysłany");
            mmsAmount--;
        } else {
            super.sendMms();
        }
    }
}
