package sec01_exam;

public class Student {
	
	// �ڹٿ����� class�� ����� ��������, jsp������ bean�� ������ٰ� �Ѵ�.

	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	//�⺻ ������
	public Student() {
		
	}
	
	// Getter & Setter ����
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
