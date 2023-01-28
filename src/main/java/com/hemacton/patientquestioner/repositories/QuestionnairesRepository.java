package com.hemacton.patientquestioner.repositories;

import com.hemacton.patientquestioner.models.Questionnaires;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionnairesRepository extends JpaRepository<Questionnaires,Long> {

    Optional<Questionnaires> findByQuestionerName(String name);

}
