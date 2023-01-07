package com.hari.policytracker.service;

import java.util.List;

import com.hari.policytracker.model.Policy;

public interface PolicyService {

    Policy savePolicy(Policy policy);

    List<Policy> getAllPolicies();

    String deletePolicyById(Long id);

    Policy updatePolicyById(Policy policy, Long id);

    Policy getPolicyById(Long id);

    List<Policy> listAll();
    
}
