package com.example.employBackend.Controller;


import com.example.employBackend.Dao.EmployDao;
import com.example.employBackend.Model.EmployModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployController {


    @Autowired
    private EmployDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemploy",consumes = "application/json",produces = "application/json")
    public String addEmploy(@RequestBody EmployModel employ){
        System.out.println(employ.toString());
        dao.save(employ);
        return "{status:'success'}";
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewemploy" )
    public List<EmployModel> viewEmploy(){
        return (List<EmployModel>)  dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteemploy",consumes = "application/json",produces = "application/json")
    public String deleteEmploy(@RequestBody EmployModel employ){
        dao.deleteEmployById(employ.getId());
        return "{status:'success'}";
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemploy",consumes = "application/json",produces = "application/json")
    public List<EmployModel> searchemployee(@RequestBody EmployModel employ){
        return (List<EmployModel>) dao.searchemploy(employ.getName());
    }

}
