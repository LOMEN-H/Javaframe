package exp1.model.entity;

public class Student {
	private int id;
	private String name;
	private String gender;
	private String major;
	private String grade;
	
	public Student() {};
	public Student(int id,String name,String gender,String major,String grade) {
		
		setId(id);
		setName(name);
		setGender(gender);
		setMajor(major);
		setGrade(grade);

	};
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
