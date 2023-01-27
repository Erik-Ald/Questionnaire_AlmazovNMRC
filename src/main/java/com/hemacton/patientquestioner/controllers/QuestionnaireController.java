package com.hemacton.patientquestioner.controllers;

import com.hemacton.patientquestioner.dto.AnswersFromPage;
import com.hemacton.patientquestioner.models.Answer;
import com.hemacton.patientquestioner.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnairesService questionnairesService;

    private final QuestionsService questionsService;
    private final AnswerOptionService answerOptionService;
    private final AnswerService answerService;
    private final PythonService pythonService;

    @GetMapping("/migraine")
    public String newMigraineQuestionnaire(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("questionnaireType","Migraine");
        return "redirect:/newPatient";
    }

    @GetMapping("/questionnaire/{type}/{patient-id}")
    public String nextPage(@PathVariable("patient-id") String id,
                           @PathVariable("type") String type,
                           @RequestParam(name = "pageNum") String pageNum,
                           Model model){

        if (Integer.parseInt(pageNum) >= questionnairesService.getQuestioner(type).getPages()) {

            String pythonReturn = pythonService.sentToPython(type,id);
            model.addAttribute("python",pythonReturn);

            return "completed";

        } else {

            short pageNumShort = Short.parseShort(pageNum);

            System.out.println(pageNumShort);

            model.addAttribute("questions",
                    questionsService.getQuestions(type,pageNumShort));

            model.addAttribute("answerOptions",
                    answerOptionService.getAnswersOptionsForPage(pageNumShort));

            model.addAttribute("pageNum", pageNum);

            return "questionnaire_page";
        }

    }

    @PostMapping("/questionnaire/{type}/{patient-id}")
    public String getAnswers(AnswersFromPage answerFormPage,
                             @PathVariable("patient-id") String patientId,
                             @PathVariable("type") String type,
                             @RequestParam(name = "pageNum") String pageNum,
                             RedirectAttributes redirectAttributes){

        Short num = Short.parseShort(pageNum);
        Long patientIdLong = Long.parseLong(patientId);

        for (Answer answer : answerFormPage.getListAnswer()){
            if (answer.getAnswer() != null) {
                answerService.addAnswer(answer, patientIdLong);
            }
        }

        ++num;
        redirectAttributes.addAttribute("pageNum", num);
        return "redirect:/questionnaire/" + type + "/" + patientId;
    }
}
