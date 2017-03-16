/** Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */

/* Student is a class that collect registered courses information and subject of interest.
 * The objective of this class is to allow a students to be able to do the following tasks 
 * 
 *  - Register on the course.
 *  - Set scores for a course based on course code
 *  - Calculate the accummulate GPA
 *  - Show the subject that students may fail after the midterm exam
 *  - Method to calculate how much score students need to do to get an A 
 * */

import java.util.ArrayList;
import java.util.Iterator;

public class Student extends Person {
	
	private ArrayList<String> subjectInterest;
	private ArrayList<RegCourse> registeredCourses;
	
	//Impliment by ME
	private RegCourse registCourse;
	//setAllScore
	private char grade;
	private double gradeNum;
	
	// Constructor
	public Student(String firstName, String lastName, int age, char gender) {
		//CODE HERE
		super(firstName, lastName, age, gender);
        registeredCourses = new ArrayList<>();
	}

	//Printing Students basic information @Overriding
	public void printInfo(){
		//CODE HERE
		System.out.println("Name: "+this.getFirstName()+" "+this.getLastName()+"\nAge:"+this.getAge()+", Gender "+this.getGender());
		System.out.println("\n[Registered courses]");
		for(RegCourse a : registeredCourses){
			System.out.println(a.getCourseCode() + " - " + a.getCourseName());
		}
	}
	
	//Method for students to register course
	public void RegisterCourse(RegCourse a){
		//CODE HERE
		registeredCourses.add(a);
	}
	
	//Method for student to add RAW scores on particular course code 
	public void setAllScore(String cCode, int attScore, int quiScore, int proScore,int miScore, int fiScore) {
		//CODE HERE
		for(RegCourse a : registeredCourses){
			if(cCode == a.getCourseCode()){
				a.setAttendance(attScore);
				a.setQuiz(quiScore);
				a.setProjects(proScore);
				a.setMidScore(miScore);
				a.setFinalScore(fiScore);
				//System.out.println(a.getAccumScore());
			}
		}
	}
	
	//Method for converting accumulate score to an alphabet GRADE (e.g., A, B, C, D, F)
	// A=4.0, B=3.0, C=2.0, D=1.0, F=0.0
	public char Grading(RegCourse a){	//a is code
		//CODE HERE
		for(RegCourse course : registeredCourses){
			if(a.completedCourse()){
				if(a.getAccumScore() >= 80){
				grade = 'A';
				}
				else if(a.getAccumScore() >= 70 && a.getAccumScore() < 80){
					grade = 'B';
				}
				else if(a.getAccumScore() >= 60 && a.getAccumScore() < 70){
					grade = 'C';
				}
				else if(a.getAccumScore() >= 50 && a.getAccumScore() < 60){
					grade = 'D';
				}
				else if(a.getAccumScore() < 50){
					grade = 'F';
				}
			}
			
		}
		return grade;
	}
	
	// Method for calculating accumulate GPA (only applied for completed courses)
	// The Accumulate GPA is calculated by (1) multiply each numeric grade value 
	// by the number of credits the course was defined. (2) add these number together  
	// (3) Divided this number by total number of credit a student took (only the completed course)
	public double accumGPA(){	
		double finalgpa = 0.0;
		//CODE HERE
		double sumGPA = 0.0;
		double sumCredit = 0.0;
		for(RegCourse a : registeredCourses){
				// A=4.0, B=3.0, C=2.0, D=1.0, F=0.0
			if(a.completedCourse()){
				if(a.getAccumScore() >= 80){
					gradeNum = 4.0;
				}
				else if(a.getAccumScore() >= 70 && a.getAccumScore() < 80){
					gradeNum = 3.0;
				}
				else if(a.getAccumScore() >= 60 && a.getAccumScore() < 70){
					gradeNum = 2.0;
				}
				else if(a.getAccumScore() >= 50 && a.getAccumScore() < 60){
					gradeNum = 1.0;
				}
				else if(a.getAccumScore() < 50){
					gradeNum = 0.0;
				}
				sumGPA += gradeNum * a.getCourseCredit();
				sumCredit += a.getCourseCredit();
			}
			finalgpa = sumGPA/sumCredit;
		}
			
		return finalgpa;
	}
	
