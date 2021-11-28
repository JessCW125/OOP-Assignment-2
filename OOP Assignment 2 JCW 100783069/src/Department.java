 import java.util.HashSet;
import java.util.Vector;

public class Department {
   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   
   public Department(String name, String id) {
	      // also initialize the vectors

      //initialize name and id
      name = this.name;
      id = this.id;

      //create new vectors to store lists of courses and students
      Vector<Course> courselist = new Vector<Course>();
      Vector<Student> registerlist = new Vector<Student>();

	   }

   public String getName() {

      return name;

   }

   public String getId() {

      return id;

   }
   
 	
   public String toString() {
      // returns a string representation of department name, number 
      // of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students

      System.out.println(name+ ": " + courseList.size() + " courses, " + registerList.size() + " students");

      return null;

   }

   //adds a course to the courseList
   public void offerCourse(Course course){

      //add course to the vector
      courseList.add(course);

   }

   //This method prints the course info about each course in the department
   public void printCoursesOffered(){

      //repeat the loop for the same amount of times as the courseList vector size
      for (int i = 0; i < courseList.size(); i++){

         //print the course info of the ith element of courseList
         courseList.elementAt(i).toString();

      }

   }

}
