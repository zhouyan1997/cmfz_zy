package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page,Integer rows){
        Map<String, Object> map = new HashMap<String,Object>();
        List<Course> bypage = courseService.findBypage(page, rows);
        Long totals = courseService.findTotals();
        map.put("total",totals);
        map.put("rows",bypage);
        return map;
    }
//添加功课
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Course course){
        Map<String, Object> map = new HashMap<String,Object>();
        try {
            courseService.add(course);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message",e.getMessage());
        }
            return  map;
    }
//    根据id删除功课
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            courseService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//删除多门功课
    @RequestMapping("/deleteAll")
    public @ResponseBody String[] deleteAll(String[] ids){
        try {
            courseService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }
//    修改功课
    @RequestMapping("/update")
    public @ResponseBody String update(Course course){
        try {
            courseService.motify(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
//   根据id查询一门功课
    @RequestMapping("/queryone")
    public @ResponseBody Course queryone(String id){
        Course queryone = courseService.findone(id);
        return queryone;
    }
}
