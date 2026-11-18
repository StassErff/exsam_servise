package org.skypro.exam_servise.model.quest;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question quest = (Question) obj;
        return Objects.equals(question, quest.question) && Objects.equals(answer, quest.answer);
    }
}
