/*
For a given JSON format(see attached students-teachers.json below), define a Java class. 
Then write a program to parse that JSON string and create the corresponding Java object with 
the values filled from the JSON string.
*/
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.*;
import java.util.*;


class Teacher{
    public String name, id, dateOfJoining;
    public ArrayList<String> classesToTeach;
    public int salary;
    Teacher(String name, String id, String dateOfJoining, int salary, ArrayList<String> classesToTeach){
        this.name = name;
        this.id =id;
        this.salary = salary;
        this.classesToTeach = classesToTeach;
    }
};

class Marks{
    public int mark;
    public String subjectName;
    Marks(int mark, String subjectName){
        this.mark = mark;
        this.subjectName = subjectName;
    }
};

class Student{
    public String name,id,dateOfJoining,std;
    public ArrayList<Marks> markList;
    Student(String name,String id,String dateOfJoining,String std,ArrayList<Marks> markList){
        this.name = name;
        this.id = id;
        this.dateOfJoining = dateOfJoining;
        this.std = std;
        this.markList = markList;
    }
};

public class TeacherStudent{
    public Teacher teacher;
    public Student student;

    TeacherStudent(Teacher teacher, Student student){
        this.teacher = teacher;
        this.student = student;
    }

    //Function reads the input file into a string
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws ParseException{

        JSONParser parser = new JSONParser();
        String jsonData = readFile(args[0]);
        Object fullObj = parser.parse(jsonData);
        JSONObject fulljson = (JSONObject) fullObj;

        //Parsing for teacher information
        JSONObject teacherjson = (JSONObject) fulljson.get("Teacher");
        ArrayList<String> classesList = new ArrayList<String>();
        String teacherName = (String) teacherjson.get("Name");
        String teacherId = (String) teacherjson.get("ID");
        int teacherSalary = (int)(long) teacherjson.get("Salary");
        String teacherDateOfJoining = (String) teacherjson.get("Date Of Joining");
        JSONArray teacherClassesToTeachjson = (JSONArray) teacherjson.get("Classes Taking Care Of");
        Iterator<String> iterator = teacherClassesToTeachjson.iterator();    
        while(iterator.hasNext()){
            classesList.add(iterator.next());
        }
        Teacher teacher = new Teacher(teacherName, teacherId, teacherDateOfJoining, teacherSalary, classesList);


        //Parsing for student information
        JSONObject studentjson = (JSONObject) fulljson.get("Student");
        String studentId = (String) studentjson.get("ID");
        String studentName = (String) studentjson.get("Name");
        String studentDateOfJoining = (String) studentjson.get("Date Of Joining");
        String studentStd = (String) studentjson.get("Std");
        JSONArray marksList = (JSONArray) studentjson.get("Marks");
        Iterator<JSONObject>marks_iterator = marksList.iterator();
        ArrayList<Marks> studentMarksList = new ArrayList<Marks>();
        while(marks_iterator.hasNext()){
            JSONObject marksObject = marks_iterator.next();
            int marks = (int)(long) marksObject.get("Mark");
            String subject = (String) marksObject.get("Subject");
            studentMarksList.add(new Marks(marks, subject));
        }
        Student student = new Student(studentName, studentId, studentDateOfJoining, studentStd, studentMarksList);

        TeacherStudent ts = new TeacherStudent(teacher, student); 

    }
}