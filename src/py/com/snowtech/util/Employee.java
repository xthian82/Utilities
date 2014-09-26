package py.com.snowtech.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Emp")
public class Employee {
	private int id;
    private String gender;
    private int age;
    private String name;
    private String role;
    private Schedule schedule;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", gender=" + gender + ", age=" + age
				+ ", name=" + name + ", role=" + role + ", sch=" + schedule + "]";
	}
}

class Schedule {
	private int days;
	private int hours;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "Schedule [days=" + days + ", hours=" + hours + "]";
	}
	
}
