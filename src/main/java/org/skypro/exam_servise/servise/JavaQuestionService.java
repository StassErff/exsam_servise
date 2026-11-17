package org.skypro.exam_servise.servise;

import org.skypro.exam_servise.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaQuestionService implements QuestionService {
    private Set<Question> questionSet = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(Question quest) {
        questionSet.add(quest);
        return quest;
    }

    @Override
    public Question add(String quest, String answer) {
        Question question = new Question(quest, answer);
        questionSet.add(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questionSet);
    }

    @Override
    public Question remove(Question quest) {
        questionSet.remove(quest);
        return quest;
    }

    @Override
    public Question randomQuest() {
        if (questionSet.isEmpty()) return null;
        int randomIndex = random.nextInt(questionSet.size());
        return questionSet.stream().skip(randomIndex).findFirst().orElseThrow();
    }
}
