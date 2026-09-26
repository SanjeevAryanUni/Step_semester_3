package week8.class_problems;

import java.util.*;

public class OnlineExaminationSystem {
    public static abstract class Question {
        protected String questionText;
        protected int points;

        public Question(String questionText, int points) {
            this.questionText = questionText;
            this.points = points;
        }

        public int getPoints() { return points; }
        public abstract boolean isCorrect(String answer);
    }

    public static class MultipleChoiceQuestion extends Question {
        private String correctOption;

        public MultipleChoiceQuestion(String questionText, int points, String correctOption) {
            super(questionText, points);
            this.correctOption = correctOption;
        }

        @Override
        public boolean isCorrect(String answer) {
            return correctOption.equalsIgnoreCase(answer.trim());
        }
    }

    public static class TrueFalseQuestion extends Question {
        private boolean correctAnswer;

        public TrueFalseQuestion(String questionText, int points, boolean correctAnswer) {
            super(questionText, points);
            this.correctAnswer = correctAnswer;
        }

        @Override
        public boolean isCorrect(String answer) {
            return Boolean.parseBoolean(answer.trim()) == correctAnswer;
        }
    }

    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Examination {
        private String name;
        private List<Question> questions;

        public Examination(String name, List<Question> questions) {
            this.name = name;
            this.questions = questions;
        }

        public String getName() { return name; }
        public List<Question> getQuestions() { return questions; }
    }

    public enum AttemptStatus {
        IN_PROGRESS, SUBMITTED
    }

    public static class Attempt {
        private Student student;
        private Examination examination;
        private Map<Integer, String> answers = new HashMap<>();
        private AttemptStatus status;

        public Attempt(Student student, Examination examination) {
            this.student = student;
            this.examination = examination;
            this.status = AttemptStatus.IN_PROGRESS;
            System.out.println(examination.getName() + " started by " + student.getName() + ".");
        }

        public void recordAnswer(int questionIndex, String answer) {
            if (status == AttemptStatus.SUBMITTED) {
                System.out.println("Cannot change answers for a submitted examination.");
                return;
            }
            answers.put(questionIndex, answer);
            System.out.println("Answer recorded for Question " + questionIndex + ".");
        }

        public void submit() {
            if (status == AttemptStatus.SUBMITTED) return;
            this.status = AttemptStatus.SUBMITTED;

            int totalScore = 0;
            int maxScore = 0;
            StringBuilder resultSummary = new StringBuilder();

            List<Question> questions = examination.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                maxScore += q.getPoints();
                String ans = answers.get(i + 1);
                boolean correct = (ans != null && q.isCorrect(ans));
                int score = correct ? q.getPoints() : 0;
                totalScore += score;

                if (i > 0) resultSummary.append(", ");
                resultSummary.append("Question ").append(i + 1).append(": ")
                        .append(correct ? "Correct (" + score + " points)" : "Incorrect (0 points)");
            }

            System.out.println(examination.getName() + " submitted by " + student.getName() +
                    ". Result: " + resultSummary + ". Total score: " + totalScore + "/" + maxScore + ".");
        }
    }

    public static void main(String[] args) {
        Question q1 = new MultipleChoiceQuestion("What is Java?", 5, "C");
        Question q2 = new TrueFalseQuestion("Is Java purely OOP?", 5, false);

        Examination examA = new Examination("Exam A", Arrays.asList(q1, q2));
        Student s1 = new Student("Student 1");

        Attempt attempt = new Attempt(s1, examA);
        attempt.recordAnswer(1, "C");
        attempt.recordAnswer(2, "True");
        attempt.submit();

        attempt.recordAnswer(1, "A");
    }
}
