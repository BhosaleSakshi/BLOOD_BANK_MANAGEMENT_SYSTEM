package i1.logic;

public class Receiver {

	private String name = null;
	private int age = 0;
	private String bloodgrup = null;

	public Receiver(String name, int age, String bloodgrup) {
		this.name = name;
		this.age = age;
		this.bloodgrup = bloodgrup;
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

	public String getBloodgrup() {
		return bloodgrup;
	}

	public void setBloodgrup(String bloodgrup) {
		this.bloodgrup = bloodgrup;
	}

}
