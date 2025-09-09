import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        double totalMarks = 0;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            totalMarks += marks;
        }

       
        System.out.println("\nTotal Marks: " + totalMarks);

        
        double averagePercentage = totalMarks / numberOfSubjects;
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("Grade: " + grade);

        scanner.close();
    }
}