import java.util.HashSet;
import java.util.Vector;
import java.util.Random;

/***
 * This class creates a Department object that records the courses it offers and the students registered in them.
 * It also contains various methods that adds courses to it, returns strings with details about it, displays lists
 * of courses it offers and students within the department and their information, adds students to the registration list
 * after they register for a course within the department, prints a list of students in a course in the department,
 *  returns whether or not a student is within the department, and which course has the most students.
 */
public class Department {

   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   Random rand = new Random();//create a random object to generate randomized numbers

   /***
    * This method constructs the Department object.
    *
    * @param name name of the department
    * @param id the four digit ID of the department
    */
   public Department(String name, String id) {

      //initialize name and id
      this.name = name;
      this.id = id;

      //create new vectors to store lists of courses and students
      courseList = new Vector<>();
      registerList = new Vector<>();

	   }

       //getters and for ID and Name

   /***
    * Gets the name of the department
    * @return department name
    */
   public String getName() {

      return name;

   }

   /***
    * Returns the department's ID
    * @return department ID
    */
   public String getId() {

      return id;

   }

   /***
    * @return Returns a string with the department's ID, the number of courses they offer and how many students are in it
    */
   public String toString() {

      // returns a string representation of department name, number 
      // of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students

      return(id+ ": " + courseList.size() + " courses, " + registerList.size() + " students");

   }

   /***
    * adds a course to the courseList so that the department offers it
    * @param course the Course object to be added to the department
    */
   public void offerCourse(Course course){

      //add course to the vector
      courseList.add(course);

   }

   /***
    * This method prints the course info about each course in the department in an arbitrary order
    */
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
         System.out.println(courseList.elementAt(x).toString()); //print the course info of the ith element of courseList

      }

   }

   /***
    * prints a list of all the students registered in this department
    */
   public void printStudentsByName(){

      //print each student's name and info
      for (int i = 0; i < registerList.size(); i++){

         //print tbe current student at the index's position's info
         System.out.println((registerList.elementAt(i)).toString());

      }

   }

   /***
    * This method adds student to the registerList
    * @param stud the student we are adding to the course in the department
    * @param course the course we are adding the student to in the department
    */
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

   /***
    * returns whether or not student is registered in a course in the department or not
    * @param student the student we are checking to see if they are in the department or not
    * @return returns a bool value. True is returned when the student is in the department
    * and vice versa
    */
   public boolean isStudentRegistered(Student student){

     return (registerList.contains(student)); //returns true if student is in registerList vector

   }

   /***
    * this returns a course's classList after checking that the course is in the department
    * @param code the code of the course in the department that we are looking for
    * @return the class list of the class found. If the course is not found, nothing is returned and a
    * statement saying that the course is not in the separtment
    */
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

   /***
    * this method prints student info of all the students in the course
    * @param code the code of the course in the department that we are trying to display the classlist for
    */
   public void printStudentsRegisteredInCourse(int code){

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
         System.out.println((courseStudents.elementAt(hold)).toString()); // display their info

      }

   }

   /***
    * This method returns the course in the department with the most students
    * @return course with the most students in it
    */
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
