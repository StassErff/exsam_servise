package org.skypro.exam_servise.servise;

import org.skypro.exam_servise.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question quest);
    Question add(String quest, String answer);
    Question remove(Question quest);
    Collection<Question> getAll();
    Question randomQuest();
}
