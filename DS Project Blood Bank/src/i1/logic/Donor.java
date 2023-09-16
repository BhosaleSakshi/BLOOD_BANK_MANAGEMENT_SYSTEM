package i1.logic;

public class Donor {
	private String name;
	private double hb;
	private String bloodgrp;
	private Long phoneno;
	int testStatus = 0;

	public Donor(String name, double hb, String bloodgrp, Long phoneno, int status) {
		super();
		this.name = name;
		this.hb = hb;
		this.bloodgrp = bloodgrp;
		this.phoneno = phoneno;
		this.testStatus = status;
	}

	public void displayTestInfo() {
		System.out.println("\nTest Information of Donar : " + this.name);
		System.out.println("Hemoglobin Level : " + this.hb);
		System.out.println("Blood Group      : " + this.bloodgrp);
	}

	public void displayDonarInfo() {
		System.out.println("\nDonar's Name : " + this.name);
		System.out.println("Blood Group  : " + this.bloodgrp);
	}

	public Donor(String name, Long phoneno) {
		super();
		this.name = name;
		this.phoneno = phoneno;
	}

	public int getStatus() {
		return testStatus;
	}

	public void setStatus(int status) {
		this.testStatus = status;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHb() {
		return hb;
	}

	public void setHb(double hb) {
		this.hb = hb;
	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public int getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}

	public void DisplayDetails() {
		System.out.println("Name : " + name);
		System.out.println("Hemoglobin : " + hb);
		System.out.println("Blood Group : " + bloodgrp);
		System.out.println("Phone No. : " + phoneno);
	}

}
