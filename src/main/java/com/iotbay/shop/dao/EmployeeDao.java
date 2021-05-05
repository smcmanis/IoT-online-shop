package com.iotbay.shop.dao;

import com.iotbay.shop.model.Employee;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;

public class EmployeeDao {
        
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addEmployee(Employee employee) {
       
    }
    
    public Employee getEmployeeByEmployeeId(Integer employeeId) {
        EntityManager em = getEntityManager();
        Employee employee = em.find(Employee.class, employeeId);
        em.close();
        return employee;
    }
        
    public List<Employee> getAllEmployees() {
        EntityManager em = getEntityManager();
        List<Employee> employeeList = em.createQuery("select u from Employee u").getResultList();
        em.close();
        return employeeList;
    }
    
    public void updateEmployee(Employee employee) {
    }
    
    public void deleteEmployee(Employee employee) {
        
    }
}
