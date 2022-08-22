package utils;

import java.util.List;

import entities.People;

public class Util {
	
	public static boolean findEmail(List<? extends People> people, String email) {
		
		for(int i = 0; i < people.size(); i++) {
			if(people.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}

	public static People getPeople(List<? extends People> people, String email) {
		for(int i = 0; i < people.size(); i++) {
			if(people.get(i).getEmail().equals(email)) {
				return people.get(i);
			}
		}
		
		return null;
	}
	
}
