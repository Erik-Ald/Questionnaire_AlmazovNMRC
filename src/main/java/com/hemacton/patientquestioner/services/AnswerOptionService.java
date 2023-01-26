package com.hemacton.patientquestioner.services;

import com.hemacton.patientquestioner.models.AnswerOption;
import com.hemacton.patientquestioner.repositories.AnswerOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerOptionService {

    private final AnswerOptionRepository answerOptionRepository;

    public List<AnswerOption> getAnswersOptionsForPage(Short pageNum){
        return answerOptionRepository.getAllByQuestionPageNumOrderByAnswerNum(pageNum);
    }


}
