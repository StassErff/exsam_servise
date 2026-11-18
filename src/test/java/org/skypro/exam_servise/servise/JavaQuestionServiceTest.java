package org.skypro.exam_servise.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.exam_servise.model.quest.Question;
import org.skypro.exam_servise.model.servise.JavaQuestionService;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setJavaQuestionService() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void WhenQuestionObjectIsAdded_TheQuestionIsAddedToList() {
        Question question = new Question("А почему?", "А патамучта!");
        Question actual = javaQuestionService.add(question);
        Assertions.assertEquals(question, actual);
        Assertions.assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingEmptyRowsToAnObject_TheObjectIsNotAdded() {
        Question question = new Question(" ", " ");
        Question actual = javaQuestionService.add(question);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingAnEmptyObject_TheObjectIsNotAdded() {
        Question question = new Question(null, null);
        Question actual = javaQuestionService.add(question);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }
}
