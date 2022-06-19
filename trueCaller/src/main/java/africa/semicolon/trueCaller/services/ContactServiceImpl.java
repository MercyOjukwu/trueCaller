package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
//        ContactRepositoryImpl.save();
    }

    @Override
    public Contact findById(int i){
        return null;
    }
}
