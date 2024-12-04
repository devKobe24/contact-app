package com.kobe.contact_app.service.person;

import com.kobe.contact_app.domain.person.Person;
import com.kobe.contact_app.domain.person.PersonRepository;
import com.kobe.contact_app.dto.person.request.create.PersonCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePerson() {
        // Given
        PersonCreateRequest request = new PersonCreateRequest("민성", "강", "01012345678", "test1@example.com");
        Person person = new Person("민성", "강", "01012345678", "test1@example.com");

        when(personRepository.save(any(Person.class))).thenReturn(person);

        // When
        personService.savePerson(request);

        // Then
        verify(personRepository, times(1)).save(any(Person.class));
    }
}
