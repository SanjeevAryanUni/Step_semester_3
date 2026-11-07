package week11.assigment_problems;

public class HackathonRegistrationDesk {
    public static class Team {
        public String name;
        public int size;

        public Team(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return name + "(" + size + ")";
        }
    }

    /**
     * Problem 2: The Hackathon Registration Desk
     * Sorts teams in place by team size (ascending) using Insertion Sort.
     * Preserves original registration order for teams of equal size (Stable).
     * 
     * Time Complexity:
     *   - Best Case: O(n) when already sorted
     *   - Worst / Average Case: O(n^2)
     * Extra Space Complexity: O(1) in-place
     * Stability: Stable (strictly '>' comparison preserves order of equal elements)
     */
    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }

        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;

            // Shift elements right only if their size is strictly greater than key.size
            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Team[] teams = {
            new Team("Pixel", 4),
            new Team("Byte", 2),
            new Team("Nova", 4),
            new Team("Echo", 3),
            new Team("Atom", 2)
        };

        sortTeams(teams);

        // Expected Output: Byte(2), Atom(2), Echo(3), Pixel(4), Nova(4)
        for (int i = 0; i < teams.length; i++) {
            System.out.print(teams[i]);
            if (i < teams.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
