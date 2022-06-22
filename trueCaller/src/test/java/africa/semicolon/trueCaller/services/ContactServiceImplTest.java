package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    private ContactService contactService;
    private ContactRepository contactRepository;

    @BeforeEach void beginEachWith(){
        contactService = new ContactServiceImpl(contactRepository);
    }


    @Test public void saveContact_findContactReturnsContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        contactService.save(contact);
        Contact foundContact = contactService.findById(1);

        assertEquals("Mary", foundContact.getFirstName());

    }

    @Test public void saveContactTwice_countIsTwoTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact savedContact = contactService.save(contact);
        assertEquals(1, savedContact.getId());

        Contact savedContact2 = contactService.save(contact);
        assertEquals(2, savedContact2.getId());
        assertEquals(2, contactService.count());
    }

    @Test public void saveContactTwice_findByIdReturnsContactTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");
        Contact contact1 = new Contact();
        contact1.setFirstName("Joseph");
        contactService.save(contact);
        contactService.save(contact1);

        Contact foundContact = contactService.findById(1);
        Contact secondContact = contactService.findById(2);

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

        contactService.save(contact);
        contactService.save(contact2);

        Contact foundByFirstName = contactService.findByFirstName("Mary");
        Contact foundByFirstName2 = contactService.findByFirstName("Philip");

        assertEquals("Mary", foundByFirstName.getFirstName());
        assertEquals("Philip", foundByFirstName2.getFirstName());

    }

    @Test public void saveContact_findByLastNameTest(){
        Contact contact  = new Contact();
        contact.setLastName("Mary");

        Contact contact2  = new Contact();
        contact2.setLastName("Philip");

        contactService.save(contact);
        contactService.save(contact2);

        Contact foundByLastName = contactService.findByLastName("Mary");
        Contact foundByLastName2 = contactService.findByLastName("Philip");

        assertEquals("Mary", foundByLastName.getLastName());
        assertEquals("Philip", foundByLastName2.getLastName());

    }

    @Test public void saveContact_findByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        contactService.save(contact);

        Contact updatedContact = contactService.updateContact(contact, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_findOneByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        contactService.save(contact);
        contactService.save(contact2);


        Contact updatedContact = contactService.updateContact(contact2, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_DeleteContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        contactService.save(contact);
        contactService.save(contact2);

        contactService.deleteContact(contact);
        contactService.deleteContact(contact2);

        assertEquals(0, contactService.count());


    }
}