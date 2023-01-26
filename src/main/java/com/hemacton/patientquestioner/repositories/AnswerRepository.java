package com.hemacton.patientquestioner.repositories;

import com.hemacton.patientquestioner.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
