import java.util.Vector;

public class Course{
   private Department dept;
   private String title; // title of the course (e.g. Intro to programming);
   private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
   private int number; // course number, e.g. 1200, 2710, 2800, etc.
   private  Vector <Student>classList; // contains all students registered in this course

   public Course(String code, int number, Department dept, String title) {
	      // also initialize the classList;

       //assign values to variables
        code = this.code;
        number = this.number;
        dept = this. dept;
        title = this.title;

        //create a vector list for the students in the class
        Vector <Student>classList = new Vector<Student>();

	   }

   
   public Course() {
	// TODO Auto-generated constructor stub
}
 
  public String toString() {
     // return a string representation of the course with the course code,
     // name, and number of people registered in the course in the following
     // format:
     // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260

      System.out.println(code + "" + number + " " + title + ", Enrollment = " + classList.size());

     return null;
  }



}
