package com.kobe.contact_app.controller;

import com.kobe.contact_app.dto.info.request.DeleteInfoRequest;
import com.kobe.contact_app.service.data.ContactDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Contact Data", description = "Contact Data API")
public class ContactDataController {
    private final ContactDataService contactDataService;

    public ContactDataController(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }

    @DeleteMapping("/deleteAll/data")
    @Operation(summary = "Delete all contact data", description = "저장되어있는 연락처 리스트 정보를 전부 삭제합니다.")
    public void deleteAllData() {
        contactDataService.deleteAllData();
    }

    @DeleteMapping("/deleteAll/info")
    @Operation(summary = "Delete all information", description = "연락처에 저장되어 있는 모든 정보를 삭제합니다.")
    public void deleteAllInfoById(@RequestBody DeleteInfoRequest request) {
        contactDataService.deleteAllInfoById(request.getId());
    }
}
