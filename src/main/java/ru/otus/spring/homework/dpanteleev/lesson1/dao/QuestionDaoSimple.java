package ru.otus.spring.homework.dpanteleev.lesson1.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Answer;
import ru.otus.spring.homework.dpanteleev.lesson1.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Repository("questionDaoSimple")
public class QuestionDaoSimple implements QuestionDao {

    private static final String WRONGANSWER = "wrong_answer";
    private static final String CORRECTANSWER = "correct_answer";
    private static final String QUESTION = "question";

    /**
     * Список вопросов с возможными вариантами ответов
     */
    private List<Question> questionList = new ArrayList<>();

    private String pathToFile;

    public QuestionDaoSimple(@Value("${path.question}") String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Загружает из CSV вопросы
     * @param pathToCsvFile
     */
    private void loadCSVFile(String pathToCsvFile) {
        try {
            //Читаем файл с вопросами
            Reader in = new FileReader(Paths.get(pathToCsvFile).toAbsolutePath().toString());
            //Парсим вопросы
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            //Получаю лист вопросов с возможными вариантами ответов
            for (CSVRecord record : records) {
                Question q;
                if ((q = csvToQuestion(record)) != null) {
                    questionList.add(q);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Принимает CSV строку и возвращает вопрос с возможными вариантами ответа
     * @param record запись в CSV файле
     * @return Question
     */
    private Question csvToQuestion(CSVRecord record) {
        // Проверяем на наличие вопроса
        if (record.get(QUESTION).isEmpty() || record.get(QUESTION).isBlank()) return null;
        //Возможные варианты ложных ответов
        List<Answer> wrongAnswers = new ArrayList<>();
        // Возможные варианты правильных ответов
        List<Answer> correctAnswers = new ArrayList<>();
        // Если запись содержит ответы добавляем их
        for (int i = 0; i < record.size(); i++) {
            if (record.get(i).isEmpty()) continue;
            if (record.getParser().getHeaderNames().get(i).equals(CORRECTANSWER)) {
                correctAnswers.add(new Answer(record.get(i)));
            } else if (record.getParser().getHeaderNames().get(i).equals(WRONGANSWER)) {
                wrongAnswers.add(new Answer(record.get(i)));
            }
        }
        // Если запись содержит вопрос добавляем его
        return new Question(
                record.get(QUESTION),
                wrongAnswers,
                correctAnswers);
    }

    @Override
    public List<Question> getQustionsList() {
        if (questionList.isEmpty()) {
            loadCSVFile(pathToFile);
        }
        return questionList;
    }

    @Override
    public long size() {
        if (questionList.isEmpty()) {
            loadCSVFile(pathToFile);
        }
        return questionList.size();
    }

}
