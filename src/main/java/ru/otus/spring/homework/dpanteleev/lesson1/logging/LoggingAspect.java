package ru.otus.spring.homework.dpanteleev.lesson1.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //Пока делаю без логгера, как понимаю в буте будет свой логгер и нет смысла подключать его сейчас
    @Around("execution(* ru.otus.spring.homework.dpanteleev.lesson1.dao.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Класс: " + joinPoint.getTarget().getClass().getSimpleName()
                + " Метод: " + joinPoint.getSignature().getName()
                + " Начал работу");
        long start = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        System.out.println("Класс: " + joinPoint.getTarget().getClass().getSimpleName() + " Окончил работу за " +
                (System.currentTimeMillis() - start) + " миллисекунд");
        return res;
    }
}
