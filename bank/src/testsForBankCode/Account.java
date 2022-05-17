package testsForBankCode;

import java.util.Objects;

public class Account {
    private final String meansOfIdentification;
    private String name;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String email;
    private String occupation;
    private String nationality;
    private String stateOfNigerian;
    private String accountNumber;
    private int amountDeposited;
    private int amountToWithdraw;
    private int balance;
    private String pin;

    public Account(String firstName, String lastName, int age, String gender, String email, String occupation, String nationality, String stateOfOrigin,String meansOfIdentification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.occupation = occupation;
        this.nationality = nationality;
        this.stateOfNigerian = stateOfOrigin;
        this.meansOfIdentification = meansOfIdentification;
    }



    public void setName() {
        name = firstName +" "+ lastName;
    }

    public String getName() {
        return "Account name is: "+name;
    }

    public void generateAcctNo(String accountNumber) {
       this.accountNumber = accountNumber;
    }

    public String getAcctNo() {
        return "Account number is: "+accountNumber;
    }

    public void depositIntoAccount(String name, String accountNumber, int amount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.amountDeposited = amount;
        if (amount > 0) { balance += amount;}
        else balance = 0;
    }

    public int getBalance() {

        return balance;
    }

    public void withdrawFromAccount(int amount, String pin) {
        this.amountToWithdraw = amount;
        this.pin = pin;
        if (amount > 0) { balance -= amount;}
        if(this.pin != pin){ balance = amountDeposited;}
    }
}
