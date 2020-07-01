
public class Manager extends Employee {
	private static final long serialVersionUID = 159010L;
	private String department;

	public Manager(String name, Double salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("Manager [department=%s, getName()=%s, getSalary()=%s]", department, getName(),
				getSalary());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Manager)) {
			return false;
		}
		Manager other = (Manager) obj;
		if (department == null) {
			if (other.department != null) {
				return false;
			}
		} else if (!department.equals(other.department)) {
			return false;
		}
		return true;
	}

}
