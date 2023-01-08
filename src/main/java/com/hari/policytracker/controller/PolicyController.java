package com.hari.policytracker.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hari.policytracker.model.Policy;
import com.hari.policytracker.service.PolicyService;

import jakarta.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
// @CrossOrigin(origins = "*")
public class PolicyController {
    
    @Autowired
    PolicyService policyService;

    @PostMapping(value = "/add")
    public Policy savePolicy(@Validated @RequestBody Policy policy)
    {
        return policyService.savePolicy(policy);
    }

    @GetMapping(value = "/policy/{id}")
    public Policy getPolicyById(@PathVariable("id") Long id)
    {
        return policyService.getPolicyById(id);
    }

    @GetMapping(value = "/policies")
    public List<Policy> getAllPolicies()
    {
        return policyService.getAllPolicies();
    }

    @DeleteMapping(value = "/deletePolicy/{id}")
    public String deletePolicyById(@PathVariable("id") Long id)
    {
        return policyService.deletePolicyById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/updatePolicy/{id}")
    public Policy updatePolicyById(@Validated @RequestBody Policy policy, @PathVariable("id") Long id)
    {
        return policyService.updatePolicyById(policy,id);
    }

    // @GetMapping("/policies/export")
    // public void exportToCSV(HttpServletResponse response) throws IOException {
    //     response.setContentType("text/csv");
    //     DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    //     String currentDateTime = dateFormatter.format(new Date());
         
    //     String headerKey = "Content-Disposition";
    //     String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
    //     response.setHeader(headerKey, headerValue);
         
    //     List<Policy> listPolicies = policyService.listAll();
 
    //     ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
    //     String[] csvHeader = {"ID", "Policy Name", "Policy Details","Tenure","Premium Type","Premium Amount", "Start Date", "Last Date", "Nominees"};
    //     String[] nameMapping = {"id", "policyName", "policyDetails","tenure","premiumType","premiumAmount", "startDate", "lastDate", "nominees"};
         
    //     csvWriter.writeHeader(csvHeader);
         
    //     for (Policy policy : listPolicies) {
    //         csvWriter.write(policy, nameMapping);
    //     }
         
    //     csvWriter.close();
         
    // }
    
}
