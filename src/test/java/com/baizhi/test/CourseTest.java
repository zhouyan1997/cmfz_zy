package com.baizhi.test;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CourseTest extends BaseTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void insert(){
        Course course=new Course();
        course.setTitle("诚心礼佛");
        course.setFlag("back/course/img");
        course.setCreatTime(new Date());
        courseService.add(course);
    }

}
