import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Company {

	private static Company singleton;

	public static Company getInstance() {
		if (singleton == null)
			singleton = new Company("");
		return singleton;
	}
	public static void setCompanyName(String name) {
		if (singleton == null)
			singleton = new Company(name);
		else {
			singleton.name = name;
		}
	}

	private List<Employee> employees;
	private String name;

	private Company(String name) {
		this.name = name;
		try {
			this.loadEmployeeData();
		} catch (CompanyReportException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public void addEmployee(Employee em) throws CompanyReportException {
		if (this.employees == null)
			this.employees = new ArrayList<Employee>();
		this.employees.add(em);
	}

	public void removeEmployee(Employee em) throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "removeEmployee");
		this.employees.remove(em);
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}
	
	public void yearlySalaryUpdate() {
		int THREAD_COUNT = 4;
		SalaryUpdate[] updates = new SalaryUpdate[THREAD_COUNT];
		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i=0;i<THREAD_COUNT;i++) {
			updates[i] = new SalaryUpdate(); 
			threads[i] = new Thread(updates[i]);
		}
		for (int i=0;i<this.employees.size();i++) {
			updates[i%THREAD_COUNT].addEmployee(this.employees.get(i));
		}
		for (Thread th : threads) {
			th.start();
		}
		for (Thread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public float getTotalSalary() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getTotalSalary");
		float total_salary = 0;
		for (Employee em : this.employees) {
			total_salary += em.getSalary();
		}
		return total_salary;
	}

	public float getAverageSalary() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getAverageSalary");
		return this.getTotalSalary() / this.getTotalNumOfEmployees();
	}

	public float getManagementAverageSalary() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getManagementAverageSalary");
		float total_salary = 0;
		int managment_count = 0;
		for (Employee em : this.employees) {
			if (em instanceof Manager) {
				total_salary += em.getSalary();
				managment_count++;
			}
		}
		return total_salary / managment_count;
	}

	public float getYearlyPayment() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getYearlyPayment");
		return this.getTotalSalary() * 12;
	}

	public int getTotalNumOfEmployees() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getTotalNumOfEmployees");
		return this.employees.size();
	}

	public int getTotalNumOfManagers() throws CompanyReportException {
		if (this.employees == null || this.employees.size() == 0)
			throw new CompanyReportException("Data unavailable", this.name, "getTotalNumOfManagers");
		int managment_count = 0;
		for (Employee em : this.employees) {
			if (em instanceof Manager) {
				managment_count++;
			}
		}
		return managment_count;
	}

	private void loadEmployeeData() throws CompanyReportException {
		try {
			FileInputStream fileStream = new FileInputStream("emp.dat");
			ObjectInputStream stream = new ObjectInputStream(fileStream);
			while (true) {
				try {
					Employee em = (Employee) stream.readObject();
					if (em == null)
						break;
					this.addEmployee(em);
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
				}
			}
			stream.close();
		} catch (FileNotFoundException e) {
			this.employees = new ArrayList<Employee>();
		} catch (EOFException e) {
//			System.out.println("File stream read has ended succesfully");
		} catch (IOException e) {
			throw new CompanyReportException("File stream has ended prematurly - " + e.getMessage(), this.name,
					"loadEmployeeData");
		}
	}

	public void storeEmployeeData() throws CompanyReportException {
		try {
			FileOutputStream fileStream = new FileOutputStream("emp.dat");
			ObjectOutputStream stream = new ObjectOutputStream(fileStream);
			for (Employee em : this.employees) {
				stream.writeObject(em);
			}
			stream.close();
		} catch (IOException e) {
			throw new CompanyReportException("File stream has ended prematurly - " + e.getMessage(), this.name,
					"loadEmployeeData");
		}
//		System.out.println("File stream write has ended succesfully");
	}

	@Override
	public String toString() { // TODO all employees will print?
		return String.format("Company [name='%s', employees=%s]", name, employees);
	}

}
