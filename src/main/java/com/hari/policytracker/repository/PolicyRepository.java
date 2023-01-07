package com.hari.policytracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.policytracker.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long>{
    
}
