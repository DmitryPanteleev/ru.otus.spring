package ru.otus.spring.homework.dpanteleev.lesson1.dao;

import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getQustionsList();

    long size();

}
