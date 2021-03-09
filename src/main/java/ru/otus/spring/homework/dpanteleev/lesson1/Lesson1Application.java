package ru.otus.spring.homework.dpanteleev.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Answer;
import ru.otus.spring.homework.dpanteleev.lesson1.service.QuestionService;

import java.util.Scanner;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Lesson1Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Lesson1Application.class);

        QuestionService service = context.getBean(QuestionService.class);

        for (int i = 0; i < service.size(); i++) {
            System.out.println("Answer the questions");
            // Задать вопрос
            System.out.println(service.getAnswerTextByNumber(i) + " " + service.randomAnswerList(i));
            // Получить ответ
            Scanner scanner = new Scanner(System.in);
            //Сохранить ответ
            service.setAnswer(new Answer(scanner.nextLine()), i);
        }
        service.printResult();
        if (service.isOffset()) {
            System.out.println("Зачёт :)");
        } else {
            System.out.println("Не зачёт :(");
        }

    }

}
