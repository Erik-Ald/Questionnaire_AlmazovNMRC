package com.hemacton.patientquestioner.repositories;

import com.hemacton.patientquestioner.models.Questionnaires;
import com.hemacton.patientquestioner.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository <Question,Long> {

    List<Question> getQuestionsByQuestionnaireAndPageNumOrderByQuestionNum(Questionnaires questionnaires,
                                                                           Short pageNum);
    Question getQuestionsById(Long id);
}
