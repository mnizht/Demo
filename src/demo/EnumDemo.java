package demo;

public class EnumDemo {
	public static void main(String[] args) {

		Day day = Day.WEDNESDAY;
		System.out.println(day);
		System.out.println(Day.values());

		boolean m = true;
		if (m = false) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}

	}

	enum Day2 {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

}