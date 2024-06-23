package net.javaguides.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto responseDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/{org-code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("org-code") String orgCode) {
        OrganizationDto responseDto = organizationService.getOrganization(orgCode);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
