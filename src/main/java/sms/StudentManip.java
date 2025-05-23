package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManip {
	//mysql info 
		private String jdbcURL = "jdbc:mysql://localhost:3306/school";
		private String jdbcUsername = "user";
		private String jdbcPassword = "root";
	//sql commands	
		private static final String INSERT = "INSERT INTO school (first_name, last_name, gender, email, dob, course) VALUES (?, ?, ?, ?, ?, ?)";
	    private static final String SELECT_ALL = "SELECT s.id, s.first_name, s.last_name, s.gender, s.email, s.dob, s.course, sub.subject_name, m.marks FROM school s JOIN marks m ON s.student_id = m.student_id JOIN subjects sub ON m.subject_id = sub.subject_id;";
	    private static final String SELECT_BY_ID = "SELECT s.id, s.first_name, s.last_name, s.gender, s.email, s.dob, s.course, sub.subject_name, m.marks FROM school s JOIN marks m ON s.id = m.student_id JOIN subjects sub ON m.subject_id = sub.subject_id WHERE s.id=?";
	    private static final String UPDATE_INFO = "UPDATE school SET first_name=?, last_name = ?, gender = ?, email=?, dob = ?, course=? WHERE id=?";
	    private static final String UPDATE_MARKS = "UPDATE marks SET subject_id = ?, marks = ? WHERE student_id = ?;";
	    private static final String DELETE_BY_ID = "DELETE FROM school WHERE id=?";
	    private static final String ADD_COURSE = "INSERT INTO coursetaken (id, subject_id) VALUES (?,?);";
	    private static final String ADD_SUBJECT = "INSERT INTO subjects (subject_id, subject_name) VALUES (?,?);";
	 //jdbc connection
	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    }
	  //functionalities
	    public void insertStudent (Student student) throws SQLException {
	    	 try (Connection conn = getConnection(); 
	    		  PreparedStatement stmt = conn.prepareStatement(INSERT)) {
	             stmt.setString(1, student.getFirst_name());
	             stmt.setString(2, student.getLast_name());
	             stmt.setString(3, String.valueOf(student.getGender()));
	             stmt.setString(4, student.getEmail());
	             stmt.setDate(5, java.sql.Date.valueOf(student.getDob()));
	             stmt.setString(6, student.getCourse());
	             stmt.executeUpdate();
	         }
	    }
	    public List<Student> getStudents() throws SQLException{
	    	List<Student> students = new ArrayList<>();
	    	try (Connection conn = getConnection();
	    		 PreparedStatement stmt = conn.prepareStatement(SELECT_ALL)) {
	             ResultSet rs = stmt.executeQuery();
	             while (rs.next()) {
	                 students.add(new Student(rs.getInt("id"), rs.getString("first_name"),
	                rs.getString("last_name"),rs.getString("gender").charAt(0), rs.getString("email"), 
	                rs.getDate("dob").toLocalDate(), rs.getString("course")));
	             }
	             return students;
	    	}
	    }
	    public Student getStudentById(int id) throws SQLException {
	        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Student(rs.getInt("id"), rs.getString("first_name"),
	    	                rs.getString("last_name"),rs.getString("gender").charAt(0), rs.getString("email"), 
	    	                rs.getDate("dob").toLocalDate(), rs.getString("course"));
	            }
	        }
	        return null;
	    }
	    public void deleteStudent(int id) throws SQLException {
	        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        }
	    }
	    public void addCourse(int id, int subject_id) throws SQLException{
	    	try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(ADD_COURSE)) {
	            stmt.setInt(1, id);
	            stmt.setInt(2, subject_id);
	            stmt.executeUpdate();
	        }
	    }
	    public void addSubject(int subject_id, String subject_name) throws SQLException{
	    	try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(ADD_COURSE)) {
	            stmt.setInt(1, subject_id);
	            stmt.setString(2, subject_name);
	            stmt.executeUpdate();
	        }
	    }
}
