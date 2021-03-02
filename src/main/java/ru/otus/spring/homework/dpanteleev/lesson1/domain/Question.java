package ru.otus.spring.homework.dpanteleev.lesson1.domain;

import java.util.List;
//import ru.otus.spring.homework.dpanteleev.lesson1.domain.Answer;

public class Question {
    /**
     * Текст вопроса
     */
    private final String question;

    /**
     * Список возможных ответов
     */
    private final List<Answer> answers;

    /**
     * Текст ответа пользователя
     */
    private Answer userAnswer;

    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    /**
     * Возвращает список ответов если они доступны
     *
     * @return List<Answer></>
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Возвращает ответ пользователя
     *
     * @return Answer
     */
    public Answer getUserAnswer() {
        return userAnswer;
    }

    /**
     * Устанавливает ответ пользователя
     *
     * @param userAnswer ответ пользователя, сохраняемый на заданный вопрос
     */
    public void setUserAnswer(Answer userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * @return Текст вопроса
     */
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return question;
    }
}
