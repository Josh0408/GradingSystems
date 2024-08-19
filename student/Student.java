package com.josh.gradingsystem.student;

public class Student {

    private int id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String program;
    private String gender;
    private String contact;
    private String institutionEmail;
    private String faculty;
    private String semesterExams;
    private String grade;
    private String year;
    private String level;
    private double assignment;
    private double examination;
    private double midsem;
    private double totalScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInstitutionEmail() {
        return institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemesterExams() {
        return semesterExams;
    }

    public void setSemesterExams(String semesterExams) {
        this.semesterExams = semesterExams;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getExamination() {
        return examination;
    }

    public void setExamination(double examination) {
        this.examination = examination;
    }

    public double getMidsem() {
        return midsem;
    }

    public void setMidsem(double midsem) {
        this.midsem = midsem;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }


    @Override
    public String toString() {
        return STR."Student{id=\{id}, studentId='\{studentId}\{'\''}, firstName='\{firstName}\{'\''}, lastName='\{lastName}\{'\''}, program='\{program}\{'\''}, gender='\{gender}\{'\''}, contact='\{contact}\{'\''}, institutionEmail='\{institutionEmail}\{'\''}, faculty='\{faculty}\{'\''}, semesterExams='\{semesterExams}\{'\''}, grade='\{grade}\{'\''}, year='\{year}\{'\''}, level='\{level}\{'\''}, assignment=\{assignment}, examination=\{examination}, midsem=\{midsem}, totalScore=\{totalScore}\{'}'}";
    }
}
