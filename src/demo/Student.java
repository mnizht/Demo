package demo;

import java.util.Date;

public class Student {

	private int id;
	private String name;
	private int age;
	private double score;
	private Date enterDate;

	public Student() {
	}

	public Student(int id, String name, int age, double score, Date enterDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.enterDate = enterDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

}
