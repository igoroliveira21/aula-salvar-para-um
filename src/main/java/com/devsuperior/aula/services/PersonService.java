package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDerpartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public PersonDerpartmentDTO insert(PersonDerpartmentDTO dto) {

        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

//        Department dept = new Department();
//        dept.setId(dto.getDepartment().getId());

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
        entity.setDepartment(dept);

        entity = repository.save(entity);

        return new PersonDerpartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto) {

        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());

//        Department dept = new Department();
//        dept.setId(dto.getDepartmentId());

        entity.setDepartment(dept);

        entity = repository.save(entity);

        return new PersonDTO(entity);
    }
}
