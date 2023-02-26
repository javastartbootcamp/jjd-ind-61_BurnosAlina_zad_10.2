package pl.javastart.task.phoneusage;

import pl.javastart.task.phonelogic.MixContract;
import pl.javastart.task.phonelogic.Phone;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixContract(0.5, 0.2, 0.3,
                0.5, 2, 2, 1));
        phone.printAccountState();
        phone.sendMms();
        phone.call(30);
        phone.printAccountState();
        phone.sendMms();
        phone.call(30);
        phone.printAccountState();
        phone.sendMms();
        phone.call(30);
        phone.printAccountState();
        phone.sendSms();
        phone.call(40);
        phone.printAccountState();
    }
}
