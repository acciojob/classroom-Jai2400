package com.driver;

    import org.springframework.stereotype.Repository;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;

    @Repository
public class StudentRepository {
    private static HashMap<String,Student> studentDb;
    private static HashMap<String,Teacher> teacherDb;
    private static HashMap<String, List<String>> studentTeacherDb;

    public StudentRepository() {
        this.studentDb=new HashMap<String,Student>();
        this.teacherDb=new HashMap<String,Teacher>();
        this.studentTeacherDb=new HashMap<String,List<String>>();
    }
    // Add student to db
    public static void addStudentToDb(Student student){
        studentDb.put(student.getName(), student);
    }
    // Add teacher to db
    public static void addTeacherToDb(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }
    // Add student teacher pair to db
    public static void addStudentTeacherPairToDb(String student, String teacher){
        List<String> studentsList=new ArrayList<>();
        if(studentDb.containsKey(student) && teacherDb.containsKey(teacher)){
            if(studentTeacherDb.containsKey(teacher)){
                studentsList=studentTeacherDb.get(teacher);
            }
            studentsList.add(student);
            studentTeacherDb.put(teacher,studentsList);
        }
    }
    // Get student by student name from db
    public static Student getStudentByNameFromDb(String name){
        Student student=null;
        if (studentDb.containsKey(name)){
            student=studentDb.get(name);
        }
        return student;
    }
    // Get teacher by name from DB
        public static Teacher getTeacherByNameFromDb(String name){
        Teacher teacher=null;
        if(teacherDb.containsKey(name)){
            teacher=teacherDb.get(name);
        }
        return teacher;
        }
        public static List<String> getStudentsByTeacherNameFromDb(String name) {
            List<String> studentList=new ArrayList<>();
            if(studentTeacherDb.containsKey(name)){
                studentList=studentTeacherDb.get(name);
            }
            return studentList;
        }
        //Get list of all students added from Db
        public static List<String> getAllStudentsAddedFromDb(){
        List<String>studentsList=new ArrayList<>();
        for (String student : studentDb.keySet()){
            studentsList.add(student);
        }
        return studentsList;
        }
        // Delete teacher and his student by teacher name from Db
        public static void deleteTeacherByNameFromDb(String teacherName){
        List<String> students= new ArrayList<>();
        if(studentTeacherDb.containsKey(teacherName)){
            students=studentTeacherDb.get(teacherName);
            for (String student: students){
                if(studentDb.containsKey(student)){
                    studentDb.remove(student);
                }
            }
            studentTeacherDb.remove(teacherName);
        }
        if (teacherDb.containsKey(teacherName)){
            teacherDb.remove(teacherName);
        }
        }
        //Delete all teachers from db
        public static void deleteAllTeachersFromDb(){
        teacherDb=new HashMap<>();
        for (String teacher: studentTeacherDb.keySet()){
            List<String> students = new ArrayList<>();
            for (String studentName: studentTeacherDb.get(teacher)){
                students.add(studentName);
            }
            for (String name:students){
                if(studentDb.containsKey(name)){
                    studentDb.remove(name);
                }
            }
        }
        studentTeacherDb=new HashMap<>();
        }


    }
