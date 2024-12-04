package com.kobe.contact_app.service.data;

import com.kobe.contact_app.repository.data.ContactDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactDataService {

    private final ContactDataRepository contactDataRepository;

    public ContactDataService(ContactDataRepository contactDataRepository) {
        this.contactDataRepository = contactDataRepository;
    }

    @Transactional
    public void deleteAllData() {
        contactDataRepository.deleteAllData();
    }

    @Transactional
    public void deleteAllInfoById(Long id) {
        contactDataRepository.deleteAllInfoById(id);
    }
}
