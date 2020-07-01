import java.util.List;
import java.util.ArrayList;

public class SalaryUpdate implements Runnable {

	private List<Employee> employees;

	public SalaryUpdate() {
		this.employees = new ArrayList<Employee>();
	}

	public void addEmployee(Employee em) {
		this.employees.add(em);
	}

	@Override
	public void run() {
		for (Employee em : this.employees) {
			em.setSalary(em.getSalary() * 1.02);
		}
		System.out.println("Salaries updated");
	}

}
