package org.skypro.exam_servise.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_servise.model.quest.Question;
import org.skypro.exam_servise.model.servise.ExaminerServiceImpl;
import org.skypro.exam_servise.model.servise.QuestionService;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void WhenRequestingAListOfASpecifiedNumberOfQuestions_ItReturnsAListOfTheRequiredQuantityQuestions() {
        Question q1 = new Question("А почему?", "А патамучта!");
        Question q2 = new Question("Какого?", "Черта или числа?");
        Question q3 = new Question("Любишь плюшки.", "Это был не вопрос");
        Mockito.when(questionService.randomQuest()).thenReturn(q1, q2, q3);
        Mockito.when(questionService.getAll()).thenReturn(Set.of(q1, q2, q3));
        Collection<Question> questList = examinerService.getQuestions(3);
        Assertions.assertEquals(Set.of(q1, q2, q3), questList);
    }

    @Test
    public void WhenRequestingAListOfASpecificNumberOfQuestions_ItThrowsAnError() {
        Assertions.assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(5));
    }
}
