package com.hemacton.patientquestioner.repositories;

import com.hemacton.patientquestioner.models.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption,Long> {

    List<AnswerOption> getAllByQuestionPageNumOrderByAnswerNum(Short pageNum);
}
