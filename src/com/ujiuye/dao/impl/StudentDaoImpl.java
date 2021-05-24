package com.ujiuye.dao.impl;

import com.ujiuye.dao.StudentDao;
import com.ujiuye.entity.Student;
import com.ujiuye.util.JdbcUtil;
import com.ujiuye.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner qr = JdbcUtil.getQr();

    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getCountRows() {
        int countRows = 0;
        String sql = "select count(*) from student";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    public List<Student> getStudentByPage(PageUtil pageUtil) {
        List<Student> list = null;
        String sql = "select * from student limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class),pageUtil.getIndex(),pageUtil.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(Student student) {
        int rows = 0;
        String sql = "insert into student(sname,sage,ssex,semail,sphoto) values(?,?,?,?,?)";
        try {
            rows = qr.update(sql,student.getSname(),student.getSage(),student.getSsex(),student.getSemail(),student.getSphoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int deleteStudentBySid(int sid) {
        int rows = 0;
        String sql = "delete from student where sid=?";
        try {
            rows = qr.update(sql,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int deleteAll(String sids) {
        int rows = 0;
        String sql = "delete from student where sid in ("+sids+")";
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public Student getStudentBySid(int sid) {
        Student student = null;
        String sql = "select * from student where sid=?";
        try {
            student = qr.query(sql,new BeanHandler<>(Student.class),sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public int update(Student student) {
        int rows = 0;
        String sql = "update student set sname=?,sage=?,ssex=?,semail=?,sphoto=? where sid=?";
        try {
            rows = qr.update(sql,student.getSname(),student.getSage(),student.getSsex(),student.getSemail(),student.getSphoto(),student.getSid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int getCountRowsBySname(String sname) {
        int countRows = 0;
        String sql = "select count(*) from student where sname like '%"+sname+"%'";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    public List<Student> getStudentBySname(String sname, PageUtil pageUtil) {
        List<Student> list = null;
        String sql = "select * from student where sname like '%"+sname+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class),pageUtil.getIndex(),pageUtil.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
