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

       //getters and for ID and Name

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

   //adds student to the registerList
   public void addStudentToRegister(Student stud){

      //only adds student to the register list if they aren't already on it
      if (isStudentRegistered(stud)) {

         //adds student to the vector
         registerList.add(stud);

      }

   }

   //prints student info of all students in the department
   public void printStudentsByName(){

      //outputs a header
      System.out.println("These are the students in the " + name + " department: \n");

      //repeat encapsulated content for the same amount of times as registerList's size
      for (int i = 0; i < registerList.size(); i++){

         //print each student's info
         registerList.elementAt(i).toString();

      }

   }

   //returns whether or not student is registered in a course in the department or not
   public boolean isStudentRegistered(Student student){

     return (registerList.contains(student)); //returns true if student is in registerList vector

   }

   //this returns a course's classList after checking that the course is in the department
   public Vector<Student> studentsRegisteredInCourse(int code){

      //initialize variables
      boolean found = false;
      Vector<Student> studentsInCourse = new Vector<Student>(); //create a new vector to return

      //run through the vector elements to see which one is the one we're looking for and id it's there
      for (int i = 0; i < courseList.size(); i ++){

         //if the ourse is found execute the following
         if (code==((courseList.elementAt(i)).getCode())){

            //make studentsInCourse equal to the class list of the found course
            studentsInCourse = (courseList.elementAt(i)).getClassList();
            found =true; // confirm that the course was found
            break; //exit loop

         }

      }

      //if the course was found
      if (found){

         //return the vector
         return studentsInCourse;

      } else {

         //otherwise return nothing and tell the user the course is not in this department
         System.out.println("This course is not taught in this department.");
         return null;

      }

   }

}
