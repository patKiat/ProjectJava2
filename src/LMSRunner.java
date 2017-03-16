import java.awt.Choice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** LMSRunner.java - Start building ICT-LMS system 
 * Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */

/*
 *  LMSRunner is a main class for Administrators and Students to access the LMS based on their role.
 *  In LMSRunner, your task is to implement the system asking which roles a user is.
 *  
 *  If a user is an Administrator, he/she can do the following tasks
 *  - Add/Update/Delete Course
 *  - Add/Update/Delete Instructor
 *  - Add/Update/Delete Student
 *  - Able to set grading criteria (e.g., attendance, project, quiz, midterm, final) to the Course.
 *  - Able to add score of students in each criterion to the system.
 *  - Able to print information of all instructors and their teaching courses.
 *  - Able to print information of all students and their registered courses.
 *  
 *  For Students, They can do the following tasks
 *  - Able to register to the existing courses (add by administrator).
 *  - Able to see the accumulated GPA (only the subject that they have completed).
 *  - Able to evaluate the score that a student need to do to get  ‘A’ for a particular subject (only work with subject that they haven’t completed).
 *  - Able to illustrate subject that a student is likely have a problem with (only work with subject that they haven’t completed).
 *  - Able to search names of the instructors who teach in the registered courses.
 *
 * */

public class LMSRunner {

	//CODE HERE
	public static ArrayList<RegCourse> courses = new ArrayList<RegCourse>();
	public static ArrayList<Instructor> teachers = new ArrayList<Instructor>();
	public static ArrayList<Student> students = new ArrayList<Student>();
	private static Scanner in;
	private static Scanner inNum;
	private static Scanner inChar;
	private static Scanner inLine;
	private static boolean found = false;
	
	public static void addCourse(String code, String cname, boolean core, int cCredit){
		RegCourse a = new RegCourse(code, cname, core, cCredit);
		courses.add(a);
		System.out.println("\n[Course(s)] : ");
		for(RegCourse i : courses){
			System.out.println("[" + i.getCourseCode() + "] - " + i.getCourseName());
		}
	}
	
	public static void removeCourse(String code, String cname){
		
		String ccode = code.toLowerCase();
		String coursename = cname.toLowerCase();
		
		for(RegCourse i : courses){
			if(ccode.equals(i.getCourseCode().toLowerCase()) && coursename.equals(i.getCourseName().toLowerCase())){
				courses.remove(i);
				found = true;
				System.out.println("[" + i.getCourseCode() + "] - " + i.getCourseName() + " is removed.");
				break;
			}
		}
		if(found == false){
			System.out.println("\nThis course does not exist!\n");
		}
		System.out.println("\n[Remaing course(s)] : ");
		for(RegCourse i : courses){
			System.out.println("[" +i.getCourseCode() + "] - " + i.getCourseName());
		}
	}
	
