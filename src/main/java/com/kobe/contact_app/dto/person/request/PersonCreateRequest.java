package com.kobe.contact_app.dto.person.request;

import com.kobe.contact_app.util.name.NameStateProcessor;
import io.swagger.v3.oas.annotations.media.Schema;

public class PersonCreateRequest {
    @Schema(description = "연락처의 이름 정보. null 값이 될 수 있습니다.", example = "민성")
    private String firstName;

    @Schema(description = "연락처의 성 정보. null 값이 될 수 있습니다.", example = "강")
    private String lastName;

    @Schema(description = "연락처의 전화번호 정보. 이름,성,이메일 정보가 없을 경우 null 값이 될 수 없습니다. 이메일 정보가 있을 경우 null 값이 될 수 있습니다.", example = "01012345678")
    private String phoneNumber;

    @Schema(description = "연락처의 이메일 정보. 이름,성,전화번호 정보가 없을 경우 null 값이 될 수 없습니다. 전화번호 정보가 있을 경우 null 값이 될 수 있습니다.", example = "test1@example.com")
    private String email;

    public PersonCreateRequest(String firstName, String lastName, String phoneNumber, String email) {
        NameStateProcessor.determineFirstNameAndLastNameState(firstName, lastName, phoneNumber, email, (resultFirstName, resultLastName, resultPhoneNumber, resultEmail) -> {
            this.firstName = resultFirstName;
            this.lastName = resultLastName;
            this.phoneNumber = resultPhoneNumber;
            this.email = resultEmail;
        });
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
