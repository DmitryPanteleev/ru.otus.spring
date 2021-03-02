package ru.otus.spring.homework.dpanteleev.lesson1.service;

import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

public interface QuestionService {
    /**
     * Находим вопрос по его номеру
     * Если вопрос не найден бросает исключение
     *
     * @param number номер вопроса в списке
     * @return Question Вопрос из списка под заданным номером
     */
    Question getByNumber(int number);

    /**
     * Возращает количество вопросов в списке
     *
     * @return long
     */
    long size();
}