	public static void addInstructor(String firstname, String lastname, int age, char gender, String code)
	{
		Instructor a = new Instructor(firstname, lastname, age, gender);
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		String ccode = code.toLowerCase();
		boolean check = false;
		teachers.add(a);
		
		for(Instructor i : teachers){
			//i.printInfo();
			if(fname.equals(i.getFirstName().toLowerCase())){
				for(RegCourse ic : courses){
					if(ccode.equals(ic.getCourseCode().toLowerCase())){
						i.setTeaching(ic);
						found = true;
						System.out.println();
						System.out.println(i.getFirstName() + " " + i.getLastName() + " teaches " + ic.getCourseName());
						break;
					}
				}
				if(found == true) {
					break;
				}
			}
			
		}
		
		System.out.println("\n[Instructor(s)] : ");
		for(Instructor i : teachers){
			i.printInfo();
		}
		
		if(found == false){
			System.out.println("This course does not exist!");
		}
	}
	
	
	public static void removeInstructor(String firstname, String lastname)
	{
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		for(Instructor i : teachers){
			if(fname.equals(i.getFirstName().toLowerCase()) && lname.equals(i.getLastName().toLowerCase())){
				teachers.remove(i);
				found = true;
				System.out.println(i.getFirstName() + " " + i.getLastName() + "is removed.");
				break;
			}
		}
		if(found == false){
			System.out.println("\nThis instructor does not exist!\n");
		}
		System.out.println("\n[Remaining instructor(s)] : ");
		for(Instructor i : teachers){
			System.out.println(i.getFirstName() + " " + i.getLastName());
		}
	}
	
	
	public static void addStudent(String firstname, String lastname, int age, char gender)
	{
		Student a = new Student(firstname, lastname, age, gender);
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		
		for(Student i : students){
			if(fname.equals(i.getFirstName().toLowerCase())){
				found = true;
				System.out.println("\n" + a.getFirstName() + " " + a.getLastName() + " has already added.");
				break;
			}
		}
		
		if(found == false){
			students.add(a);
			System.out.println("\n" + a.getFirstName() + " " + a.getLastName() + " is added.");
		}
		
		System.out.println("\n[Student(s)] : ");
		for(Student i : students){
			System.out.println(i.getFirstName() + " " + i.getLastName());
		}
		
	}
	
	
	public static void removeStudent(String firstname, String lastname)
	{
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		for(Student i : students){
			if(fname.equals(i.getFirstName().toLowerCase()) && lname.equals(i.getLastName().toLowerCase())){
				students.remove(i);
				found = true;
				System.out.println(i.getFirstName() + " " + i.getLastName() + "is removed.");
				break;
			}
		}
		if(found == false){
			System.out.println("\nThis student does not exist!\n");
		}
		System.out.println("\n[Remaining student(s)] : ");
		for(Student i : students){
			System.out.println(i.getFirstName() + " " + i.getLastName());
		}
	}
	
	//If instructor's info has already added, it will return true.
	public static boolean instructorAccess(String firstname, String lastname)
	{
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		for(Instructor i : teachers){
			//Instructor's info has already added in the system 
			if(fname.equals(i.getFirstName().toLowerCase()) && lname.equals(i.getLastName().toLowerCase())){
				//System.out.println(i.getFirstName() + " " + i.getLastName() + " has already added.");
				return true;
			}
		}
		
		return false;
	}
	
	//If student's info has already added, it will return true.
	public static boolean studentAccess(String firstname, String lastname)
	{
		String fname = firstname.toLowerCase();
		String lname = lastname.toLowerCase();
		for(Student i : students){
			//Student's info has already added in the system 
			if(fname.equals(i.getFirstName().toLowerCase()) && lname.equals(i.getLastName().toLowerCase())){
				//System.out.println(i.getFirstName() + " " + i.getLastName() + " has already added.");
				return true;
			}
		}
		return false;
	}
	
	//If course info has already added, it will return true.
	public static boolean courseAccess(String code)
	{
		String ccode = code.toLowerCase();
		for(RegCourse i : courses){
			//has course info in system
			if(ccode.equals(i.getCourseCode().toLowerCase())){
				//System.out.println(i.getCourseCode() + " is found.");
				return true;
			}
		}
		return false;
	}

	
	public static void setCourseGrading(String code){
		int attPercent = 0;
		int quizPercent = 0;
		int projPercent = 0;
		int midPercent = 0;
		int fiPercent = 0;
		
		for(RegCourse i : courses){
			if(code.toLowerCase().equals(i.getCourseCode().toLowerCase())){
				System.out.print("Input attendance percent : ");
				attPercent = inNum.nextInt();
				System.out.print("Input quiz percent : ");
				quizPercent = inNum.nextInt();
				System.out.print("Input project percent : ");
				projPercent = inNum.nextInt();
				System.out.print("Input midterm percent : ");
				midPercent = inNum.nextInt();
				System.out.print("Input final percent : ");
				fiPercent = inNum.nextInt();
				
				i.setCourseGrading(attPercent, quizPercent, projPercent, midPercent, fiPercent);
			}
			else{
				continue;
			}
		}
	}
	
	
	public static void setFullScore(String code){
		int attFull = 0;
		int quizFull = 0;
		int projFull = 0;
		int midFull = 0;
		int fiFull = 0;
		
		for(RegCourse i : courses){
			if(code.toLowerCase().equals(i.getCourseCode().toLowerCase())){
				System.out.print("Input attendance score : ");
				attFull = inNum.nextInt();
				System.out.print("Input quiz score : ");
				quizFull = inNum.nextInt();
				System.out.print("Input project score : ");
				projFull = inNum.nextInt();
				System.out.print("Input midterm score : ");
				midFull = inNum.nextInt();
				System.out.print("Input final score : ");
				fiFull = inNum.nextInt();
				
				i.setFull_score_attendance(attFull);
				i.setFull_score_quiz(quizFull);
				i.setFull_score_projects(projFull);
				i.setFull_score_midScore(midFull);
				i.setFull_score_finalScore(fiFull);
				break;
			}
			else{
				System.out.println("\nCourse is not found");
				break;
			}
		}
	}
	
