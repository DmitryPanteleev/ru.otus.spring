package ru.otus.spring.homework.dpanteleev.lesson1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDao;
import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDaoSimple;
import ru.otus.spring.homework.dpanteleev.lesson1.service.QuestionServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class QuestionService")
@ExtendWith(MockitoExtension.class)
class QuestionService {

    @Mock
    QuestionDao dao;

    @DisplayName("Проверяем работу конструктора")
    @Test
    void shouldHaveCorrectConstructor() {
        QuestionServiceImpl service = new QuestionServiceImpl(dao);
        assertEquals(0, service.size());
        assertNull(service.getByNumber(0));
    }


    // todo не работает...
    @DisplayName("Проверяем работу вызова исключения")
    @Test
    void shouldHaveCorrectThrowOBExc() {
        QuestionDao dao = new QuestionDaoSimple("");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> dao.findQuestion(-10));
    }

}
