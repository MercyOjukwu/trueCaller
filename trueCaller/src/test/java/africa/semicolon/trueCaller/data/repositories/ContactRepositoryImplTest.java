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
        contactRepository.save(contact);
        contactRepository.save(contact1);

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

        contactRepository.save(contact);
        contactRepository.save(contact2);

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

            contactRepository.save(contact);
            contactRepository.save(contact2);

            Contact foundByLastName = contactRepository.findByLastName("Mary");
            Contact foundByLastName2 = contactRepository.findByLastName("Philip");

            assertEquals("Mary", foundByLastName.getLastName());
            assertEquals("Philip", foundByLastName2.getLastName());

        }

    @Test public void saveContact_findByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        contactRepository.save(contact);

        Contact updatedContact = contactRepository.updateContact(contact, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_findOneByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        contactRepository.save(contact);
        contactRepository.save(contact2);


        Contact updatedContact = contactRepository.updateContact(contact2, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_DeleteContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        contactRepository.save(contact);
        contactRepository.save(contact2);

        contactRepository.deleteContact(contact);
        contactRepository.deleteContact(contact2);

        assertEquals(0, contactRepository.count());


    }

}

