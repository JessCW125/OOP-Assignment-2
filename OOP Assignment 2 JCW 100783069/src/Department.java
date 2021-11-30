import java.util.HashSet;
import java.util.Vector;
import java.util.Random;

public class Department {

   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   Random rand = new Random();//create a random object to generate randomized numbers
   
   public Department(String name, String id) {
	      // also initialize the vectors

      //initialize name and id
      this.name = name;
      this.id = id;

      //create new vectors to store lists of courses and students
      courseList = new Vector<>();
      registerList = new Vector<>();

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

      return(id+ ": " + courseList.size() + " courses, " + registerList.size() + " students");

   }

   //adds a course to the courseList
   public void offerCourse(Course course){

      //add course to the vector
      courseList.add(course);

   }

   //This method prints the course info about each course in the department in an arbitrary order
   public void printCoursesOffered(){

      //initialize variables
      int x;
      Vector<Course> copy = new Vector<Course>();

      //repeat the loop for the same amount of times as the courseList vector size
      for (int i = 0; i < courseList.size(); i++){

         do{

            //assign x a random value between 0 and the courseList size
            x = rand.nextInt(courseList.size());

         } while (copy.contains(courseList.elementAt(x))); //repeat until an index of courseList.elementAt(x) hasn't been printed

         copy.add(courseList.elementAt(x)); //add to vector to keep track of what's already been printed
         courseList.elementAt(x).toString(); //print the course info of the ith element of courseList

      }

   }

   //prints a list of all the students registered in this department
   public void printStudentsByName(){

      //print each student's name and info
      for (int i = 0; i < registerList.size(); i++){

         //print tbe current student at the index's position's info
         (registerList.elementAt(i)).toString();

      }

   }

   //adds student to the registerList
   public void registerStudentCourseInDepartment(Student stud, Course course){

      //only adds student if the
      if (courseList.contains(course)) {

         //only adds student to the register list if they aren't already on it
         if (!isStudentRegistered(stud)) {

            //adds student to the vector
            registerList.add(stud);

         }

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
      int position=0;//initialize position

      //run through the vector elements to see which one is the one we're looking for and id it's there
      for (int i = 0; i < courseList.size(); i ++){

         //if the course is found execute the following
         if (code==((courseList.elementAt(i)).getCode())){

            //store current index value in position
            position = i;
            found =true; // confirm that the course was found
            break; //exit loop

         }

      }

      //if the course was found
      if (found){

         //return the vector
         return (courseList.elementAt(position)).getClassList();

      } else {

         //otherwise return nothing and tell the user the course is not in this department
         System.out.println("This course is not taught in this department.");
         return null;

      }

   }

   //this method prints student info of all the students in the course
   public void printStudentsRegisteredInCourse(int code){

      //print a header
      System.out.println("These are the students enrolled in " + id + code + ": ");

      int hold, size; //hold will store a random integer, size will hold the size of the student vector

      Vector<Student> courseStudents = studentsRegisteredInCourse(code);//get vector of students in the course
      size = courseStudents.size(); // get the size of the vector
      Vector<Student> copy = new Vector<Student>(size); // holds the students that already had their info printed

      //prints the student info in a random order
      for (int i = 0; i < size; i++){

         do {//find the index of a student whose info hasn't been displayed

            hold = rand.nextInt(size);//find a random number within a possible index of the vector

         } while (copy.contains(courseStudents.elementAt(hold))); // randomize if the student's already been displayed

         copy.add(courseStudents.elementAt(hold)); // add the new student to this vector of students that have already been printed
         (courseStudents.elementAt(hold)).toString(); // display their info

      }

   }

   //This method returns the course in the department with the most students
   public Course largestCourse(){

      //initialize/declare ints to hold class and vector sizes and one to hold an index
      int hold1 = 0, hold2 = 0, indexHold = 0, size;

      size = courseList.size(); // find the size of the course list

      for (int i = 0; i < size; i++){

         hold1 = (courseList.elementAt(i)).getCourseSize();//holds the size of the current course size

         //if hold1 is larger than hold2
         if (hold1 > hold2){

            hold2 = hold1;//hold2 takes value of hold 1
            indexHold = i; // indexhold takes the value of the current index value

         }

      }

      return courseList.elementAt(indexHold);//return the course with the largest class size

   }

}
