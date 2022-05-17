package testsForBankCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    Account acct;
    @BeforeEach
    public void beginEachTestWith(){
        acct = new Account("Mercy", "Ojukwu", 21, "Female","mercy@gmail.com", "Student", "Nigerian", "Abia", "National pasport");
    }


    @Test
    public void createAccount(){
      acct.setName();
      assertEquals("Account name is: Mercy Ojukwu", acct.getName());
    }

    @Test
    public void createAccountNumber(){
        acct.generateAcctNo("12345");
        assertEquals("Account number is: 12345", acct.getAcctNo());
    }

    @Test
    public void depositIntoAccountWithCustomerDetails(){
        acct.generateAcctNo("12345");
        acct.depositIntoAccount("Mercy Ojukwu", "12345", 2000);
        assertEquals(2000, acct.getBalance());
    }

    @Test
    public void withdrawFromAccount(){
        acct.depositIntoAccount("Mercy Ojukwu", "12345", 2000);
        acct.withdrawFromAccount(0, "1234");
        assertEquals(2000, acct.getBalance());
    }

    @Test
    public void withdrawWithWrongPin(){
        acct.depositIntoAccount("Mercy Ojukwu","12345",5000);
        acct.withdrawFromAccount(2000, "0123");
        assertEquals(5000, acct.getBalance());
    }
}
