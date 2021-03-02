package ru.otus.spring.homework.dpanteleev.lesson1.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Answer;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoSimple implements QuestionDao {

    /**
     * Список вопросов с возможными вариантами ответов
     */
    private List<Question> questionList = new ArrayList<>();

    public QuestionDaoSimple(String path) {
        try {
            //Читаем файл с вопросами
            Reader in = new FileReader(Paths.get(path).toAbsolutePath().toString());
            //Парсим вопросы
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            //Получаю лист вопросов с возможными вариантами ответов
            for (CSVRecord record : records) {
                // Проверяем на наличие вопроса
                if (record.get("question").isEmpty() || record.get("question").isBlank()) return;
                //Возможные варианты ответов
                List<Answer> answers = new ArrayList<>();
                // Если запись содержит ответы добавляем их
                if (!record.get("answer").isEmpty()) {
                    // Первой записью идёт вопрос остальными
                    for (int i = 1; i < record.size(); i++) {
                        answers.add(new Answer(record.get(i)));
                    }
                }
                // Если запись содержит вопрос добавляем его
                questionList.add(new Question(
                                record.get("question"),
                                answers
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Question findQuestion(int number) throws ArrayIndexOutOfBoundsException {
        if (number >= 0 && number < questionList.size()) {
            return questionList.get(number);
        } else throw new ArrayIndexOutOfBoundsException("Нет такого номера вопроса");
    }

    @Override
    public long size() {
        return questionList.size();
    }
}
