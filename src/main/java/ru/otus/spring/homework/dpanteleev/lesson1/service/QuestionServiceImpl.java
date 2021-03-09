package ru.otus.spring.homework.dpanteleev.lesson1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.dpanteleev.lesson1.dao.QuestionDao;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Answer;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    @Value("${count.right.answer}")
    private int offset;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public String getAnswerTextByNumber(int number) throws ArrayIndexOutOfBoundsException {
        if (number < 0 || number > dao.size()) {
            throw new ArrayIndexOutOfBoundsException("Нет такого номера");
        }
        return dao.getQustionsList().get(number).getQuestion();
    }

    @Override
    public void setAnswer(Answer answer, int number) {
        dao.getQustionsList().get(number).setUserAnswer(answer);
        System.out.println("Записан ответ: " + answer.toString());
    }

    /**
     * Печатает результат
     */
    public void printResult() {
        for (Question q :
                dao.getQustionsList()) {
            try {
                System.out.println("Вопрос: " + q.getQuestion());
                System.out.println("Ответ: " + q.getUserAnswer());
                if (!q.getCorrectAnswers().isEmpty()) {
                    if (q.isRightAnswer()) {
                        System.out.println("Верный ответ");
                    } else {
                        System.out.println("Ложный ответ");
                    }
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Answer> randomAnswerList(int number) {
        List<Answer> list = new ArrayList<>();
        list.addAll(dao.getQustionsList().get(number).getCorrectAnswers());
        list.addAll(dao.getQustionsList().get(number).getWrongAnswers());
        return list;
    }

    /**
     * зачёт
     *
     * @return true если зачёт
     */
    public boolean isOffset() {
        int count = 0;
        for (Question q :
                dao.getQustionsList()) {
            if (q.isHaveAnswer() && !q.getCorrectAnswers().isEmpty() && q.isRightAnswer()) {
                count++;
            }
        }
        return offset <= count;
    }

    public long size() {
        return dao.size();
    }
}
