/* 
 * You are not supposed to change this file. 
 * the Class TestCase is used to test all the method that you have build. 
 */

import java.util.ArrayList;

public class TestCase {

	public static void main(String[] args) {
		
		// ADD Course
		RegCourse funProgramming = new RegCourse("ITCS200","Fundamentals of Programming", true, 3);
		funProgramming.setCourseGrading(10, 10, 20, 30, 30);
		funProgramming.setFullScore(100, 30, 100, 100, 100);
		RegCourse OOP = new RegCourse("ITCS208","Object-Oriented Programming", true, 3);
		OOP.setCourseGrading(10, 10, 20, 30, 30);
		OOP.setFullScore(100, 30, 100, 100, 100);
		RegCourse digitalSystem = new RegCourse("ITCS211","Introduction to Digital Systems", true, 3);
		digitalSystem.setCourseGrading(10, 0, 0, 40, 50);
		digitalSystem.setFullScore(100, 0, 0, 40, 50);
		RegCourse eng2 = new RegCourse("ITLG201","Reading", true, 1);
		eng2.setCourseGrading(10, 0, 30, 30, 30);
		eng2.setFullScore(100, 0, 30, 30, 30);


		// ADD Instructors
		ArrayList<Instructor> listINS = new ArrayList<Instructor>();
		
		Instructor somchai = new Instructor("Somchai", "Jaidee", 35, 'M');
		//Assign teaching courses
		somchai.setTeaching(OOP);
		somchai.setTeaching(funProgramming);
		
		Instructor somsri = new Instructor("Somsri", "Deejai", 29, 'F');
		//Assign teaching courses
		somsri.setTeaching(OOP);
		somsri.setTeaching(digitalSystem);
		
		Instructor somjai = new Instructor("Somjai", "Maimee", 28, 'F');
		//Assign teaching courses
		somjai.setTeaching(eng2);
		
		listINS.add(somchai);
		listINS.add(somsri);
		listINS.add(somjai);

		// ADD Student(1)
		Student peter = new Student("Peter", "Parker", 21, 'M');
		//a student registers to courses
		peter.RegisterCourse(funProgramming);
		peter.RegisterCourse(OOP);
		peter.RegisterCourse(digitalSystem);
		
		//Print students information
		peter.printInfo();
		//Set raw score for each subjects
		peter.setAllScore("ITCS208", 100, 12, 75, 45, 60);
		peter.setAllScore("ITCS200", 100, 15, 80, 50, 75);
		peter.setAllScore("ITCS211", 40, 0, 0, 10, -1);

		System.out.print("\n[Accummulate GPA] : ");
		System.out.println(peter.accumGPA());
		peter.severeSubject();
		peter.relevantInstructor(listINS);
		peter.howToGetASubject("ITCS211");
		
		System.out.print("\n ---------------------\n");

		// ADD Student(2)
		Student sarah = new Student("Sarah", "Josh", 20, 'F');
		//a student registers to courses
		sarah.RegisterCourse(funProgramming);
		sarah.RegisterCourse(OOP);
		sarah.RegisterCourse(digitalSystem);
		sarah.RegisterCourse(eng2);
		
		//Print students information
		sarah.printInfo();
		//Set RAW score for each subjects
		sarah.setAllScore("ITCS200", 100, 17, 85, 63, 60);
		sarah.setAllScore("ITCS208", 100, 18, 82, 60, 72);
		sarah.setAllScore("ITCS211", 100, 0, 0, 25, -1);
		sarah.setAllScore("ITLG201", 100, 0, 30, 23, -1);

		//Show accummulate GPA
		System.out.print("\n[Accummulate GPA] : ");
		System.out.println(sarah.accumGPA());
		
		//Show subject that a student may have problems
		sarah.severeSubject();
		
		//show a list of instructors that teach the registered course
		sarah.relevantInstructor(listINS);
		
		//show how much a student need to do to get A on a particular subject
		sarah.howToGetASubject("ITCS211");
		sarah.howToGetASubject("ITLG201");
	}

}
