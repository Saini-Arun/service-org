package net.javaguides.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.exception.OrganizationAlreadyExist;
import net.javaguides.organizationservice.mapper.OrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        if(organizationRepository.existsByOrganizationCode(organizationDto.getOrganizationCode())){
            throw new OrganizationAlreadyExist("Organization Code Already In Use.");
        }
        Organization incoming= OrganizationMapper.mapToOrganization(organizationDto);
        Organization response= organizationRepository.save(incoming);
        return OrganizationMapper.mapToOrganizationDto(response);
    }

    @Override
    public OrganizationDto getOrganization(String organizationCode) {
        if(!organizationRepository.existsByOrganizationCode(organizationCode)){
            return new OrganizationDto(
                    null,
                    null,
                    null,
                    null,
                    LocalDateTime.MIN);
        }
        Organization response=organizationRepository.findByOrganizationCode(organizationCode).get();
        OrganizationDto responseDto= OrganizationMapper.mapToOrganizationDto(response);
        return responseDto;
    }
}
