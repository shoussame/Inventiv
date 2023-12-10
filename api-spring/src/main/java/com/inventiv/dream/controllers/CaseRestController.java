package com.inventiv.dream.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventiv.dream.dtos.CaseDTO;
import com.inventiv.dream.services.CaseService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseRestController {

    private final CaseService caseService;

    public CaseRestController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ResponseEntity<CaseDTO> createCase(@RequestBody CaseDTO caseDTO) {
        CaseDTO createdCase = caseService.createCase(caseDTO);
        return new ResponseEntity<>(createdCase, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseDTO> getCaseById(@PathVariable BigInteger id) {
        CaseDTO caseDTO = caseService.getCaseById(id);
        return ResponseEntity.ok(caseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CaseDTO>> getAllCases() {
        List<CaseDTO> cases = caseService.getAllCases();
        return ResponseEntity.ok(cases);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaseDTO> updateCase(@PathVariable BigInteger id, @RequestBody CaseDTO caseDTO) {
        CaseDTO updatedCase = caseService.updateCase(id, caseDTO);
        return ResponseEntity.ok(updatedCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable BigInteger id) {
        caseService.deleteCase(id);
        return ResponseEntity.noContent().build();
    }
}
