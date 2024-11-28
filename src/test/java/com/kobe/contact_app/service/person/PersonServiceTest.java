package com.kobe.contact_app.service.person;

import com.kobe.contact_app.domain.person.Person;
import com.kobe.contact_app.domain.person.PersonRepository;
import com.kobe.contact_app.dto.person.request.PersonCreateRequest;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

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

    @Test
    void getPeopleByName() {
        // Given
        Person person1 = new Person("민성", "강", "01012345678", "test1@example.com");
        Person person2 = new Person("치즈", "강", "01056789012", "test2@example.com");

        when(personRepository.findByPartialName("강")).thenReturn(List.of(person1, person2));

        // When
        List<PersonResponse> responses = personService.getPeopleByName("강");

        // Then
        Assertions.assertThat(responses).hasSize(2);
        Assertions.assertThat(responses.get(0).getName()).isEqualTo("민성 강");
        Assertions.assertThat(responses.get(1).getName()).isEqualTo("치즈 강");
    }
}
