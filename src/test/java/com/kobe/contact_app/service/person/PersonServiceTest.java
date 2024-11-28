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

    @Test
    void getPeopleByPhoneNumber() {
        // Given
        Person person1 = new Person("민성", "강", "01012345678", "test1@example.com");
        Person person2 = new Person("치즈", "강", "01056789012", "test2@example.com");

        when(personRepository.findByPhoneNumber("01012345678")).thenReturn(List.of(person1));
        when(personRepository.findByPhoneNumber("010")).thenReturn(List.of(person1, person2));

        // When
        List<PersonResponse> responses0 = personService.getPeopleByPhoneNumber("01012345678");
        List<PersonResponse> responses1 = personService.getPeopleByPhoneNumber("010");

        // Then
        Assertions.assertThat(responses0).hasSize(1);
        Assertions.assertThat(responses0.get(0).getName()).isEqualTo("민성 강");
        Assertions.assertThat(responses1).hasSize(2);
        Assertions.assertThat(responses1.get(0).getName()).isEqualTo("민성 강");
        Assertions.assertThat(responses1.get(1).getName()).isEqualTo("치즈 강");
    }

    @Test
    void getPeopleByAlphabet() {
        // Given
        Person person1 = new Person("Minseong", "Kang", "01012345678", "test1@example.com");
        Person person2 = new Person("Chezz", "Kang", "01056789012", "test2@example.com");

        when(personRepository.findByNameAsAlphabet(person1.getLastName())).thenReturn(List.of(person1, person2));

        // When
        List<PersonResponse> responses = personService.getPeopleByAlphabet("Kang");

        // Then
        Assertions.assertThat(responses).hasSize(2);
        Assertions.assertThat(responses.get(0).getName()).isEqualTo("Minseong Kang");
        Assertions.assertThat(responses.get(1).getName()).isEqualTo("Chezz Kang");
    }
}
