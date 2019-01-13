package sec01_exam;

public class Student {
	
	// 자바에서는 class를 만드는 것이지만, jsp에서는 bean을 만들었다고 한다.

	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	//기본 생성자
	public Student() {
		
	}
	
	// Getter & Setter 생성
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getStudentNum() {
		return studentNum;
	}
	
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
	
}
