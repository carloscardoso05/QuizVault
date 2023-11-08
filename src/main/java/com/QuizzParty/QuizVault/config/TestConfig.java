package com.QuizzParty.QuizVault.config;

import com.QuizzParty.QuizVault.entities.Quiz;
import com.QuizzParty.QuizVault.entities.QuizQuestion;
import com.QuizzParty.QuizVault.entities.User;
import com.QuizzParty.QuizVault.entities.enums.Difficulty;
import com.QuizzParty.QuizVault.repositories.QuizQuestionRepository;
import com.QuizzParty.QuizVault.repositories.QuizRepository;
import com.QuizzParty.QuizVault.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    public TestConfig(UserRepository userRepository, QuizRepository quizRepository, QuizQuestionRepository quizQuestionRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.quizQuestionRepository = quizQuestionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Quiz q1 = new Quiz(null, "Quiz de datas", "Um quiz de datas comemorativas", u1);
        Quiz q2 = new Quiz(null, "Quiz de matemática", "Um quiz de perguntas sobre matemática", u2);
        Quiz q3 = new Quiz(null, "Quiz de geografia", "Um quiz de perguntas sobre geografia", u2);

        quizRepository.saveAll(Arrays.asList(q1, q2, q3));

        QuizQuestion qq1 = new QuizQuestion(null, "Quando é o natal?", "25 de Dezembro", Difficulty.EASY, q1);
        qq1.getWrongAnswers().add("7 de Setembro");
        qq1.getWrongAnswers().add("28 de Outubro");
        qq1.getWrongAnswers().add("16 de Maio");

        QuizQuestion qq2 = new QuizQuestion(null, "Qual é a data da Páscoa?", "Varia dependendo do ano", Difficulty.MEDIUM, q1);
        qq2.getWrongAnswers().add("25 de Dezembro");
        qq2.getWrongAnswers().add("1 de Janeiro");
        qq2.getWrongAnswers().add("4 de Julho");

        QuizQuestion qq3 = new QuizQuestion(null, "Qual é a raiz quadrada de 16?", "4", Difficulty.EASY, q2);
        qq3.getWrongAnswers().add("8");
        qq3.getWrongAnswers().add("2");
        qq3.getWrongAnswers().add("5");

        QuizQuestion qq4 = new QuizQuestion(null, "Qual é o resultado de 3 x 7?", "21", Difficulty.MEDIUM, q2);
        qq4.getWrongAnswers().add("10");
        qq4.getWrongAnswers().add("14");
        qq4.getWrongAnswers().add("28");

        QuizQuestion qq5 = new QuizQuestion(null, "Qual é a capital da França?", "Paris", Difficulty.EASY, q3);
        qq5.getWrongAnswers().add("Roma");
        qq5.getWrongAnswers().add("Londres");
        qq5.getWrongAnswers().add("Madrid");

        quizQuestionRepository.saveAll(Arrays.asList(qq1, qq2, qq3, qq4, qq5));

    }
}
