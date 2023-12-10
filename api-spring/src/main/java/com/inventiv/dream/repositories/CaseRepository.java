package com.inventiv.dream.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventiv.dream.entities.Case;

public interface CaseRepository extends JpaRepository<Case, BigInteger> {

}
