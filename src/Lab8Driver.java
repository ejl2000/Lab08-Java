import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Creates the Lab8Driver class with properties.
 *
 * @author Emma Lee
 * @version 2024
 */
public class Lab8Driver
{
    private static final String FILE_PATH = "student_data.txt";
    private static Map<String, Student> students = new HashMap<>();
    public static final int DATA_LENGTH = 6;
    public static final int FIRST_NAME = 1;
    public static final int LAST_NAME = 2;
    public static final int ID_NUMBER = 3;
    public static final int BIRTH_YEAR = 3;
    public static final int PERCENTAGE_GRADE = 4;


    /**
     * The main method that orchestrates the program flow. It reads student data from
     * both user input and a file, creates Student objects, and displays the stored data.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args)
    {
        readFromPrompt();
        readFromFile();
        showStudents();
    }


    /**
     * Reads student information from the user prompt and creates Student objects.
     */
    public static void readFromPrompt()
    {
        boolean proceed;
        Scanner scanner;

        proceed = true;
        scanner = new Scanner(System.in);

        do {
            System.out.println("Do you wish to create a Student? (y/n): ");

            String choice;
            choice = scanner.next().toLowerCase();

            if(choice.equals("y"))
            {
                // Prompt for data and create Students
                createStudentFromPrompt(scanner);
            }

            else
            {
                proceed = false;
            }
        }

        while(proceed);

        scanner.close();
    }

    /**
     * Reads student information from a file specified by FILE_PATH using Scanner.
     */
    public static void readFromFile()
    {
        File file;

        file = new File(FILE_PATH);

        try(Scanner fileScanner = new Scanner(file))
        {
            while(fileScanner.hasNextLine())
            {
                final String line;
                line = fileScanner.nextLine();
                // Assuming each line in the file represents a Student's data
                createStudentFromFile(line);
            }
        }

        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Displays the stored student data by iterating over the HashMap and printing each Student.
     */
    public static void showStudents()
    {
        for(Student student : students.values())
        {
            System.out.println(student.toString());
        }
    }

    /**
     * Creates a Student object from user input and adds it to the HashMap.
     *
     * @param scanner Scanner object for user input
     */
    private static void createStudentFromPrompt(final Scanner scanner)
    {
        System.out.println("Enter first name: ");
        String firstName = scanner.next();

        System.out.println("Enter last name: ");
        String lastName = scanner.next();

        System.out.println("Enter ID number: ");
        String idNumber = scanner.next();

        System.out.println("Enter birth year: ");
        int birthYear = scanner.nextInt();

        System.out.println("Enter percentage grade: ");
        double percentageGrade = scanner.nextDouble();

        // Create Student object and add to HashMap
        final Student student;
        student = new Student(firstName, lastName, idNumber, birthYear, percentageGrade);
        students.put(student.getIdNumber(), student);
    }

    /**
     * Creates a Student object from file input and adds it to the HashMap.
     *
     * @param line a line of data from the file in the format "FirstName, LastName, IDNumber, BirthYear, PercentageGrade"
     */
    private static void createStudentFromFile(final String line)
    {
        // Assuming the data is separated by commas (you may need to adjust based on your file format)
        final String[] data;
        data = line.split(",");

        if(data.length == DATA_LENGTH)
        {
            final String firstName;
            final String lastName;
            final String idNumber;
            final int birthYear;
            final double percentageGrade;

            firstName = data[FIRST_NAME].trim();
            lastName = data[LAST_NAME].trim();
            idNumber = data[ID_NUMBER].trim();
            birthYear = Integer.parseInt(data[BIRTH_YEAR].trim());
            percentageGrade = Double.parseDouble(data[PERCENTAGE_GRADE].trim());

            // Create Student object and add to HashMap
            final Student student;
            student = new Student(firstName, lastName, idNumber, birthYear, percentageGrade);
            students.put(student.getIdNumber(), student);
        }
    }
}
