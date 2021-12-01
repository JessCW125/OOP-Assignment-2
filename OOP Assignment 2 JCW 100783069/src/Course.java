import java.util.Vector;

/***
 * This class creates an object Course with attributes, title, code, course number and a list of students in the class.
 * This class also contains methods that do things such as adding students to its class list
 */

public class Course{

   private Department dept;
   private String title; // title of the course (e.g. Intro to programming);
   private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
   private int number; // course number, e.g. 1200, 2710, 2800, etc.
   private  Vector <Student>classList; // contains all students registered in this course

    /***
     * This is the constructor for the Course
     * @param code four letter code of the course
     * @param number four digit number that specifies the course further
     * @param dept the department that this course belongs to
     * @param title the full name of the course
     */
   public Course(String code, int number, Department dept, String title) {

       //assign values to variables
        this.code = code;
        this.number = number;
        this.dept = dept;
        this.title = title;

        //create a vector list for the students in the class
        classList = new Vector<>();

	   }

    /***
     * returns the number portion of the course code
     * @return number portiion of the course code
     */
   public int getCode(){

       return number;

    }


    /***
     * returns the class list vector of students
     * @return vector of Students in the class
     */
    public Vector<Student> getClassList(){

       return classList;

    }

    /***
     * gives the number of students in the class
     * @return an integer equal to the number of students in the course
     */
    public int getCourseSize(){

       return (classList.size());

    }

    /***
     * This method returns a string of the full course code (code and number), the course's full name, and the number
     * of students taking the course
     * @return a string of the course details
     */
  public String toString() {

     // return a string representation of the course with the course code,
     // name, and number of people registered in the course in the following
     // format:
     // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260

      return (code + " " + number + " " + title + ", Enrollment = " + classList.size());

  }

    /***
     * This method adds a student to the classList
     * @param stud the student we are trying to add to the course
     */
  public void addStudentToCourse(Student stud){

       //adds the student to classList vector
       classList.add(stud);

   }

}
