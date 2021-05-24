package com.ujiuye.service;

import com.ujiuye.entity.Student;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();

    public int getCountRows();

    public List<Student> getStudentByPage(PageUtil pageUtil);

    public boolean insert(Student student);

    public boolean deleteStudentBySid(int sid);

    public boolean deleteAll(String sids);

    public Student getStudentBySid(int sid);

    public boolean update(Student student);

    public int getCountRowsBySname(String sname);

    public List<Student> getStudentBySname(String sname,PageUtil pageUtil);

}
