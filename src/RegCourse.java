/** Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */

/* RegCourse is a class that collect information about registered course of each student.
 * This class extends from the class Course which contain basic course information
 * that are courseCode, courseName, courseCredit, Percentage of grading criteria
 * and Full score of each criteria.
 * 
 * The RegCourse need to collect more specific information about the scores of each student regarding
 * the grading criteria which are quiz, attendance, projects, midScore, finalScore. The detail of these information
 * are provided below.
 * */
public class RegCourse extends Course {
	
	private double quiz;
	private double attendance;
	private double projects;
	private double midScore;
	private double finalScore;
	
	private double accumScore;
	private boolean completedCourse;
	
	//Constructor to setup an object of a registered course
	RegCourse(String code, String cname, boolean core, int cCredit){
		//CODE HERE
		super(code,cname,core,cCredit);

	}
	
	//Other relevant methods should be defined here
	public double getQuiz() {
		return quiz;
	}

	public void setQuiz(double quiz) {
		this.quiz = quiz;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}

	public double getProjects() {
		return projects;
	}

	public void setProjects(double projects) {
		this.projects = projects;
	}

	public double getMidScore() {
		return midScore;
	}

	public void setMidScore(double midScore) {
		this.midScore = midScore;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
	
	public boolean completedCourse() {
		if(attendance == -1 || quiz == -1 || projects == -1 || midScore == -1 || finalScore == -1){
			return false;
		}
		return true;
	}

	//quiz, attendance, projects, midScore, finalScore
	public double getAccumScore() {

		//if score =-1 no compute this score
		if(getAttendance() == -1){
			attendance = 0;
		}
		if(getQuiz() == -1){
			quiz = 0;
		}
		if(getProjects() == -1){
			projects = 0;
		}
		if(getMidScore() == -1){
			midScore = 0;
		}
		if(getFinalScore() == -1){
			finalScore = 0;
		}
		
		double getAttMe = attendance*super.getAttendancePercent()/getFull_score_attendance();
		double getQuizMe = quiz*super.getQuizPercent()/getFull_score_quiz();
		double getProjMe = projects*super.getProjPercent()/getFull_score_projects();
		double getMidMe = midScore*super.getMidtermPercent()/getFull_score_midScore();
		double getFinalMe = finalScore*super.getFinalPercent()/getFull_score_finalScore();
		
		if(getFull_score_attendance() == 0){
			getAttMe = 0;
		}
		if(getFull_score_quiz() == 0){
			getQuizMe = 0;
		}
		if(getFull_score_projects() == 0){
			getProjMe = 0;
		}
		if(getFull_score_midScore() == 0){
			getMidMe = 0;
		}
		if(getFull_score_finalScore() == 0){
			getFinalMe = 0;
		}
		accumScore = getAttMe + getQuizMe + getProjMe +getMidMe + getFinalMe; 
		return accumScore;
	}

	public void setAccumScore(double accumScore) {
		this.accumScore = accumScore;
	}
	
	//Printing Course Information 
	public void printCourseInfo(){
		//CODE HERE
		System.out.println("[Registered courses]");
		System.out.println(getCourseCode() + " - " + getCourseName());
	}

	
	
	
}
