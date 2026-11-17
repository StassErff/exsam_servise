package org.skypro.exam_servise.model.servise;

import org.skypro.exam_servise.model.quest.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount || amount <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Столько вопросов нет");
        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() < amount) {
            questions.add(questionService.randomQuest());
        }
        return questions;
    }
}