	public static void updateCourse(String code){
		for(RegCourse i : courses){
			if(code.toLowerCase().equals(i.getCourseCode().toLowerCase())){
				found = true;
				System.out.println("\nSelect topic for update");
				System.out.println(" (1) courseCode");
				System.out.println(" (2) courseName");
				System.out.println(" (3) coreCourse");
				System.out.println(" (4) courseCredit");
				System.out.println(" (5) courseGrading");
				System.out.println(" (6) Back\n");
				System.out.print("Enter number : ");
				String q = in.next();
				if(q.equals("1")){
					System.out.print("Update courseCode to : ");
					String courseCode = inLine.nextLine();
					i.setCourseCode(courseCode);
					break;
				} else if (q.equals("2")){
					System.out.print("Update courseName to : ");
					String courseName = inLine.nextLine();
					i.setCourseName(courseName);
					break;
				} else if (q.equals("3")){
					boolean coreCourse = false;
					String core;
					do{
						System.out.print("Update coreCourse to ('true' or 'false') : ");
						core = in.next();
						if(core.equals("false")){
							coreCourse =false;
							break;
						}
						else if(core.equals("true")){
							coreCourse = true;
							break;
						}
					}while(!core.equals("false") || !core.equals("true"));
					i.setCoreCourse(coreCourse);
					break;
				} else if (q.equals("4")) {
					System.out.print("Update courseCredit to : ");
					int courseCredit = inNum.nextInt();
					i.setCourseCredit(courseCredit);
					break;
				} else if (q.equals("5")) {
					System.out.println("Update courseGrading ");
					setCourseGrading(code);
					break;
				} else if (q.equals("6")) {
					break;
				} else break;
			}
		}
		if(found == false){
			System.out.println("\nThis course does not exist!!\n");
		}

		System.out.println("\n[Remaing course(s)] : ");
		for(RegCourse ic : courses){
			System.out.println("[" +ic.getCourseCode() + "] - " + ic.getCourseName());
		}
		
		
	
	}
	
	public static void addScore(String firstname, String code){
		String fname = firstname.toLowerCase();
		String ccode = code.toLowerCase();
		int attScore;
		int quiScore;
		int proScore;
		int miScore;
		int fiScore;
		
		for(Student i : students){
			if(fname.equals(i.getFirstName().toLowerCase())){
				for(RegCourse c : courses){
					if(ccode.equals(c.getCourseCode().toLowerCase())){
						System.out.print("Input attendance score : ");
						attScore = inNum.nextInt();
						System.out.print("Input quiz score : ");
						quiScore = inNum.nextInt();
						System.out.print("Input project score : ");
						proScore = inNum.nextInt();
						System.out.print("Input midterm score : ");
						miScore = inNum.nextInt();
						System.out.print("Input final score : ");
						fiScore = inNum.nextInt();
						
						i.setAllScore(ccode, attScore, quiScore, proScore, miScore, fiScore);
					}
				}
			}
		}
	}
	
