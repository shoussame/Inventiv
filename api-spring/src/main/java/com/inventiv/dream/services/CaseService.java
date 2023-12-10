package com.inventiv.dream.services;

import java.math.BigInteger;
import java.util.List;

import com.inventiv.dream.dtos.CaseDTO;

public interface CaseService {
	CaseDTO createCase(CaseDTO caseDTO);

    CaseDTO getCaseById(BigInteger id);

    List<CaseDTO> getAllCases();

    CaseDTO updateCase(BigInteger id, CaseDTO caseDTO);

    void deleteCase(BigInteger id);
}
