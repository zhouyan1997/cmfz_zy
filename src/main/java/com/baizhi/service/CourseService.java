package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
        //添加功课
        public void add (Course course);
        //根据id删除功课
        public void remove(String id);
        //删除门功课
         void  removeAll(String[] ids);
        //修改章功课信息
        public void motify(Course course);
        //查询全部功课
        public List<Course> findAll();
        //分页查询文章
        public List<Course> findBypage(Integer page, Integer rows);
        //根据id查询一门功课
        public Course findone(String id);
        //查询一共有多少功课
        Long findTotals();
}
