package com.example.springbooth2.repository;

import com.example.springbooth2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.example.springbooth2.repository
 *
 * @author divyanshsoni on 14/01/25
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e from Employee e where e.dept = :dept")
    List<Employee> findAllByDept(String dept);
}
