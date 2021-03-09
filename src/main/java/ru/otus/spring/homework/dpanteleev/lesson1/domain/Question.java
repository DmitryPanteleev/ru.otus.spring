package ru.otus.spring.homework.dpanteleev.lesson1.domain;

import ru.otus.spring.homework.dpanteleev.lesson1.newExceptions.UserNotHaveAnswerException;

import java.util.List;


public class Question {
    /**
     * Текст вопроса
     */
    private final String question;

    /**
     * Список неправильных ответов
     */
    private final List<Answer> wrongAnswers;
    /**
     * Список правильных ответов
     */
    private final List<Answer> correctAnswers;

    /**
     * Текст ответа пользователя
     */
    private Answer userAnswer;

    public Question(String question, List<Answer> wrongAnswers, List<Answer> correctAnswers) {
        this.question = question;
        this.wrongAnswers = wrongAnswers;
        this.correctAnswers = correctAnswers;
    }

    /**
     * Возвращает список ложных ответов если они доступны
     *
     * @return List<Answer></>
     */
    public List<Answer> getWrongAnswers() {
        return wrongAnswers;
    }

    /**
     * Возвращает список правильных ответов если они доступны
     *
     * @return List<Answer></>
     */
    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * Возвращает ответ пользователя если он есть или кидает эксепшен если его нет
     *
     * @return Answer
     * @Exception UserNotHaveAnswerException
     */
    public Answer getUserAnswer() throws UserNotHaveAnswerException {
        if (userAnswer == null) throw new UserNotHaveAnswerException("Юзер не дал ответ");
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

    public boolean isHaveAnswer() {
        return userAnswer != null;
    }

    /**
     * Дан ли правильный ответ
     * @return true если ответ дан верный
     * @throws UserNotHaveAnswerException если нет ответа
     */
    public boolean isRightAnswer() throws UserNotHaveAnswerException{
        if (isHaveAnswer() && !getCorrectAnswers().isEmpty()) {
            for (Answer rightAnswer :
                    getCorrectAnswers()) {
                return getUserAnswer().getAnswer().equals(rightAnswer.getAnswer());
            }
        }
        throw new UserNotHaveAnswerException("Нет ответа пользователя или не заданы правильные ответы");
    }

    @Override
    public String toString() {
        return question;
    }
}
