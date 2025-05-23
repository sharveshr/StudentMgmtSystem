package sms;

import java.time.LocalDate;

public class Student {
	private int id;
    private String first_name;
    private String last_name;
    private char gender;
    private String email;
    private LocalDate dob;
    private String course;
    private String login_id;
    private String password;
    private int subject_id;
    private int marks;
    private int course_id;
    private String subject_name;
	
    //constructors 
    public Student(int id, String first_name, String last_name, char gender, String email, LocalDate dob, String course) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.course = course;
    }
    
    public Student(int id, String first_name, String last_name, char gender, String email, LocalDate dob, String course, String subject_name, ) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.course = course;
    }
    //getters and setters
    public int getId() {return id;}
    
	public String getFirst_name() {return first_name;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}
	
	public String getLast_name() {return last_name;}
	public void setLast_name(String last_name) {this.last_name = last_name;}
	
	public char getGender() {return gender;}
	public void setGender(char gender) {this.gender = gender;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public LocalDate getDob() {return dob;}
	public void setDob(LocalDate dob) {this.dob = dob;}
	
	public String getCourse() {return course;}
	public void setCourse(String course) {this.course = course;}
	
	public String getLogin_id() {return login_id;}
	public void setLogin_id(String login_id) {this.login_id = login_id;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public int getSubject_id() {return subject_id;}
	public void setSubject_id(int subject_id) {this.subject_id = subject_id;}
	
	public int getMarks() {return marks;}
	public void setMarks(int marks) {this.marks = marks;}
	
	public int getCourse_id() {return course_id;}
	public void setCourse_id(int course_id) {this.course_id = course_id;}
	
	public String getSubject_name() {return subject_name;}
	public void setSubject_name(String subject_name) {this.subject_name = subject_name;}
}
