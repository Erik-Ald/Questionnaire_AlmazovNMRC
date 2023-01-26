package com.hemacton.patientquestioner.dto;

import com.hemacton.patientquestioner.models.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswersFromPage {

    private List<Answer> listAnswer;

}
