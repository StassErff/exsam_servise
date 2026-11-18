package org.skypro.exam_servise.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.exam_servise.model.quest.Question;
import org.skypro.exam_servise.model.servise.JavaQuestionService;

import java.util.Collection;
import java.util.Set;

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
        Question question = new Question(null, null);
        Question actual = javaQuestionService.add(question);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingAnEmptyObject_TheObjectIsNotAdded() {
        Question question = null;
        Question actual = javaQuestionService.add(question);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingAnObject_IfSpacesAreUsedInsteadOfStrings_TheObjectIsNotAdded() {
        Question question = new Question(" ", " ");
        Question actual = javaQuestionService.add(question);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingViaLine_AnObjectIsAdded() {
        Question question = new Question("А почему?", "А патамучта!");
        Question actual = javaQuestionService.add("А почему?", "А патамучта!");
        Assertions.assertEquals(question, actual);
        Assertions.assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingViaLineContainingSpaces_TheObjectIsNotAdded() {
        Question question = new Question(" ", " ");
        Question actual = javaQuestionService.add(" ", " ");
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenAddingViaAnEmptyLine_TheObjectIsNotAdded() {
        Question question = new Question(null, null);
        Question actual = javaQuestionService.add(null, null);
        Assertions.assertNull(actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void ACompletedListIsBeingPrinted() {
        Question question = new Question("А почему?", "А патамучта!");
        Question question2 = new Question("Какого?", "Черта или числа?");
        javaQuestionService.add(question);
        javaQuestionService.add(question2);
        Collection<Question> actual = javaQuestionService.getAll();
        Assertions.assertEquals(Set.of(question, question2), actual);
    }

    @Test
    public void AnEmptyListIsPrinted() {
        Collection<Question> actual = javaQuestionService.getAll();
        Assertions.assertEquals(Set.of(), actual);
    }

    @Test
    public void WhenThePassedObjectIsDeleted_TheObjectIsRemoved() {
        Question question = new Question("А почему?", "А патамучта!");
        javaQuestionService.add(question);
        Question actual = javaQuestionService.remove(question);
        Assertions.assertEquals(question, actual);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void WhenRandomQuestionIsRequested_ItProvidesRandomQuestion() {
        Question question = new Question("А почему?", "А патамучта!");
        Question question2 = new Question("Какого?", "Черта или числа?");
        javaQuestionService.add(question);
        javaQuestionService.add(question2);
        Question actual = javaQuestionService.randomQuest();
        Assertions.assertTrue(javaQuestionService.getAll().contains(actual));
    }

    @Test
    public void WhenRequestingARandomQuestionFromAnEmptyList_NullIsReturned() {
        Question actual = javaQuestionService.randomQuest();
        Assertions.assertNull(actual);
    }
}
