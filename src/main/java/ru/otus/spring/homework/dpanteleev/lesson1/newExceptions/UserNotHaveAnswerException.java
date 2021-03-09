package ru.otus.spring.homework.dpanteleev.lesson1.newExceptions;

public class UserNotHaveAnswerException extends NullPointerException {

    public UserNotHaveAnswerException(String s) {
        super(s);
    }
}
