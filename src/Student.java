/**
 * Creates the student class with properties.
 *
 * @author Emma Lee
 * @version 2024
 */
public class Student
{
    private String firstName;
    private String lastName;
    private String idNumber;
    private int birthYear;
    private double percentageGrade;
    private boolean pass;

    // No-arg constructor
    public Student()
    {}

    /**
     * Creates the student class with properties.
     *
     * @param firstName the first name of student as a String
     * @param lastName the last name of student as a String
     * @param idNumber the idNumber of student as a String
     * @param birthYear the birth year of student as an int
     * @param percentageGrade the percentage grade of student as a double
     * @throws IllegalArgumentException if any parameter is invalid:
     *                                  - firstName or lastName is null or empty
     *                                  - idNumber is null or empty
     *                                  - birthYear is not a positive integer
     *                                  - percentageGrade is not within the range [0, 100]
     */
    public Student(final String firstName,
                   final String lastName,
                   final String idNumber,
                   final int birthYear,
                   final double percentageGrade)
    {
        if (!isValidString(firstName) || !isValidString(lastName))
        {
            throw new IllegalArgumentException("First name and last name must not be null or empty.");
        }

        if (!isValidString(idNumber))
        {
            throw new IllegalArgumentException("ID number must not be null or empty.");
        }

        if (!isValidBirthYear(birthYear))
        {
            throw new IllegalArgumentException("Birth year must be a positive integer.");
        }

        if (!isValidPercentageGrade(percentageGrade))
        {
            throw new IllegalArgumentException("Percentage grade must be within the range [0, 100].");
        }

        setFirstName(firstName);
        setLastName(lastName);
        setIdNumber(idNumber);
        setBirthYear(birthYear);
        setPercentageGrade(percentageGrade);
        setPass(); // Set pass based on the percentage grade
    }

    /**
     * @return first name as a String
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name of student as a String
     */
    public void setFirstName(final String firstName)
    {
        if (isValidString(firstName))
        {
            this.firstName = firstName;
        }
    }

    /**
     * @return the last name of student as a String
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name of student as a String
     */
    public void setLastName(final String lastName)
    {
        if (isValidString(lastName))
        {
            this.lastName = lastName;
        }
    }

    /**
     * @return the id of the student as a String
     */
    public String getIdNumber()
    {
        return idNumber;
    }

    /**
     * Sets the id number of the student.
     *
     * @param idNumber the id of student as a String
     */
    public void setIdNumber(final String idNumber)
    {
        if (isValidString(idNumber))
        {
            this.idNumber = idNumber;
        }
    }

    /**
     * @return the birth year of student as an int
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * Sets the birth year of the student.
     *
     * @param birthYear the birth year of student as an int
     */
    public void setBirthYear(final int birthYear)
    {
        if (isValidBirthYear(birthYear))
        {
            this.birthYear = birthYear;
        }
    }
    /**
     * Gets the percentage grade of the student.
     *
     * @return the percentage grade as a double
     */
    public double getPercentageGrade()
    {
        return percentageGrade;
    }

    /**
     * Sets the percentage grade of the student and updates the pass status accordingly.
     *
     * @param percentageGrade the percentage grade of the student as a double
     */
    public void setPercentageGrade(final double percentageGrade)
    {
        if (isValidPercentageGrade(percentageGrade))
        {
            this.percentageGrade = percentageGrade;
            setPass(); // Update pass based on the new percentage grade
        }
    }

    /**
     * Checks if the student has passed based on the percentage grade.
     *
     * @return true if the student has passed, false otherwise
     */
    public boolean isPass()
    {
        return pass;
    }

    /**
     * Sets the pass status based on the percentage grade.
     */
    private void setPass()
    {
        this.pass = (percentageGrade >= 60);
    }

    /**
     * Validates if a string is not null or empty.
     *
     * @param string the string to be validated
     * @return true if the string is not null or empty, false otherwise
     */
    private boolean isValidString(final String string)
    {
        return string != null && !string.trim().isEmpty();
    }

    /**
     * Validates the birth year (assumes it must be a positive value).
     *
     * @param birthYear the birth year to be validated
     * @return true if the birth year is positive, false otherwise
     */
    private boolean isValidBirthYear(final int birthYear)
    {
        return birthYear > 0;
    }

    /**
     * Validates the percentage grade (assumes it must be between 0 and 100).
     *
     * @param percentageGrade the percentage grade to be validated
     * @return true if the percentage grade is within the valid range, false otherwise
     */
    private boolean isValidPercentageGrade(final double percentageGrade)
    {
        return percentageGrade >= 0 && percentageGrade <= 100;
    }

    /**
     * Overrides the toString() method to provide a string representation of the student object.
     *
     * @return a String representation of the student
     */
    @Override
    public String toString()
    {
        return "Student [" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birthYear=" + birthYear +
                ", percentageGrade=" + percentageGrade +
                ", pass=" + pass +
                ']';
    }
}




