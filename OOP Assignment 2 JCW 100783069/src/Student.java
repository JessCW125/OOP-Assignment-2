import java.util.Vector;

/***
 * This class is a child class of the Person class. It contains additional attributes from the Person class such as
 * student ID and a list of courses they are registered in. This class also contains methods that registers the student
 * in classes and checks if they are in a course.
 */

public class Student extends Person{

  private String id;
  private String name;
  private Vector courses; // contains all courses the student is registered in

	/***
	 * Constructor for the student.
	 * @param stdId the 9 digit number that is the student's student ID number
	 * @param stdName the name of the student
	 */
	public Student(String stdId, String stdName) {

		//call parent class constructor
		super(stdName);

		//initialize other variables
		name = stdName;
		id = stdId;

		//create a vector to hold all of the student's enrolled courses
		courses = new Vector<>();

	}

	//getters for name and ID

	/***
	 * gets the name of the student
	 * @return a string of the student's name
	 */
	public String getName() {

		return name;

  	  }

	/***
	 * Returns the student's ID number
	 * @return the student's ID as a String
	 */
	public String getId() {

		return id;

  	  }

	/***
	 * This returns a String that will display all of the Student's info
	 * @return a String of the student's ID number and name and, on a line after, a list of the courses they are taking
	 */
	public String toString() {
     // return a string representation of a student using the following format:
     // 100234546 John McDonald
     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850

		return(id + " " + name+ "\nRegistered courses: " + courses);

  	}

	/***This method adds a student to a course and updates the list of courses the student is registered in, the list
	 * of students registered in the course and the list of students in the department
	 * @param course the Course the student is registering for
	 */
	public void registerFor(Course course){

		//checks if the student is already in the course or not
		if (!(courses.contains(course))){

			courses.add(course);//adds the course to the student's list
			//course.addToClassList(this);//adds student to the class list
			//course.addStudToRegister(this); //adds student to the course's department's registerList

		}

	}

	/***
	 * This method checks whether or not a student is in a certain course
	 * @param course the course that we are checking if the student is in or not
	 * @return True will be returned if the student is taking the course and it is in their course list and vice versa
	 */
	public Boolean isRegisteredInCourse(Course course){

		return courses.contains(course);//returns true if the course is found in student's courses vector

	}

}
