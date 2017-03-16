/** Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */


import java.util.*;

public class Instructor extends Person {

	private ArrayList<Integer> skill;
	private ArrayList<String> researchInterest;
	private ArrayList<RegCourse> teaching;
	
	public Instructor(String firstName, String lastName, int age, char gender) {
	//CODE HERE
		super(firstName, lastName, age, gender);
        teaching = new ArrayList<>();
	}
	
	//Other relevant methods should be defined here

	//add a teaching course
	public void setTeaching(RegCourse course) {
	//CODE HERE	
		teaching.add(course);
	}
	public ArrayList<RegCourse> getTeaching(){
		return teaching;
	}
	
    //Printing Instructor information @Overridding
    public void printInfo(){
    //CODE HERE
    	System.out.println(super.getFirstName() + " " + super.getLastName());
    }
}
