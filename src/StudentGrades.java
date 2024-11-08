import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {

        // Initialize scanner and read input
        Scanner scanner = new Scanner(System.in);

        // Taking in the number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];

        // displays the scores of students
        System.out.println("Enter the grades of the students: ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // Call methods to calculate required values
        int maxGrade = getMaxGrade(scores);
        int minGrade = getMinGrade(scores);
        double avgGrade = getAverageGrade(scores);

        // Calculate grade distribution
        int[] stats = getGradeDistribution(scores);

        // Display values
        System.out.println("\nValues:");
        System.out.println("The maximum grade is " + maxGrade);
        System.out.println("The minimum grade is " + minGrade);
        System.out.printf("The average grade is %.6f\n", avgGrade);

        // Display bar graph
        System.out.println("\nGraph:");
        displayGraph(stats);
    }

    // Method to calculate maximum grade
    public static int getMaxGrade(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Method to calculate minimum grade
    public static int getMinGrade(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    // Method to calculate average grade
    public static double getAverageGrade(int[] scores) {
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // Method to calculate grade distribution
    public static int[] getGradeDistribution(int[] scores) {
        int[] stats = new int[5]; // stats[0] to stats[4] stores counts for each range

        for (int score : scores) {
            if (score >= 0 && score <= 20) {
                stats[0]++;
            } else if (score >= 21 && score <= 40) {
                stats[1]++;
            } else if (score >= 41 && score <= 60) {
                stats[2]++;
            } else if (score >= 61 && score <= 80) {
                stats[3]++;
            } else if (score >= 81 && score <= 100) {
                stats[4]++;
            }
        }

        return stats;
    }

    // Method to display bar graph
    public static void displayGraph(int[] stats) {
        // Display the graph for each range
        for (int i = 5; i > 0; i--) {
            System.out.print("   " + i + "  > ");
            for (int j = 0; j < 5; j++) {
                if (stats[j] >= i) {
                    System.out.print("#######   ");
                }
            }
            System.out.println();
        }

        // Display the grade ranges
        System.out.println("      +-----------+---------+---------+---------+---------+");
        System.out.println("      I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");
    }
}