	private static void RegisterCourse(String firstname, String code) {
		String ccode = code.toLowerCase();
		String fname = firstname.toLowerCase();
		for(Student i : students){
			if(fname.equals(i.getFirstName().toLowerCase())){
				for(RegCourse ic : courses){
					if(ccode.equals(ic.getCourseCode().toLowerCase())){
						i.RegisterCourse(ic);
						System.out.println(i.getFirstName() + " " + i.getLastName() + " regists " + ic.getCourseCode());
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
	
		//CODE HERE
		sampleData();
		
		String roleUser;
		String choice;
		String select;
		String function = null;
		
		
		System.out.println("--------------------------------------------");
		System.out.println("             Welcome to ICT-LMS             ");
		System.out.println("--------------------------------------------");
		in = new Scanner(System.in);
		inChar = new Scanner(System.in);
		inNum = new Scanner(System.in);
		inLine = new Scanner(System.in);

		do{

			System.out.println("\n(A) Administrators \n(S) Students \n(Q) Quit");
			System.out.print("\nEnter character of choice : ");
			roleUser = in.next();
			//Adminstrator
			if(roleUser.equals("A") || roleUser.equals("a")){
				System.out.println("\n----------------Adminstrator----------------");
				do{
					System.out.println("\nSelect one of these");
					System.out.println(" (1) Add/update/remove Courses"
							+ " \n (2) Add/update/remove Instructors"
							+ " \n (3) Add/update/remove Students"
							+ " \n (4) Set grading criteria  (e.g., attendance, project, quiz, midterm, final) to the Course"
							+ " \n (5) Add score of students in each criterion to the system"
							+ " \n (6) Print information of all instructors and their teaching courses"
							+ " \n (7) Print information of all students and their registered courses"
							+ " \n (8) Back");
					System.out.print("\nEnter number of choice : ");
					choice = in.next();
					//(1) add or update or remove Courses
					if(choice.equals("1")){
						do{
							System.out.println("\nSelect one of these\n(1) Add \n(2) Update \n(3) Remove \n(4) Back");
							System.out.print("\nEnter number of choice : ");
							select = in.next();
							System.out.println();
							//(1) add Courses
							if(select.equals("1")){
								System.out.println("--------------Add--------------");
								System.out.print("Input code of course : ");
								String code = inLine.nextLine();;
								System.out.print("Input name of course : ");
								String cname = inLine.nextLine();;
								boolean check = false;
								String core;
								do{
									System.out.print("Input core of course ('true' or 'false') : ");
									core = in.next();
									if(core.equals("false")){
										check =false;
										break;
									}
									else if(core.equals("true")){
										check = true;
										break;
									}
								}while(!core.equals("false") || !core.equals("true"));
								
								System.out.print("Input credit of course : ");
								int cCredit = in.nextInt();
								
								
								addCourse(code, cname, check, cCredit);
							}
							//(2) update Courses
							else if(select.equals("2")){
								System.out.println("------------Update------------");
								String key;
								do{
									System.out.println("\nDo you want to edit or update course name?");
									System.out.println(" (1) Yes \n (2) No");
									System.out.print("Enter number of choice : ");
									key = in.next();
									if(key.equals("1")){
										System.out.print("\nInput of course code : ");
										String code = inLine.nextLine();
										for(RegCourse i : courses){
											if(code.equals(i.getCourseCode())){
												found = true;
												updateCourse(code);
												break;
											}	
										}
									}else if(key.equals("2")){
										break;
									}
								}while(!key.equals("1") || key.equals("2"));
							}
							//(3) remove Courses
							else if(select.equals("3")){
								System.out.println("------------Remove------------");
								System.out.print("Input code of course : ");
								String code = in.next();
								System.out.print("Input name of course : ");
								String cname = inLine.nextLine();
								
								removeCourse(code, cname);
							}
							//(4) Back
							else if(select.equals("4")){
								break;
							}
							else{
								continue;
							}
							
						} while(!select.equals("1")|| !select.equals("2") || !select.equals("3") || !select.equals("4"));
					}
					//(2) add or update or remove Instructors
					else if(choice.equals("2")){
						do{
							System.out.println("\nSelect one of these\n(1) Add \n(2) Update \n(3) Remove \n(4) Back");
							System.out.print("\nEnter number of choice : ");
							select = in.next();
							//(1) add Instructors
							if(select.equals("1")){
								//"Somchai", "Jaidee", 35, 'M'
								System.out.println("--------------add--------------");
								System.out.print("Input instructor's firstname : ");
								String firstname = inLine.nextLine();
								System.out.print("Input instructor's lastname : ");
								String lastname = inLine.nextLine();
								System.out.print("Input instructor's age : ");
								int age = inNum.nextInt();
								System.out.print("Input instructor's gender ('M' or 'F') : ");
								char gender = inChar.next().charAt(0);
								System.out.print("Input instructor's codeCourse : ");
								String code = in.next();
								
								addInstructor(firstname, lastname, age, gender, code);
							}
							//(2) update Instructors
							else if(select.equals("2")){
								
							}
							//(3) remove Instructors
							else if(select.equals("3")){
								while(true){
									System.out.println("-------------remove-------------");
									System.out.print("Input instructor's firstname : ");
									String firstname = inLine.nextLine();
									System.out.print("Input instructor's lastname : ");
									String lastname = inLine.nextLine();
									//If found instructor's name, can remove it
									if(instructorAccess(firstname, lastname) == true){
										removeInstructor(firstname, lastname);
										break;
									}
								}
								
							}//(4) Back
							else if(select.equals("4")){
								break;
							}
							else{
								continue;
							}
							
						} while(!select.equals("1") || !select.equals("2") || !select.equals("3") || !select.equals("4"));
						
						//Able to print information of all instructors and their teaching courses.
					}
					//(3) add or update or remove Students
					else if(choice.equals("3")){
						do{
							System.out.println("\nSelect one of these\n(1) Add \n(2) Update \n(3) Remove \n(4) Back");
							System.out.print("\nEnter number of choice : ");
							select = in.next();
							//(1) add Students
							if(select.equals("1")){
								System.out.println("--------------add--------------");
								System.out.print("Input student's firstname : ");
								String firstname = inLine.nextLine();
								System.out.print("Input student's lastname : ");
								String lastname = inLine.nextLine();
								System.out.print("Input student's age : ");
								int age = inNum.nextInt();
								char gender;
								do{
									System.out.print("Input student's gender ('M' or 'F') : ");
									gender = inChar.next().charAt(0);
									if(gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f'){
										break;
									}
								}while(gender != 'M' || gender != 'm' || gender != 'F' || gender != 'f');
								//has this student in system
								if(studentAccess(firstname, lastname) == true){
									System.out.println("\nYou have already added!");
									break;
								}
								addStudent(firstname, lastname, age, gender);
							}
							//(2) update Students
							else if(select.equals("2")){
								
							}
							//(3) remove Students
							else if(select.equals("3")){
								while(true){
									System.out.println("-------------remove-------------");
									System.out.print("Input student's firstname : ");
									String firstname = inLine.nextLine();
									System.out.print("Input student's lastname : ");
									String lastname = inLine.nextLine();
									//If found instructor's name, can remove it
									if(studentAccess(firstname, lastname) == true){
										removeStudent(firstname, lastname);
										break;
									}
									else {
										System.out.println("This student does not exist!");
										System.out.println("Input again!");
									}
								}
								
							}
							//(4) Back
							else if(select.equals("4")){
								break;
							}
							else{
								continue;
							}
							
						} while(!select.equals("1") || !select.equals("2") || !select.equals("3") || !select.equals("4"));
					}
					//(4) Set grading criteria  (e.g., attendance, project, quiz, midterm, final) to the Course
					else if(choice.equals("4")){
						System.out.print("Input code of course : ");
						String code = in.next();
						if(courseAccess(code) == true){
							System.out.println("\n-----------Set grading course------------\n");
							setCourseGrading(code);
							System.out.println("\n-------------Set Full course-------------\n");
							setFullScore(code);
						}
						else System.out.println("\nCourse is not found!!");
						
					}
					//(5) Add score of students in each criterion to the system
					else if(choice.equals("5")){
						while(true){
							System.out.print("Input student's firstname : ");
							String firstname = inLine.nextLine();
							System.out.print("Input student's lastname : ");
							String lastname = inLine.nextLine();
							if(studentAccess(firstname, lastname) == true){
								System.out.print("Input code of course which you want to add score : ");
								String code = inLine.nextLine();
								if(courseAccess(code) == true){
									addScore(firstname, code);
									break;
								}
								else System.out.println("Course's code is not found!!");
							}
							else System.out.println("Student's name is not found!!");
						}
					}
					//(6) Print information of all instructors and their teaching courses
					else if(choice.equals("6")){
						System.out.println("----------information-------------");
						System.out.println("\n[Instructor(s)] : ");
						for(Instructor i : teachers){
							i.printInfo();
						}
						
					}
					//(7) Print information of all students and their registered courses
					else if(choice.equals("7")){
						
					}
					//(8) Back
					else if(choice.equals("8")){
						break;
					}
					else{
						continue;
					}
				//End Administrator	
				}while(!choice.equals("1")|| !choice.equals("2") || !choice.equals("3") || !choice.equals("4") || !choice.equals("5")|| !choice.equals("6") || !choice.equals("7") || !choice.equals("8"));
			}
			else if(roleUser.equals("S") || roleUser.equals("s")){
				
				while(true){
					System.out.println("\n------------------Student-------------------");
					System.out.print("Input student's firstname : ");
					String firstname = inLine.nextLine();
					System.out.print("Input student's lastname : ");
					String lastname = inLine.nextLine();
					String fname = firstname.toLowerCase();
					String lname = lastname.toLowerCase();
					//If student's name has already added, it will return false.
					if(studentAccess(firstname, lastname) == true){
						System.out.println("\nCan access!!\n");
						do{
							/*
							 * For Students, They can do the following tasks
							 *  - Able to register to the existing courses (add by administrator).
							 *  - Able to see the accumulated GPA (only the subject that they have completed).
							 *  - Able to evaluate the score that a student need to do to get  ‘A’ for a particular subject (only work with subject that they haven’t completed).
							 *  - Able to illustrate subject that a student is likely have a problem with (only work with subject that they haven’t completed).
							 *  - Able to search names of the instructors who teach in the registered courses.
							 */
							System.out.println("\nSelect one of these\n(1) Register courses \n(2) See the accumulated GPA "
									+ "\n(3) Evaluate the score \n(4) Illustrate subject "
									+ "\n(5) Search names of the instructors \n(6) Back");
							
							function = in.next();
							
							//(1) Able to register to the existing courses (add by administrator).
							if(function.equals("1")){
								System.out.println("-----------Register Courses----------");
								System.out.print("Input courseCode : ");
								String a = in.next(); 
								RegisterCourse(firstname, a);
							}
							//(2) Able to see the accumulated GPA (only the subject that they have completed).
							else if(function.equals("2")){
								System.out.print("Input courseCode : ");
								String code = in.next(); 
								String ccode = code.toLowerCase();
								
								for(Student i : students){
									if(fname.equals(i.getFirstName())){
										for(RegCourse c : courses){
											if(ccode.equals(c.getCourseCode())){
												System.out.println(c.getAccumScore());
											}
										}
									}
								}
							}
							//(3) Able to evaluate the score that a student need to do to get  ‘A’ for a particular subject (only work with subject that they haven’t completed).
							else if(function.equals("3")){
								System.out.print("Input courseCode : ");
								String code = in.next(); 
								String ccode = code.toLowerCase();
								
								for(Student i : students){
									if(fname.equals(i.getFirstName())){
										for(RegCourse c : courses){
											if(ccode.equals(c.getCourseCode())){
												i.howToGetASubject(ccode);
											}
										}
									}
								}
							}
							//(4) Able to illustrate subject that a student is likely have a problem with (only work with subject that they haven’t completed).
							else if(function.equals("4")){
								
								for(Student i : students){
									if(fname.equals(i.getFirstName())){
										for(RegCourse c : courses){
											i.severeSubject();
										}
									}
								}
							}
							//(5) Able to search names of the instructors who teach in the registered courses.
							else if(function.equals("5")){
								System.out.print("Input courseCode : ");
								String code = in.next(); 
								String ccode = code.toLowerCase();
								
								for(Student i : students){
									if(fname.equals(i.getFirstName())){
										for(RegCourse c : courses){
											i.relevantInstructor(teachers);
										}
									}
								}
							}
							//(6) Back
							else if(function.equals("6")){
								break;
							}
							else{
								continue;
							}
						}while(!function.equals("1") || !function.equals("2") || !function.equals("3") || !function.equals("4") || !function.equals("5") || !function.equals("6"));
					}
					//If system information has not these student login, it will go back to the system.
					else if(studentAccess(firstname, lastname) == false){
						System.out.println("\nIncorrect name or empty info");
						System.out.println("Cannot access!!\n");
						break;
					}
				}
								
			}
			//(Q) Quit
			else if(roleUser.equals("Q") || roleUser.equals("q")){
				break;
			}
			else{
				continue;
			}
		}while(!roleUser.equals("A") || !roleUser.equals("S") || !roleUser.equals("Q") || !roleUser.equals("a") || !roleUser.equals("s") || !roleUser.equals("q"));
		clear();
	}
	

	public static void sampleData(){
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
		
		RegCourse a = new RegCourse("1","a", true, 3);
		courses.add(a);
		
		
		courses.add(funProgramming);
		courses.add(OOP);
		courses.add(digitalSystem);
		courses.add(eng2);
		
		RegCourse b = new RegCourse("2","b", true, 3);
		courses.add(b);
		
		
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
		
		Instructor pat = new Instructor("Pat", "Kiat", 19, 'F');
		//Assign teaching courses
		pat.setTeaching(a);
		
		Instructor kap = new Instructor("Kop", "Kap", 19, 'M');
		//Assign teaching courses
		kap.setTeaching(b);
		
		teachers.add(somchai);
		teachers.add(somsri);
		teachers.add(somjai);
		
		listINS.add(somchai);
		listINS.add(somsri);
		listINS.add(somjai);
		// ADD Student(1)
		Student peter = new Student("Peter", "Parker", 21, 'M');
		//a student registers to courses
		peter.RegisterCourse(funProgramming);
		peter.RegisterCourse(OOP);
		peter.RegisterCourse(digitalSystem);
		
		//Set raw score for each subjects
		peter.setAllScore("ITCS208", 100, 12, 75, 45, 60);
		peter.setAllScore("ITCS200", 100, 15, 80, 50, 75);
		peter.setAllScore("ITCS211", 40, 0, 0, 10, -1);
		
		System.out.print("\n ---------------------\n");
		
		// ADD Student(2)
		Student sarah = new Student("Sarah", "Josh", 20, 'F');
		//a student registers to courses
		sarah.RegisterCourse(funProgramming);
		sarah.RegisterCourse(OOP);
		sarah.RegisterCourse(digitalSystem);
		sarah.RegisterCourse(eng2);

		//Set RAW score for each subjects
		sarah.setAllScore("ITCS200", 100, 17, 85, 63, 60);
		sarah.setAllScore("ITCS208", 100, 18, 82, 60, 72);
		sarah.setAllScore("ITCS211", 100, 0, 0, 25, -1);
		sarah.setAllScore("ITLG201", 100, 0, 30, 23, -1);
		

		students.add(peter);
		students.add(sarah);
		
}
	public static void clear(){
		try {
			if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			for(int i = 0; i < 1000; i++) {
				System.out.println();
			}
		}
	}

}
