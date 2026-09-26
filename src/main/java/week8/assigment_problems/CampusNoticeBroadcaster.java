package week8.assigment_problems;

import java.util.*;

public class CampusNoticeBroadcaster {
    public interface NotificationChannel {
        void send(Student student, String message);
    }

    public static class EmailChannel implements NotificationChannel {
        @Override
        public void send(Student student, String message) {
            System.out.println("[Email → " + student.getName() + "] " + message + ".");
        }
    }

    public static class SmsChannel implements NotificationChannel {
        @Override
        public void send(Student student, String message) {
            System.out.println("[SMS → " + student.getName() + "] " + message + ".");
        }
    }

    public static class AppChannel implements NotificationChannel {
        @Override
        public void send(Student student, String message) {
            System.out.println("[App → " + student.getName() + "] " + message + ".");
        }
    }

    public static class Student {
        private String name;
        private String department;
        private List<NotificationChannel> channels;

        public Student(String name, String department, List<NotificationChannel> channels) {
            this.name = name;
            this.department = department;
            this.channels = channels != null ? channels : new ArrayList<>();
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public List<NotificationChannel> getChannels() { return channels; }
    }

    public static class Notice {
        private String title;
        private List<String> targetDepartments;

        public Notice(String title, List<String> targetDepartments) {
            this.title = title;
            this.targetDepartments = targetDepartments;
        }

        public String getTitle() { return title; }
        public List<String> getTargetDepartments() { return targetDepartments; }

        public boolean isValid() {
            return title != null && !title.trim().isEmpty() &&
                   targetDepartments != null && !targetDepartments.isEmpty();
        }
    }

    public static class NoticeBoard {
        private List<Student> students = new ArrayList<>();

        public void registerStudent(Student s) {
            students.add(s);
        }

        public boolean postNotice(Notice notice) {
            if (!notice.isValid()) {
                System.out.println("Cannot post notice: At least one target department is required.");
                return false;
            }
            System.out.println("Notice '" + notice.getTitle() + "' posted to " +
                    String.join(", ", notice.getTargetDepartments()) + ".");
            for (Student s : students) {
                if (notice.getTargetDepartments().contains(s.getDepartment())) {
                    for (NotificationChannel channel : s.getChannels()) {
                        channel.send(s, notice.getTitle());
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        NoticeBoard noticeBoard = new NoticeBoard();

        Student asha = new Student("Asha", "CSE", Arrays.asList(new EmailChannel(), new AppChannel()));
        Student ravi = new Student("Ravi", "ECE", Collections.singletonList(new SmsChannel()));

        noticeBoard.registerStudent(asha);
        noticeBoard.registerStudent(ravi);

        noticeBoard.postNotice(new Notice("Lab Closed Tomorrow", Collections.singletonList("CSE")));
        noticeBoard.postNotice(new Notice("Fee Deadline Extended", Arrays.asList("CSE", "ECE")));
        noticeBoard.postNotice(new Notice("Sports Day", Collections.emptyList()));
    }
}
