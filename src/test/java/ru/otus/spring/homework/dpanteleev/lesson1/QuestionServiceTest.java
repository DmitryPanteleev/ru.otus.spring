package ru.otus.spring.homework.dpanteleev.lesson1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDao;
import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDaoSimple;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class QuestionService")
@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    QuestionDao dao;

    @Value("${path.question}")
    String pathToFile ;

//    @DisplayName("Проверяем работу конструктора")
//    @Test
//    void shouldHaveCorrectConstructor() {
//        QuestionServiceImpl service = new QuestionServiceImpl(dao);
//        assertEquals(0, service.size());
//        assertNull(service.getByNumber(0));
//    }

    QuestionDaoSimple daoSimple = new QuestionDaoSimple("src/test/resources/testQuestions.csv");
    private List<Question> questionList = new ArrayList<Question>();

    @DisplayName("количество считанных строк")
    @Test
    void tesCountStringQuestionDao() {
        assertEquals(8, daoSimple.size());
    }

    @DisplayName("возвращает лист вопросов")
    @Test
    void testQuestionDao() {
        assertEquals(questionList.getClass(), daoSimple.getQustionsList().getClass());
    }

}
