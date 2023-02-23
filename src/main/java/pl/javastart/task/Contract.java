package pl.javastart.task;

interface Contract {

    void sendSms();

    void printAccountState();

    boolean canSmsBeSent();

    void call(int seconds);

    boolean canCallBeMade(int seconds);

    void sendMms();

    boolean canMmsBeSent();

}
