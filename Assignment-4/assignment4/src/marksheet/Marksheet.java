package marksheet;


/**
 * performs operations related to the grades of students like average, maxGrade etc
 * @author Prakalpa-Rathore
 *
 */
public class Marksheet {

	int noOfStudents; 
	double grades[]; 
	
	public int getNoOfStudents() {
		return noOfStudents;
	}
	
	
	/**
	 * assigns the total no. of students to noOfStudents variable
	 * @param noOfStudents takes no. of students as parameter, assumes noOfStudents > 0
	 */
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public double[] getGrades() {
		return grades;
	}
	
	
	/**
	 * assigns the grades of each student to grades[] array
	 * @param grades array containing grades of each student, assumes grade>=0.00 and grade<=100.00
	 */
	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	
	/**
	 * calculates the average of the grades of n no. of students
	 * @return average of grades
	 */
	public double average() throws ArithmeticException
	{
		double sum = 0;
		
		for(int i=0; i<noOfStudents; i++)
			sum += grades[i];
		
		return sum/noOfStudents;
	}
	
	
	/**
	 * calculates the maximum of all grades
	 * @return maximum grade
	 */
	public double maxGrade() throws ArithmeticException
	{
		double max = grades[0];
		
		for(int i=1; i<noOfStudents; i++)
		{
			if(grades[i]>max)
				max = grades[i];
		}
		
		return max;
	}
	
	
	/**
	 * calculates the minimum of all grades
	 * @return minimum grade
	 */
	public double minGrade() throws ArithmeticException
	{
		double min = grades[0];
		
		for(int i=1; i<noOfStudents; i++)
		{
			if(grades[i]<min)
				min = grades[i];
		}
		
		return min;
	}
	
	
	/**
	 * calculate the percentage of students passed, student is passed if grade >= 40
	 * @return percentage of students passed
	 */
	public double studentsPassedPercent() throws ArithmeticException
	{
		double pass = 0;
		
		for(int i=0; i<noOfStudents; i++)
		{
			if(grades[i] >= 40)
				pass++;
		}
		
		return ((pass/noOfStudents)*100);
	}
	
}
