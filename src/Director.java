
public class Director extends Manager {
	private static final long serialVersionUID = 159011L;
	private String group;

	public Director(String name, Double salary, String department, String group) {
		super(name, salary, department);
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return String.format("Director [group=%s, getDepartment()=%s, getName()=%s, getSalary()=%s]", group,
				getDepartment(), getName(), getSalary());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
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
		if (!(obj instanceof Director)) {
			return false;
		}
		Director other = (Director) obj;
		if (group == null) {
			if (other.group != null) {
				return false;
			}
		} else if (!group.equals(other.group)) {
			return false;
		}
		return true;
	}
	
	
}
