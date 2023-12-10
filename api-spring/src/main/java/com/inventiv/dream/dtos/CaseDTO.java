package com.inventiv.dream.dtos;

import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CaseDTO {
	private BigInteger id;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;
}
