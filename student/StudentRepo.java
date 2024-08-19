package com.josh.gradingsystem.student;

import com.josh.gradingsystem.DBConnectivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {


    public static int insert(Student student){
        DBConnectivity connectNow = new DBConnectivity();
        Connection connectDB = connectNow.getConnection();


        String query = "INSERT INTO student(studentId, firstName, lastName, gender, program, institutionEmail, faculty, level, year, assignment, midsem, examination, totalScore, grade, semesterExams, contact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        int result = 0;
        try{
            PreparedStatement ps = connectDB.prepareStatement(query);
            ps.setString(1, student.getStudentId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getProgram());
            ps.setString(6, student.getInstitutionEmail());
            ps.setString(7, student.getFaculty());
            ps.setString(8, student.getLevel());
            ps.setString(9, student.getYear());
            ps.setDouble(10, student.getAssignment());
            ps.setDouble(11, student.getMidsem());
            ps.setDouble(12, student.getExamination());
            ps.setDouble(13, student.getTotalScore());
            ps.setString(14, student.getGrade());
            ps.setString(15, student.getSemesterExams());
            ps.setString(16, student.getContact());

            result = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static ObservableList<Student> getStudents(){
        DBConnectivity connectNow = new DBConnectivity();
        Connection connectDB = connectNow.getConnection();

        ObservableList<Student> students = FXCollections.observableArrayList();
        try{
            String query = "SELECT * FROM student;";
            PreparedStatement ps = connectDB.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
                while(resultSet.next()){
                    Student student = new Student();
                    student.setStudentId(resultSet.getString("studentId"));
                    student.setFirstName(resultSet.getString("firstName"));
                    student.setLastName(resultSet.getString("lastName"));
                    student.setProgram(resultSet.getString("program"));
                    student.setLevel(resultSet.getString("level"));
                    student.setYear(resultSet.getString("year"));
                    student.setAssignment(resultSet.getDouble("assignment"));
                    student.setMidsem(resultSet.getDouble("midsem"));
                    student.setExamination(resultSet.getDouble("examination"));
                    student.setTotalScore(resultSet.getDouble("totalScore"));
                    student.setGrade(resultSet.getString("grade"));
                    student.setSemesterExams(resultSet.getString("semesterExams"));

                    students.add(student);

                }


        }catch ( Exception e){
            System.out.println(e.getMessage());
        }

        return students;
    }

}
