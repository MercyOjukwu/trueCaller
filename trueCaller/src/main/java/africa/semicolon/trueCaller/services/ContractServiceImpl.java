package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

public class ContractServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    public ContractServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {

    }

    @Override
    public Contact findById(int i){
        return null;
    }
}
