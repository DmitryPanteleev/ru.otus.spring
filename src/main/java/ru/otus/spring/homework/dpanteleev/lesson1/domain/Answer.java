package ru.otus.spring.homework.dpanteleev.lesson1.domain;

public class Answer {
    /**
     * Текст ответа
     */
    private final String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
