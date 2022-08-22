package entities;

import java.util.ArrayList;
import java.util.List;

import controller.CourseController;

public class Apprentice extends People {
	
	private int experience;
	private List<Course> courses = new ArrayList<>();

	public Apprentice(String name, String email, String phone, String password, int experience, List<Course> courses) {
		super(name, email, phone, password);
		this.experience = experience;
		
		/*Para deixar dados ficticios prontos*/
		this.courses = courses;
	}

	public int getExperience() {
		return experience;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public void finishCourse(int numberCourse) {
		if(CourseController.setFinishedCourse(courses, numberCourse)) {
			experience += 30;
			System.out.println("Você recebeu +30 de XP!");
		}
	}
	
	public List<Course> getFinishedCourses(){
		List<Course> finished = CourseController.getFinishedCourses(courses);
		return finished;
	}
	
	public List<Course> getInProgressCourses(){
		List<Course> inProgress = CourseController.getInProgressCourses(courses);
		return inProgress;
	}
	
	public List<Course> getNotStartedCourses(){
		List<Course> notStarted = CourseController.getNotStartedCourses(courses);
		return notStarted;
	}

	@Override
	public String toString() {
		return "\nNome: " + getName() +
				"\nEmail: " + getEmail() +
				"\nTelefone: " + getPhone() +
				"\nXP: " + getExperience();
	}

}
