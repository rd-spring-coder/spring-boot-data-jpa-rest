package io.spring.demo.issuesdashboard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.spring.demo.issuesdashboard.domain.Employee;
import io.spring.demo.issuesdashboard.domain.Gender;
import io.spring.demo.issuesdashboard.domain.Salary;
import io.spring.demo.issuesdashboard.domain.Title;
import io.spring.demo.issuesdashboard.repo.EmployeeRepository;

@SpringBootApplication
public class ZeroToHeroIssuesDashboardApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository emplRepo;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date birthDate = sdf.parse("25-11-1989");
		Date hireDate = sdf.parse("18-11-2015");
		Employee e = new Employee("Ritesh","Dharmatti",birthDate,hireDate,Gender.MALE);
		Salary salary1 = new Salary(sdf.parse("18-11-2015"), sdf.parse("18-11-2016"), 57000);
		Salary salary2 = new Salary(sdf.parse("18-11-2016"), sdf.parse("18-11-2017"), 60000);
		e.addSalary(salary1);
		e.addSalary(salary2);
		Title t1 = new Title("Associate Programmer",sdf.parse("18-11-2015"), sdf.parse("18-11-2016"));
		Title t2 = new Title("Developer",sdf.parse("18-11-2016"), sdf.parse("18-11-2017"));
		e.addTitle(t1);
		e.addTitle(t2);
		this.emplRepo.save(e);
	}

	public static void main(String[] args) {
		SpringApplication.run(ZeroToHeroIssuesDashboardApplication.class, args);
	}
}
