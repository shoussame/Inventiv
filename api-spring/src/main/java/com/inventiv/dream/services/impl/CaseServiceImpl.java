package com.inventiv.dream.services.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inventiv.dream.dtos.CaseDTO;
import com.inventiv.dream.entities.Case;
import com.inventiv.dream.mappers.CaseMapper;
import com.inventiv.dream.repositories.CaseRepository;
import com.inventiv.dream.services.CaseService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CaseServiceImpl implements CaseService {
	private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;

    public CaseServiceImpl(CaseRepository caseRepository, CaseMapper caseMapper) {
        this.caseRepository = caseRepository;
        this.caseMapper = caseMapper;
    }

    @Override
    public CaseDTO createCase(CaseDTO caseDTO) {
        Case caseEntity = caseMapper.toEntity(caseDTO);
        Case savedCase = caseRepository.save(caseEntity);
        return caseMapper.toDTO(savedCase);
    }

    @Override
    public CaseDTO getCaseById(BigInteger id) {
        return caseRepository.findById(id)
                .map(caseMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Case not found with id: " + id));
    }

    @Override
    public List<CaseDTO> getAllCases() {
        List<Case> caseEntities = caseRepository.findAll();
        return caseEntities.stream()
                .map(caseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CaseDTO updateCase(BigInteger id, CaseDTO caseDTO) {
        Case existingCase = caseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));

        existingCase.setTitle(caseDTO.getTitle());
        existingCase.setDescription(caseDTO.getDescription());
        existingCase.setCreationDate(caseDTO.getCreationDate());
        existingCase.setLastUpdateDate(caseDTO.getLastUpdateDate());

        Case updatedCase = caseRepository.save(existingCase);
        return caseMapper.toDTO(updatedCase);
    }

    @Override
    public void deleteCase(BigInteger id) {
        caseRepository.deleteById(id);
    }
}
