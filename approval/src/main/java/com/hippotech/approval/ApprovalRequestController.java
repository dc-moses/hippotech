package com.hippotech.approval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    ApprovalRequest newApprovalRequest(@RequestBody ApprovalRequest newApprovalRequest) {
        log.error(newApprovalRequest.getNationalInsuranceNumber());
        return repository.save(newApprovalRequest);
    }

    @PutMapping("/approvals/{id}")
    ApprovalRequest replaceApprovalRequest(@RequestBody ApprovalRequest approvalRequest, @PathVariable Long id) {
        return repository.save(approvalRequest);
    }

    @DeleteMapping("/appovals/{id}")
    void deleteApprovalRequest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
