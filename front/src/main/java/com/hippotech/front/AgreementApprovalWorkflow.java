package com.hippotech.front;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component("agreementApprovalWorkflow")
public class AgreementApprovalWorkflow {
    @Value("${approval.url:http://localhost:4002}")
    private String approvalUrl;

    Logger logger = LoggerFactory.getLogger(AgreementApprovalWorkflow.class);

    public void submitForApproval(ApprovalRequest approvalRequest) {
        try {
            String url = this.approvalUrl + "/approvals";

            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            sb.append(String.format("  \"propertyPostCode\" : \"%s\",\n", approvalRequest.getPropertyPostCode()));
            sb.append(String.format("  \"propertyValue\" : \"%d\",\n", approvalRequest.getPropertyValue()));
            sb.append(String.format("  \"amountToBorrow\" : \"%d\",\n", approvalRequest.getAmountToBorrow()));
            sb.append(String.format("  \"about\" : \"%s\",\n", approvalRequest.getAbout()));
            sb.append(String.format("  \"firstName\" : \"%s\",\n", approvalRequest.getFirstName()));
            sb.append(String.format("  \"lastName\" : \"%s\",\n", approvalRequest.getLastName()));
            sb.append(String.format("  \"nationalInsuranceNumber\" : \"%s\",\n", approvalRequest.getNationalInsuranceNumber()));
            sb.append(String.format("  \"country\" : \"%s\",\n", approvalRequest.getCountry()));
            sb.append(String.format("  \"streetAddress\" : \"%s\",\n", approvalRequest.getStreetAddress()));
            sb.append(String.format("  \"city\" : \"%s\",\n", approvalRequest.getCity()));
            sb.append(String.format("  \"postCode\" : \"%s\",\n", approvalRequest.getPostCode()));
            sb.append(String.format("  \"approvalNotifications\" : \"%s\",\n", approvalRequest.getApprovalNotifications() ? "true" : "false"));
            sb.append(String.format("  \"changeNotifications\" : \"%s\",\n", approvalRequest.getChangeNotifications() ? "true" : "false"));
            sb.append(String.format("  \"offerNotifications\" : \"%s\",\n", approvalRequest.getOfferNotifications() ? "true" : "false"));
            sb.append(String.format("  \"pushNotifications\" : \"%s\"\n", approvalRequest.getPushNotifications()));
            sb.append("}\n");
            String body = sb.toString();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(body, headers);
            restTemplate.postForObject(url, request, String.class);
        } catch (Exception e) {
        }
    }
}
