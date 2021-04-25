package com.hippotech.approval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class ApprovalRequestController {
    private final ApprovalRequestRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ApprovalRequestController.class);

    ApprovalRequestController(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/approvals")
    List<ApprovalRequest> all() {
        return repository.findAll();
    }

    @GetMapping("/approvals/{id}")
    ApprovalRequest one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ApprovalRequestNotFoundException(id));
    }

    @PostMapping("/approvals")
    ApprovalRequest newApprovalRequest(ApprovalRequest newApprovalRequest) {
        URL url = null;
        HttpURLConnection con = null;

//        ProcessBuilder builder = new ProcessBuilder();
//        builder.command("sh", "-c", "echo", newApprovalRequest.getNationalInsuranceNumber());
//
//        try {
//            Process process = builder.start();
//            int exitCode = process.waitFor();
//        } catch (Exception e) {
//
//        }

        return repository.save(newApprovalRequest);
    }

    @PutMapping("/approvals/{id}")
    ApprovalRequest replaceApprovalRequest(ApprovalRequest approvalRequest, @PathVariable Long id) {
        return repository.save(approvalRequest);
    }

    @DeleteMapping("/appovals/{id}")
    void deleteApprovalRequest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
