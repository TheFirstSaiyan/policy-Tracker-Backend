package com.hari.policytracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.policytracker.model.Policy;
import com.hari.policytracker.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    PolicyRepository policyRepository;
    @Override
    public Policy savePolicy(Policy policy) {
       
        return policyRepository.save(policy);
    }
    @Override
    public List<Policy> getAllPolicies() {
        // TODO Auto-generated method stub
        return policyRepository.findAll();
    }
    @Override
    public String deletePolicyById(Long id) {
        // TODO Auto-generated method stub
        policyRepository.deleteById(id);
        return "deleted";
    }
    @Override
    public Policy updatePolicyById(Policy policy, Long id) {
        // TODO Auto-generated method stub
        Policy currPolicy =  policyRepository.findById(id).get();
        currPolicy.setPolicyName(policy.getPolicyName());
        currPolicy.setPolicyDetails(policy.getPolicyDetails());
        currPolicy.setTenure(policy.getTenure());
        currPolicy.setPremiumAmount(policy.getPremiumAmount());
        currPolicy.setPremiumType(policy.getPremiumType());
        currPolicy.setNominees(policy.getNominees());
        currPolicy.setStartDate(policy.getStartDate());
        currPolicy.setLastDate(policy.getLastDate());
        return policyRepository.save(currPolicy);
    }
    @Override
    public Policy getPolicyById(Long id) {
        // TODO Auto-generated method stub
        return policyRepository.findById(id).get();
    }
    @Override
    public List<Policy> listAll() {
        // TODO Auto-generated method stub
        return policyRepository.findAll();
    }
    
}
