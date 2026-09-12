package week6.assigment_problems;

public class MonthlyAttendanceAnnouncer {
    public static class GymMember {
        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public String displayInfo() {
            return "Standard | Sessions: " + sessionsAttended;
        }
    }

    public static class PremiumMember extends GymMember {
        private String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        public String getTrainerName() {
            return trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
        }
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (GymMember m : members) {
            if (m != null) {
                sb.append(m.displayInfo());
                if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(members));
    }
}
