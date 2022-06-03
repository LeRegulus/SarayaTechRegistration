package service;

import model.Admin;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServletService {

    private static List<Student> students = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();


    static {

        admins.add(new Admin("Fatou", "12345", "main"));
        admins.add(new Admin("Abdou", "67890", "6months"));
        admins.add(new Admin("Ndiaye", "12390", "16months"));
        students.add(new Student( "Modou" , "Ndiaye", LocalDate.of(2022, 10, 25), "6 months", LocalDate.of(2022, 11, 15)));
        students.add(new Student("Moussa" , "Diop", LocalDate.of(2022, 10, 25), "16 months", LocalDate.of(2022, 11, 15)));
        students.add(new Student("Anta" , "Fall", LocalDate.of(2022, 10, 25), "6 months", LocalDate.of(2022, 11, 15)));
        students.add(new Student("Isma" , "Diakhoumpa", LocalDate.of(2022, 10, 25), "16 months", LocalDate.of(2022, 11, 15)));
    }
    public void addStudent(Student st){ students.add(st);}

    public void deleteStudent(Student st){ students.remove(st);}

    public List<Student> getStudents(){ return students; }

    public List<Student> getStudents6(){
        List<Student> st6 = new ArrayList<>();
        for (Student st: students) {
            if (st.getTrainingDuration().equals("6 months")){
                st6.add(st);
            }
        }
        return st6;
    }

    public List<Student> getStudents12(){
        List<Student> st12 = new ArrayList<>();
        for (Student st: students) {
            if (st.getTrainingDuration().equals("16 months")){
                st12.add(st);
            }
        }
        return st12;
    }
    public boolean getAdmin(String username, String password){
        for (Admin admin: admins) {
            if (username.equalsIgnoreCase(admin.getUsername()) && password.equalsIgnoreCase(admin.getPassword())){
                return true;
            }
        }
        return false;
    }

    public Student getStudent(int id){
        for (Student st: students) {
            if (st.getId() == id){
                return st;
            }
        }
        return null;
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String AdminName = (String) request.getSession().getAttribute("username");
        Admin admin = getAdmi(AdminName);
        List<Student> students;
        if (admin.getRole().equals("main")){
            students = getStudents();
        }else if (admin.getRole().equals("6months")){
            students = getStudents6();
        }else{
            students = getStudents12();
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(request, response);
    }
    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birth =  request.getParameter("dateofbirth");
        LocalDate date = LocalDate.parse(birth);
        String trainingduration = request.getParameter("training");
        Student st = new Student(firstname, lastname, date, trainingduration, LocalDate.now());
        addStudent(st);
        List<Student> students = getStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(request, response);
    }
    public void retrieveStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudent(id);
        request.setAttribute("student", student);
        List<Student> students = getStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request,response);
    }

    public Admin getAdmi(String AdminName) {
        for (Admin ad: admins) {
            if (ad.getUsername().equalsIgnoreCase(AdminName)){
                return ad;
            }
        }
        return null;
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birth =  request.getParameter("dateofbirth");
        LocalDate date = LocalDate.parse(birth);
        String trainingduration = request.getParameter("training");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudent(id);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setDateOfBirth(date);
        student.setTrainingDuration(trainingduration);
        List<Student> students = getStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("WEB-INF/views/student-list.jsp").forward(request, response);
    }
}
