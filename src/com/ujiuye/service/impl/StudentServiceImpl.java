package com.ujiuye.service.impl;

import com.ujiuye.dao.StudentDao;
import com.ujiuye.dao.impl.StudentDaoImpl;
import com.ujiuye.entity.Student;
import com.ujiuye.service.StudentService;
import com.ujiuye.util.PageUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    public int getCountRows() {
        return studentDao.getCountRows();
    }

    public List<Student> getStudentByPage(PageUtil pageUtil) {
        return studentDao.getStudentByPage(pageUtil);
    }

    public boolean insert(Student student) {
        int rows = studentDao.insert(student);
        boolean res = true;
        if (rows == 0){
            res = false;
        }
        return res;
    }

    public boolean deleteStudentBySid(int sid) {
        int rows = studentDao.deleteStudentBySid(sid);
        boolean res = true;
        if (rows == 0){
            res = false;
        }
        return res;
    }

    public boolean deleteAll(String sids) {
        int rows = studentDao.deleteAll(sids);
        boolean res = true;
        if (rows == 0){
            res = false;
        }
        return res;
    }

    public Student getStudentBySid(int sid) {
        return studentDao.getStudentBySid(sid);
    }

    public boolean update(Student student) {
        int rows = studentDao.update(student);
        boolean res = true;
        if (rows == 0){
            res =false;
        }
        return res;
    }

    public int getCountRowsBySname(String sname) {
        return studentDao.getCountRowsBySname(sname);
    }

    public List<Student> getStudentBySname(String sname, PageUtil pageUtil) {
        return studentDao.getStudentBySname(sname,pageUtil);
    }

}
