package com.QuizzParty.QuizVault.config;

import com.QuizzParty.QuizVault.entities.Answer;
import com.QuizzParty.QuizVault.entities.Quiz;
import com.QuizzParty.QuizVault.entities.QuizQuestion;
import com.QuizzParty.QuizVault.entities.User;
import com.QuizzParty.QuizVault.entities.enums.Difficulty;
import com.QuizzParty.QuizVault.repositories.AnswerRepository;
import com.QuizzParty.QuizVault.repositories.QuizQuestionRepository;
import com.QuizzParty.QuizVault.repositories.QuizRepository;
import com.QuizzParty.QuizVault.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final AnswerRepository answerRepository;

    public TestConfig(UserRepository userRepository, QuizRepository quizRepository, QuizQuestionRepository quizQuestionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.quizQuestionRepository = quizQuestionRepository;
        this.answerRepository = answerRepository;
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

        QuizQuestion qq1 = new QuizQuestion(null, "Quando é o natal?", Difficulty.EASY, q1);
        QuizQuestion qq2 = new QuizQuestion(null, "Qual é a data da Páscoa?", Difficulty.MEDIUM, q1);
        QuizQuestion qq3 = new QuizQuestion(null, "Qual é a raiz quadrada de 16?", Difficulty.EASY, q2);
        QuizQuestion qq4 = new QuizQuestion(null, "Qual é o resultado de 3 x 7?", Difficulty.MEDIUM, q2);
        QuizQuestion qq5 = new QuizQuestion(null, "Qual é a capital da França?", Difficulty.EASY, q3);

        quizQuestionRepository.saveAll(Arrays.asList(qq1, qq2, qq3, qq4, qq5));

        Answer a0 = new Answer(null, "25 de Dezembro", true, qq1);
        Answer a1 = new Answer(null, "7 de Setembro", false, qq1);
        Answer a2 = new Answer(null, "28 de Outubro", false, qq1);
        Answer a3 = new Answer(null, "16 de Maio", false, qq1);
        qq1.getAnswers().addAll(Arrays.asList(a0, a1, a2, a3));

        Answer a4 = new Answer(null, "25 de Dezembro", false, qq2);
        Answer a5 = new Answer(null, "1 de Janeiro", false, qq2);
        Answer a6 = new Answer(null, "4 de Julho", false, qq2);
        Answer a7 = new Answer(null, "Depende pois muda todo ano", true, qq2);
        qq2.getAnswers().addAll(Arrays.asList(a4, a5, a6, a7));

        Answer a8 = new Answer(null, "2", false, qq3);
        Answer a9 = new Answer(null, "5", false, qq3);
        Answer a10 = new Answer(null, "8", false, qq3);
        Answer a11 = new Answer(null, "4", true, qq3);
        qq3.getAnswers().addAll(Arrays.asList(a8, a9, a10, a11));

        Answer a12 = new Answer(null, "28", false, qq4);
        Answer a13 = new Answer(null, "10", false, qq4);
        Answer a14 = new Answer(null, "14", false, qq4);
        Answer a15 = new Answer(null, "21", true, qq4);
        qq4.getAnswers().addAll(Arrays.asList(a12, a13, a14, a15));

        Answer a16 = new Answer(null, "Londres", false, qq5);
        Answer a17 = new Answer(null, "Madrid", false, qq5);
        Answer a18 = new Answer(null, "Roma", false, qq5);
        Answer a19 = new Answer(null, "Paris", true, qq5);
        qq5.getAnswers().addAll(Arrays.asList(a16, a17, a18, a19));


        answerRepository.saveAll(Arrays.asList(a0,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19));

    }
}
