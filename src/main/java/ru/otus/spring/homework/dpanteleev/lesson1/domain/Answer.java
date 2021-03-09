package ru.otus.spring.homework.dpanteleev.lesson1.domain;

public class Answer {
    /**
     * Текст ответа
     */
    private final String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return answer1.getAnswer().equals(this.getAnswer());
    }

}
