package com.hippotech.front;

import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgreementController {
    Logger logger = LoggerFactory.getLogger(AgreementController.class);

    @GetMapping("/agreement")
    public String getAgreement(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "agreement";
    }


    @Autowired
    public AgreementApprovalWorkflow workflow;

    @PostMapping("/agreement")
    public String postAgreement(@RequestParam(required=false, defaultValue="") String propertyPostCode,
                                @RequestParam(required=false, defaultValue="0") int propertyValue,
                                @RequestParam(required=false, defaultValue="0") int amountToBorrow,
                                @RequestParam(required=false, defaultValue="") String about,
                                @RequestParam(required=false, defaultValue="") String firstName,
                                @RequestParam(required=false, defaultValue="") String lastName,
                                @RequestParam(required=false, defaultValue="") String nationalInsuranceNumber,
                                @RequestParam(required=false, defaultValue="") String country,
                                @RequestParam(required=false, defaultValue="") String streetAddress,
                                @RequestParam(required=false, defaultValue="") String city,
                                @RequestParam(required=false, defaultValue="") String postCode,
                                @RequestParam(required=false, defaultValue="false") Boolean approval,
                                @RequestParam(required=false, defaultValue="false") Boolean changes,
                                @RequestParam(required=false, defaultValue="false") Boolean offers,
                                @RequestParam(required=false, defaultValue="") String pushNotifications) {

        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setPropertyPostCode(propertyPostCode);
        approvalRequest.setPropertyValue(propertyValue);
        approvalRequest.setAmountToBorrow(amountToBorrow);
        approvalRequest.setAbout(about);
        approvalRequest.setFirstName(firstName);
        approvalRequest.setLastName(lastName);
        approvalRequest.setNationalInsuranceNumber(nationalInsuranceNumber);
        approvalRequest.setCountry(country);
        approvalRequest.setStreetAddress(streetAddress);
        approvalRequest.setCity(city);
        approvalRequest.setPostCode(postCode);
        approvalRequest.setApprovalNotifications(approval);
        approvalRequest.setChangeNotifications(changes);
        approvalRequest.setOfferNotifications(offers);
        approvalRequest.setPushNotifications(pushNotifications);

        // Send the approval request to the backend for processing
        // and resume serving up great Web content to our customers
        // on the front end!
        this.logger.error(nationalInsuranceNumber);
        this.workflow.submitForApproval(approvalRequest);

        return "completed";
    }
}
