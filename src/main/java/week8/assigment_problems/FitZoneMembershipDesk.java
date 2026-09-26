package week8.assigment_problems;

public class FitZoneMembershipDesk {
    public interface MembershipPlan {
        String getName();
        double calculateFee(double baseRatePerMonth);
    }

    public static class MonthlyPlan implements MembershipPlan {
        @Override public String getName() { return "Monthly"; }
        @Override public double calculateFee(double baseRate) { return baseRate * 1; }
    }

    public static class QuarterlyPlan implements MembershipPlan {
        @Override public String getName() { return "Quarterly"; }
        @Override public double calculateFee(double baseRate) { return (baseRate * 3) * 0.90; }
    }

    public static class AnnualPlan implements MembershipPlan {
        @Override public String getName() { return "Annual"; }
        @Override public double calculateFee(double baseRate) { return (baseRate * 12) * 0.75; }
    }

    public enum MembershipStatus {
        ACTIVE, FROZEN, EXPIRED
    }

    public static class Member {
        private String name;
        public Member(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Membership {
        private Member member;
        private MembershipPlan plan;
        private MembershipStatus status;
        private double fee;

        public Membership(Member member, MembershipPlan plan) {
            this.member = member;
            this.plan = plan;
            this.status = MembershipStatus.ACTIVE;
            this.fee = plan.calculateFee(1000.00);
            System.out.printf("%s membership created for %s. Fee: ₹%,.2f. Status: Active.%n",
                    plan.getName(), member.getName(), fee);
        }

        public void checkIn() {
            if (status == MembershipStatus.ACTIVE) {
                System.out.println(member.getName() + " checked in successfully.");
            } else if (status == MembershipStatus.FROZEN) {
                System.out.println("Check-in denied: " + member.getName() + "'s membership is Frozen.");
            } else {
                System.out.println("Check-in denied: " + member.getName() + "'s membership is Expired.");
            }
        }

        public void freeze() {
            if (status == MembershipStatus.ACTIVE) {
                this.status = MembershipStatus.FROZEN;
                System.out.println(member.getName() + "'s membership frozen. Status: Frozen.");
            } else if (status == MembershipStatus.EXPIRED) {
                System.out.println("Cannot freeze an Expired membership.");
            }
        }

        public void unfreeze() {
            if (status == MembershipStatus.FROZEN) {
                this.status = MembershipStatus.ACTIVE;
                System.out.println(member.getName() + "'s membership unfrozen. Status: Active.");
            }
        }

        public void expire() {
            this.status = MembershipStatus.EXPIRED;
            System.out.println(member.getName() + "'s membership expired. Status: Expired.");
        }
    }

    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMem = new Membership(asha, new QuarterlyPlan());
        Membership raviMem = new Membership(ravi, new MonthlyPlan());

        ashaMem.checkIn();
        ashaMem.freeze();
        ashaMem.checkIn();

        raviMem.expire();
        raviMem.freeze();
    }
}
