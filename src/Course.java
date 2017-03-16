/** Name: Pattararat Kiattipadungkul
 * StudentID: 5988068
 * Section: 1
 */

public class Course {
		//Basic Course Information
		private String courseCode;
		private String courseName;
		private int courseCredit;
		private boolean coreCourse;
		
		//Grading Criteria (Percentage)
		private int attendancePercent;
		private int quizPercent;
		private int projPercent;
		private int midtermPercent;
		private int finalPercent;
		
		//Full score of each criteria
		private double full_score_attendance;
		private double full_score_quiz;
		private double full_score_projects;
		private double full_score_midScore;
		private double full_score_finalScore;
		
		Course(String code, String cname, boolean core, int cCredit){
			courseCode = code;
			courseName = cname;
			coreCourse  = core;
			courseCredit = cCredit;

			this.attendancePercent = 0;	
			this.quizPercent = 0;			
			this.projPercent = 0;		
			this.midtermPercent = 0;
			this.finalPercent = 0;

			this.full_score_attendance = 0;			
			this.full_score_quiz = 0;
			this.full_score_projects = 0;
			this.full_score_midScore = 0;
			this.full_score_finalScore = 0;
		}

		public String getCourseCode() {
			return courseCode;
		}

		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public boolean isCoreCourse() {
			return coreCourse;
		}

		public void setCoreCourse(boolean coreCourse) {
			this.coreCourse = coreCourse;
		}
		public int getMidtermPercent() {
			return midtermPercent;
		}

		public int getAttendancePercent() {
			return attendancePercent;
		}

		public int getFinalPercent() {
			return finalPercent;
		}

		public int getProjPercent() {
			return projPercent;
		}

		public int getQuizPercent() {
			return quizPercent;
		}
		
		public int getCourseCredit() {
			return courseCredit;
		}

		public void setCourseCredit(int courseCredit) {
			this.courseCredit = courseCredit;
		}

		public double getFull_score_attendance() {
			return full_score_attendance;
		}

		public void setFull_score_attendance(double full_score_attendance) {
			this.full_score_attendance = full_score_attendance;
		}

		public double getFull_score_quiz() {
			return full_score_quiz;
		}

		public void setFull_score_quiz(double full_score_quiz) {
			this.full_score_quiz = full_score_quiz;
		}

		public double getFull_score_projects() {
			return full_score_projects;
		}

		public void setFull_score_projects(double full_score_projects) {
			this.full_score_projects = full_score_projects;
		}

		public double getFull_score_midScore() {
			return full_score_midScore;
		}

		public void setFull_score_midScore(double full_score_midScore) {
			this.full_score_midScore = full_score_midScore;
		}

		public double getFull_score_finalScore() {
			return full_score_finalScore;
		}

		public void setFull_score_finalScore(double full_score_finalScore) {
			this.full_score_finalScore = full_score_finalScore;
		}

		//Set grading criteria
		public void setCourseGrading(int attendancePercent, int quizPercent, int projPercent, int midtermPercent, int finalPercent) {
			this.attendancePercent = attendancePercent;
			this.quizPercent = quizPercent;
			this.projPercent = projPercent;
			this.midtermPercent = midtermPercent;
			this.finalPercent = finalPercent;
		}
		
		//Set full-score of each criteria
		public void setFullScore(double full_score_attendance, double full_score_quiz, double full_score_projects, double full_score_midScore, double full_score_finalScore) {
			this.full_score_attendance = full_score_attendance;
			this.full_score_quiz = full_score_quiz;
			this.full_score_projects = full_score_projects;
			this.full_score_midScore = full_score_midScore;
			this.full_score_finalScore = full_score_finalScore;
		}
}


