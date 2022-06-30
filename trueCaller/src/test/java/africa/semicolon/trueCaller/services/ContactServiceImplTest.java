package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    private ContactService contactService;

    @BeforeEach void beginEachWith(){
        contactService = new ContactServiceImpl();
    }

    @Test public void addContact_findById(){
        contactService.addContact("Mercy", "Ojukwu","12345");
        contactService.addContact("Mary", "Ojukwu","12345");

        Contact foundContact1 = contactService.findById("1");
        Contact foundContact2 = contactService.findById("2");

        assertEquals("2", foundContact2.getId());
    }

    @Test public void addContact_findByFirstName(){
        contactService.addContact("Mercy", "Ojukwu","12345");
        contactService.addContact("Mary", "Ojukwu","12345");

        Contact foundContact1 = contactService.findByFirstName("Mercy");

        assertEquals("Mercy", foundContact1.getFirstName());
    }



    @Test public void saveContactTwice_findByIdReturnsContactTest(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");
        Contact contact1 = new Contact();
        contact1.setFirstName("Joseph");


        Contact foundContact = contactService.findById("1");
        Contact secondContact = contactService.findById("2");

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


        Contact foundByLastName = contactService.findByLastName("Mary");
        Contact foundByLastName2 = contactService.findByLastName("Philip");

        assertEquals("Mary", foundByLastName.getLastName());
        assertEquals("Philip", foundByLastName2.getLastName());

    }

    @Test public void saveContact_findByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact updatedContact = contactService.updateContact(contact, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_findOneByFirstName_UpdateContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");


        Contact updatedContact = contactService.updateContact(contact2, "Joseph");

        assertEquals("Joseph", updatedContact.getFirstName());

    }

    @Test public void saveTwoContacts_DeleteContact(){
        Contact contact  = new Contact();
        contact.setFirstName("Mary");

        Contact contact2  = new Contact();
        contact2.setFirstName("Philip");

        contactService.deleteContact(contact);
        contactService.deleteContact(contact2);

//        assertEquals(0, contactService.count());


    }
}