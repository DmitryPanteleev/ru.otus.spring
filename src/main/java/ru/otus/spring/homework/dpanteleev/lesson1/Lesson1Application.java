package ru.otus.spring.homework.dpanteleev.lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.homework.dpanteleev.lesson1.service.QuestionService;

public class Lesson1Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        for (int i = 0; i < service.size(); i++) {
            System.out.println(service.getByNumber(i).getQuestion() + service.getByNumber(i).getAnswers().toString());
        }
    }

}
