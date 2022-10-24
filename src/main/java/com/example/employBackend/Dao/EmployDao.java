package com.example.employBackend.Dao;

import com.example.employBackend.Model.EmployModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployDao extends CrudRepository<EmployModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void deleteEmployById(Integer id);

    @Query(value = "SELECT `id`, `company`, `designation`, `dob`, `doj`, `email`, `empcode`, `name`, `phone`, `salary` FROM `employees` WHERE `name`=:name",nativeQuery = true)
    List<EmployModel> searchemploy(String name);
}
