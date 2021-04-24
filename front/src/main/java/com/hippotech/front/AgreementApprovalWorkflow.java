package com.hippotech.front;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@Component("agreementApprovalWorkflow")
public class AgreementApprovalWorkflow {
    @Value("${approval.url}")
    private String approvalUrl;

    Logger logger = LoggerFactory.getLogger(AgreementApprovalWorkflow.class);

    public void submitForApproval(ApprovalRequest approvalRequest) {
        try {
            String url = this.approvalUrl + "/approvals";

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("propertyPostCode", approvalRequest.getPropertyPostCode());
            map.add("propertyValue", Integer.toString(approvalRequest.getPropertyValue()));
            map.add("amountToBorrow", Integer.toString(approvalRequest.getAmountToBorrow()));
            map.add("about", approvalRequest.getAbout());
            map.add("firstName", approvalRequest.getFirstName());
            map.add("lastName", approvalRequest.getLastName());
            map.add("nationalInsuranceNumber", approvalRequest.getNationalInsuranceNumber());
            map.add("country", approvalRequest.getCountry());
            map.add("streetAddress", approvalRequest.getStreetAddress());
            map.add("city", approvalRequest.getCity());
            map.add("postCode", approvalRequest.getPostCode());
            map.add("approvalNotifications", approvalRequest.getApprovalNotifications() ? "true" : "false");
            map.add("changeNotifications", approvalRequest.getChangeNotifications() ? "true" : "false");
            map.add("offerNotifications", approvalRequest.getOfferNotifications() ? "true" : "false");
            map.add("pushNotifications", approvalRequest.getPushNotifications());

            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

//                    ProcessBuilder builder = new ProcessBuilder();
//                    builder.command("sh", "-c", "echo", approvalRequest.getNationalInsuranceNumber());
//
//                    try {
//                        Process process = builder.start();
//                        int exitCode = process.waitFor();
//                    } catch (Exception e) {
//
//                    }

            ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);
        } catch (Exception e) {
        }
    }
}
