package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;

    @BeforeEach  public void beginEachTestWith(){
        contactRepository = new ContactRepositoryImpl();
    }

    @Test public void saveContact_countIsOneTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test public void saveContactTwice_countIsTwoTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());

        Contact savedContact2 = contactRepository.save(contact);
        assertEquals(2, savedContact2.getId());
        assertEquals(2, contactRepository.count());
    }

    @Test public void saveContactTwice_findByIdReturnsContactTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");
        Contact contact1 = new Contact();
        contact1.setFirstName("Joseph");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact1);

        Contact foundContact = contactRepository.findById(1);
        Contact secondContact = contactRepository.findById(2);

        assertEquals(1, foundContact.getId());
        assertEquals(2, secondContact.getId());
        assertEquals("Mary", foundContact.getFirstName());
        assertEquals("Joseph", secondContact.getFirstName());

    }

    @Test public void saveContact_findByFirstNameTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact2);

        Contact foundById = contactRepository.findById(1);
        Contact foundById2 = contactRepository.findById(2);

        Contact foundByFirstName = contactRepository.findByFirstName("Mary");
        Contact foundByFirstName2 = contactRepository.findByFirstName("Philip");

        assertEquals("Mary", foundByFirstName.getFirstName());
        assertEquals("Philip", foundByFirstName2.getFirstName());

    }

    @Test public void saveContact_findByLastNameTest(){
            Contact contact  = new Contact();
            contact.setLastName("Mary");

            Contact contact2  = new Contact();
            contact2.setLastName("Philip");

            Contact savedContact = contactRepository.save(contact);
            Contact savedContact2 = contactRepository.save(contact2);

            Contact foundByFirstName = contactRepository.findByLastName("Mary");
            Contact foundByFirstName2 = contactRepository.findByLastName("Philip");

            assertEquals("Mary", foundByFirstName.getLastName());
            assertEquals("Philip", foundByFirstName2.getLastName());

        }

}

