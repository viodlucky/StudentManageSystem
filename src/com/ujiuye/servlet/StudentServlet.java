package com.ujiuye.servlet;

import com.ujiuye.entity.Student;
import com.ujiuye.service.StudentService;
import com.ujiuye.service.impl.StudentServiceImpl;
import com.ujiuye.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet {
    StudentService studentService = new StudentServiceImpl();

    protected void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("studentList",list);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }

    protected void getStudentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int countRows = studentService.getCountRows();
        PageUtil pageUtil = new PageUtil(page,countRows);
        List<Student> list = studentService.getStudentByPage(pageUtil);
        request.setAttribute("studentList",list);
        request.setAttribute("pageUtil",pageUtil);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }

    protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt((request.getParameter("sage")));
        String ssex = request.getParameter("ssex");
        String semail = request.getParameter("semail");
        Part part = request.getPart("sphoto");
        String sphoto = UUID.randomUUID() + part.getSubmittedFileName();
        String path = "E:\\code\\Java2\\school\\student";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        part.write(path + "/" +sphoto);
        Student student = new Student(0,sname,sage,ssex,semail,sphoto);
        boolean res = studentService.insert(student);
        if (res){
            response.sendRedirect("studentServlet?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("添加失败，请稍后再试");
            out.close();
        }
    }

    protected void deleteStudentBySid (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        boolean res = studentService.deleteStudentBySid(sid);
        if (res){
            response.sendRedirect("studentServlet?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("删除失败，请稍后再试");
            out.close();
        }
    }

    protected void deleteAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sids = request.getParameter("sids");
        boolean res = studentService.deleteAll(sids);
        if (res){
            response.sendRedirect("studentServlet?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("删除失败，请稍后再试");
            out.close();
        }
    }

    protected void getStudentBySid (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        Student student = studentService.getStudentBySid(sid);
        request.setAttribute("student",student);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    protected void update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        String semail = request.getParameter("semail");
        Part part = request.getPart("sphoto");
        String sphoto = "";
        String fileName = part.getSubmittedFileName();
        if ("".equals(fileName)){
            sphoto = request.getParameter("oldSphoto");
        }else {
            sphoto = UUID.randomUUID()+fileName;
            String path = "E:\\code\\Java2\\school\\student";
            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            part.write(path + "/" + sphoto);
        }
        Student student = new Student(sid,sname,sage,ssex,semail,sphoto);
        boolean res = studentService.update(student);
        if (res){
            response.sendRedirect("studentServlet?flag=getStudentByPage&page=1");
        }else {
            PrintWriter out = response.getWriter();
            out.print("修改失败，请稍后再试");
            out.close();
        }
    }

    protected void getStudentBySname (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        String page = request.getParameter("page");
        int countRows = studentService.getCountRowsBySname(sname);
        PageUtil pageUtil = new PageUtil(page,countRows);
        List<Student> list = studentService.getStudentBySname(sname,pageUtil);
        request.setAttribute("sname",sname);
        request.setAttribute("pageUtil",pageUtil);
        request.setAttribute("studentList",list);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }

}
