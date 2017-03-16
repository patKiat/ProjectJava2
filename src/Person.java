/** Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */

public class Person {
	//Basic Information of Instructor and Students
    private String firstName;
    private String lastName;
    private int age;
    private char gender;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.gender = 'I';
    }

    public Person(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
        this.age = 0;
        this.gender = 'I';
    }
    
    public Person(String fname, String lname, int age, char gender) {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.gender = gender;
    }
    
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //Printing General information
    public void printInfo(){
    	System.out.println("Name: "+firstName+" "+lastName+"\nAge:"+age+", Gender "+gender);
    }
    
}
