package com.hemacton.patientquestioner.controllers;

import com.hemacton.patientquestioner.models.Patient;
import com.hemacton.patientquestioner.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/newPatient")
    public String getPatientCreationPage(@RequestParam String questionnaireType, Model model){
        model.addAttribute("type", questionnaireType);
        return "patient_creation_page";
    }

    @PostMapping("/newPatient")
    public String addNewPatient(Patient patient,
                                @RequestParam String questionnaireType,
                                RedirectAttributes redirectAttributes) {
        var id = patientService.addPatient(patient);
        redirectAttributes.addAttribute("pageNum",1);
        return "redirect:/questionnaire/" + questionnaireType + "/" + id;
    }
}
