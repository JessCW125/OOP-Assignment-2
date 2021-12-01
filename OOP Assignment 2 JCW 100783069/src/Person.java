public class Person {

   /***
    * This course creates the object person, with attributes such as the person's name. This acts as a parent class
    * to the student class
    */

   private String   name;

   /***
    * Constructor for the Person class
    * @param initialName the person's name
    */
   public Person(String initialName) {

      name = initialName;
      
   }

   /***
    * Setter for the person's name
    * @param fullName the new name we are now calling this person
    */
   public void setName( String fullName) {

      name = fullName;

    }

   /***
    * Gets the person's name
    * @return the person's name
    */
   public String getName() {

      return name;
   }

   /***
    * Returns details about the person
    * @return a string telling the user the person's name
    */
   public String toString() {

      System.out.println("Name: " + name);

   return null;

   }
}