	// Method for checking and printing course that students may have problems
	// The severe subject is calculated by accumulate score < half of a current full score
	// E.g., Assume that  the Object-Oriented programming has grading criteria as attendance=10%, quiz=10%, project=20%, midterm=30%, final=30% 
	// Currently your score is attendance=50/100, quiz=4/10, project=45/100, midterm 48/100, finalexam = 0/100 (haven't done final exam) .
	// The accumulate score = (50*10)/100 + (4*10)/10 + (45*20)/100 + (48*30)/100 + 0 
	//	                    =  5 + 4 + 9 + 14.4 + 0  = 32.4
	// Therefore, the accumulate score (32.4) less than half of a current grading criteria score which is (35)
	// Student may have a problem with this subject at the end of the course (after final exam).
	public void severeSubject(){
		//CODE HERE
		double sumFull = 0;
		double sumFull1 = 0;
		double sumFull2 = 0;
		double sumFull3 = 0;
		double sumFull4 = 0;
		double sumFull5 = 0;
		int count =0;
		for(RegCourse a : registeredCourses){
			if(a.getAttendance() == -1){
				sumFull1 += a.getFull_score_attendance();
			}
			if(a.getQuiz() == -1){
				sumFull2 += a.getFull_score_quiz();
			}
			if(a.getProjects() == -1){
				sumFull3 += a.getFull_score_projects();
			}
			if(a.getMidScore() == -1){
				sumFull4 += a.getFull_score_midScore();
			}
			if(a.getFinalScore() == -1){
				sumFull5 += a.getFull_score_finalScore();
			}
			
			sumFull = sumFull1 + sumFull2 + sumFull3 + sumFull4 + sumFull5;
			//has subject which accumulate score < half of a current full score
			if(a.getAccumScore() < sumFull/2){
				count++;
			}
			if(a.getAccumScore() < sumFull/2){
				if(count > 0){
					System.out.println("\n[Severe subject]");
				}
				System.out.println(a.getCourseCode() + ": " + a.getCourseName());
			}
		}
	}

	// Method to calculate on how much score a student need to work on to get an A on a given course
	// To get an 'A', students must have score more than 80%
	public void howToGetASubject(String cCode){
		//CODE HERE
		for(RegCourse a : registeredCourses){
			if(cCode == a.getCourseCode()){
				double need = 80 - a.getAccumScore();
				//If need score less than the maximum final score, it is impossible to get A.
				if(need > 50){
					System.out.println("\n[" + a.getCourseCode() + "-" + a.getCourseName() + "]");
					System.out.println("You can't get A for this subject");
				}
				else if(need < 50){
					System.out.println("\n[" + a.getCourseCode() + "-" + a.getCourseName() + "]");
					System.out.println("You need " + need + " score more to get an A for this subject");
				}
			}
		}
	}
	
	//Method to lists all instructors that teach the registered subjects
	public void relevantInstructor(ArrayList<Instructor> listINS){
		//CODE HERE
		ArrayList<Instructor> InstructorName = new ArrayList<Instructor>();
		System.out.println("\n[Relevant Instrutor]");
		
		//Loop for check all of instructor name
		for(Instructor aj : listINS){
			
			//Loop for check all of registered courses
			for(RegCourse course : registeredCourses){
				
				//Loop for check that instructor teaches what registered course
				for(RegCourse ic:aj.getTeaching()){
					
					//If code of registered course is equal to instructor course, print instructor's name.
					if(course.getCourseCode().equals(ic.getCourseCode())){
						
						InstructorName.add(aj);
						
					}
				}
				
			}
		}
		
		//Part of removing the same instructor's name
		//http://stackoverflow.com/questions/203984/how-do-i-remove-repeated-elements-from-arraylist
		
		ArrayList<Instructor> rInstructor = new ArrayList<Instructor>();
		Iterator<Instructor> iterator = InstructorName.iterator();
		
		while (iterator.hasNext())
        {
			Instructor o = (Instructor) iterator.next();
			if(!rInstructor.contains(o)) rInstructor.add(o);
        }
		for(Instructor i : rInstructor){
			i.printInfo();
		}
	}

}
