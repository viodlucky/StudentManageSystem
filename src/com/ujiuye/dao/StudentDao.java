package com.ujiuye.dao;

import com.ujiuye.entity.Student;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudent();

    public int getCountRows();

    public List<Student> getStudentByPage(PageUtil pageUtil);

    public int insert(Student student);

    public int deleteStudentBySid(int sid);

    public int deleteAll(String sids);

    public Student getStudentBySid(int sid);

    public int update(Student student);

    public int getCountRowsBySname(String sname);

    public List<Student> getStudentBySname(String sname,PageUtil pageUtil);

}
