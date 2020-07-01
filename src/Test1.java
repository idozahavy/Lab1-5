
public class Test1 {

	public static void main(String[] args) throws CompanyReportException {

//		lab1();
//		lab2and3();
//		lab4();
		lab5();
	}

	public static void lab1() {
		Employee[] employees = new Employee[10];

		Input10Absurd(employees);

		float total_salary = 0;
		float managment_total_salary = 0;
		int managment_count = 0;

		for (Employee em : employees) {
			System.out.println(em);
			total_salary += em.getSalary();
			if (em instanceof Manager) {
				managment_total_salary += em.getSalary();
				managment_count++;
			}
		}

		System.out.println("Average Salary = " + total_salary / employees.length);
		System.out.println("Average Managment Salary = " + managment_total_salary / managment_count);
	}

	public static void Input10Absurd(Employee[] ems) {
		ems[0] = new Secretary("Conan", 2.0, "Main");
		ems[1] = new Secretary("Brad", 3.0, "Main");

		ems[2] = new Manager("Sherel", 3.0, "Costumer Service");
		ems[3] = new Manager("Dillan", 3.5, "HR");

		ems[4] = new Employee("Bob1", 2.0);
		ems[5] = new Employee("Bob2", 2.0);
		ems[6] = new Employee("Bob3", 2.0);

		ems[7] = new Director("Kobi", 5.0, "Offices", "Directorate");

		ems[8] = new Engineer("Ido", 4.0, "AI");
		ems[9] = new Engineer("Sababa Sali", 2.0, "Tora");
	}

	public static void lab2and3() throws CompanyReportException {
		try {
			Company.setCompanyName("Underground Bank");
			Company com = Company.getInstance();
			Employee[] employees = new Employee[10];
			Input10Absurd(employees);
			for (Employee em : employees) {
				com.addEmployee(em);
			}
			System.out.println(com);

			System.out.println("Average Salary = " + com.getAverageSalary());
			System.out.println("Management Average Salary = " + com.getManagementAverageSalary());
			System.out.println("Number of employees = " + com.getTotalNumOfEmployees());
			System.out.println("Number of managers = " + com.getTotalNumOfManagers());
			System.out.println("Yearly Salary = " + com.getYearlyPayment());
		} catch (CompanyReportException e) {
			System.out.println("Exception has been caught");
			System.out.println(e.getMessage());
		}

	}

	public static void lab4() throws CompanyReportException {
		Company com = Company.getInstance();
		
		com.storeEmployeeData();
		System.out.println(com);

	}
	
	public static void lab5() {
		Company com = Company.getInstance();
		System.out.println(com);
		com.yearlySalaryUpdate();
		System.out.println(com);
	}
	
}
