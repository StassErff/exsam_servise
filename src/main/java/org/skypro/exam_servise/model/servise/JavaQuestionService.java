package org.skypro.exam_servise.model.servise;

import org.skypro.exam_servise.model.quest.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questionSet = new HashSet<>();
    private final Random random = new Random();

    private boolean inValid(Question quest) {
        if (quest == null || quest.getQuestion() == null ||
                quest.getAnswer() == null ||
                quest.getQuestion().isBlank() ||
                quest.getAnswer().isBlank()) return true;
        else return false;
    }

    @Override
    public Question add(Question quest) {
        if (inValid(quest)) return null;
        questionSet.add(quest);
        return quest;
    }

    @Override
    public Question add(String quest, String answer) {
        Question question = new Question(quest, answer);
        if (inValid(question)) return null;
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
