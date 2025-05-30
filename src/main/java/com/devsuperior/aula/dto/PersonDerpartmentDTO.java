package com.devsuperior.aula.dto;


import com.devsuperior.aula.entities.Person;

public class PersonDerpartmentDTO {

    private Long id;
    private String name;
    private Double salary;

    private DepartmentDTO department;

    public PersonDerpartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public  PersonDerpartmentDTO(Person entity) {
        id = entity.getId();
        name = entity.getName();
        salary = entity.getSalary();
        department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
