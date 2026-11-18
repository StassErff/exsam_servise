package org.skypro.exam_servise.model.servise;

import org.skypro.exam_servise.model.quest.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
