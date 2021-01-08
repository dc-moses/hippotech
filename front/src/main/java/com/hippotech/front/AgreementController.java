package com.hippotech.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgreementController {

    @GetMapping("/agreement")
    public String getAgreement(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "agreement";
    }


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
        return "completed";
    }
}
