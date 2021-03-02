package ru.otus.spring.homework.dpanteleev.lesson1.dao;

import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

public interface QuestionDao {

    Question findQuestion(int number);

    long size();

}
