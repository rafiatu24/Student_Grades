import java.util.Scanner;

public class GradeStatistics {

    /**
     * Method to find the maximum grade in the array.
     *
     * @param scores Array of student grades.
     * @return Maximum grade in the array.
     */
    public static int getMaxGrade(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    /**
     * Method to find the minimum grade in the array.
     *
     * @param scores Array of student grades.
     * @return Minimum grade in the array.
     */
    public static int getMinGrade(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    /**
     * Method to calculate the average grade of the array.
     *
     * @param scores Array of student grades.
     * @return Average grade of the array.
     */
    public static double getAverageGrade(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    /**
     * Method to categorize grades into specific ranges.
     *
     * @param scores Array of student grades.
     * @return Array of counts for each grade range.
     */
    public static int[] calculateGradeDistribution(int[] scores) {
        int[] stats = new int[5];

        for (int score : scores) {
            if (score >= 81) {
                stats[4]++;
            } else if (score >= 61) {
                stats[3]++;
            } else if (score >= 41) {
                stats[2]++;
            } else if (score >= 21) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }
        return stats;
    }

    /**
     * Method to display a bar graph based on grade distribution.
     *
     * @param stats Array of counts for each grade range.
     */
    public static void displayBarGraph(int[] stats) {
        int maxCount = getMaxGrade(stats);

        System.out.println("\nGraph:");
        for (int row = maxCount; row > 0; row--) {
            System.out.printf("%4d >   ", row);
            for (int col = 0; col < stats.length; col++) {
                if (stats[col] >= row) {
                    System.out.print("#######   ");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }

        System.out.println("      +-----------+---------+---------+---------+---------+");
        System.out.println("      I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");
    }

    /**
     * Main method to execute the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input grades and store them in an array
            System.out.print("Enter the number of students: ");
            int N = scanner.nextInt();
            int[] scores = new int[N];

            System.out.println("Enter the grades of the students (0-100):");
            for (int i = 0; i < N; i++) {
                scores[i] = scanner.nextInt();
                if (scores[i] < 0 || scores[i] > 100) {
                    System.out.println("Grade should be between 0 and 100.");
                    return;
                }
            }

            // Calculate and display maximum, minimum, and average grades
            int maxGrade = getMaxGrade(scores);
            int minGrade = getMinGrade(scores);
            double avgGrade = getAverageGrade(scores);

            System.out.println("\nValues:");
            System.out.println("The maximum grade is " + maxGrade);
            System.out.println("The minimum grade is " + minGrade);
            System.out.printf("The average grade is %.6f\n", avgGrade);

            // Calculate grade distribution and display bar graph
            int[] gradeDistribution = calculateGradeDistribution(scores);
            displayBarGraph(gradeDistribution);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}
