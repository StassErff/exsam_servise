package org.skypro.exam_servise.model.controller;

import org.skypro.exam_servise.model.quest.Question;
import org.skypro.exam_servise.model.servise.JavaQuestionService;
import org.skypro.exam_servise.model.servise.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                      @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        Question quest = new Question(question, answer);
        return questionService.remove(quest);
    }
}
