package com.inventiv.dream.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "casestable")
public class Case {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT")
    private BigInteger id;
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdateDate;
	private String title;
	private String description;

}
 