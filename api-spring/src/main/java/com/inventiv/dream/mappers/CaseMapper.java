package com.inventiv.dream.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inventiv.dream.dtos.CaseDTO;
import com.inventiv.dream.entities.Case;

@Component
public class CaseMapper {
	private final ModelMapper modelMapper;

    public CaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CaseDTO toDTO(Case caseEntity) {
        return modelMapper.map(caseEntity, CaseDTO.class);
    }

    public Case toEntity(CaseDTO caseDTO) {
        return modelMapper.map(caseDTO, Case.class);
    }
}
