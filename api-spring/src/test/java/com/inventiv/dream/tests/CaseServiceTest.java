package com.inventiv.dream.tests;


import com.inventiv.dream.dtos.CaseDTO;
import com.inventiv.dream.entities.Case;
import com.inventiv.dream.mappers.CaseMapper;
import com.inventiv.dream.repositories.CaseRepository;
import com.inventiv.dream.services.impl.CaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class CaseServiceTest {

    @Mock
    private CaseRepository caseRepository;

    @Mock
    private CaseMapper caseMapper;

    @InjectMocks
    private CaseServiceImpl caseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCaseById() {
        BigInteger id = BigInteger.valueOf(1L);
        CaseDTO mockedCaseDTO = new CaseDTO();
        mockedCaseDTO.setId(id);

        when(caseRepository.findById(id)).thenReturn(java.util.Optional.of(new Case()));
        when(caseMapper.toDTO(any())).thenReturn(mockedCaseDTO);

        CaseDTO result = caseService.getCaseById(id);

        assertEquals(id, result.getId());
        verify(caseRepository, times(1)).findById(id);
        verify(caseMapper, times(1)).toDTO(any());
    }

    @Test
    public void testCreateCase() {
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setTitle("Test Title");
        caseDTO.setDescription("Test Description");

        when(caseMapper.toEntity(any())).thenReturn(new Case());
        when(caseRepository.save(any())).thenReturn(new Case());

        CaseDTO result = caseService.createCase(caseDTO);

        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(caseMapper, times(1)).toEntity(any());
        verify(caseRepository, times(1)).save(any());
    }

    @Test
    public void testGetAllCases() {
        when(caseRepository.findAll()).thenReturn(Arrays.asList(new Case(), new Case()));

        List<CaseDTO> result = caseService.getAllCases();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(caseRepository, times(1)).findAll();
        verify(caseMapper, times(2)).toDTO(any());
    }

    @Test
    public void testUpdateCase() {
        BigInteger id = BigInteger.valueOf(1L);
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setTitle("Updated Title");
        caseDTO.setDescription("Updated Description");

        when(caseRepository.findById(id)).thenReturn(Optional.of(new Case()));
        when(caseRepository.save(any())).thenReturn(new Case());

        CaseDTO result = caseService.updateCase(id, caseDTO);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
        verify(caseRepository, times(1)).findById(id);
        verify(caseRepository, times(1)).save(any());
    }

    @Test
    public void testDeleteCase() {
        BigInteger id = BigInteger.valueOf(1L);

        caseService.deleteCase(id);

        verify(caseRepository, times(1)).deleteById(id);
    }


}
