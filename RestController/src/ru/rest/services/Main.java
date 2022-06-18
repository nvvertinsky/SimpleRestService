package ru.rest.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ru.model.Dept;
import ru.model.Emp;
import ru.model.Person;

@Path(value = "/main")
public class Main {
	@PersistenceContext(unitName = "postgresql")
	private EntityManager emPg;
	
	@Path(value = "/info")
	@GET
	@Produces(value = "application/json")
	@Consumes(value = "application/json")
	public Person info() {
		return new Person("Михаил", "Чачин", 28);
	}
	
	@Path(value = "/dept")
	@GET
	@Produces(value = "application/json")
	@Consumes(value = "application/json")
	public List<Dept> depts() {
		return emPg.createNativeQuery("select dept.department_id, dept.department_name from hr.departments dept", Dept.class).getResultList();
	}
	
	@Path(value = "/emps/{deptno}")
	@GET
	@Produces(value = "application/json")
	@Consumes(value = "application/json")
	public List<Emp> empsInDept(@PathParam(value = "deptno") int id) {
		return emPg.createNativeQuery("select emp.employee_id, emp.first_name, emp.last_name from hr.employees emp where emp.department_id = ?", Emp.class)
				   .setParameter(1, id)
				   .getResultList();
	}
	
	@Path(value = "/emp/{empno}")
	@GET
	@Produces(value = "application/json")
	@Consumes(value = "application/json")
	public Emp emp(@PathParam(value = "empno") int id) {
		return emPg.find(Emp.class, id);
	}
}
