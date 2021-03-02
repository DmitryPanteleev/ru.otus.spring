package ru.otus.spring.homework.dpanteleev.lesson1.service;

import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDao;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public Question getByNumber(int number) throws ArrayIndexOutOfBoundsException {
        return dao.findQuestion(number);
    }

    public long size() {
        return dao.size();
    }
}
