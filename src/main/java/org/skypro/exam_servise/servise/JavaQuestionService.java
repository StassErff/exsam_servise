package org.skypro.exam_servise.servise;

import org.skypro.exam_servise.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavaQuestionService implements QuestionService {
    private Map<Question> listQuest = new ArrayList<>();

    public JavaQuestionService(List<Question> listQuest) {
        this.listQuest = listQuest;
    }

    public List<Question> getListQuest() {
        return listQuest;
    }
}
