
public class Engineer extends Employee {
	private static final long serialVersionUID = 159004L;
	private String specialty;

	public Engineer(String name, Double salary, String specialty) {
		super(name, salary);
		this.specialty = specialty;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return String.format("Engineer [specialty=%s, getName()=%s, getSalary()=%s]", specialty, getName(),
				getSalary());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
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
		if (!(obj instanceof Engineer)) {
			return false;
		}
		Engineer other = (Engineer) obj;
		if (specialty == null) {
			if (other.specialty != null) {
				return false;
			}
		} else if (!specialty.equals(other.specialty)) {
			return false;
		}
		return true;
	}

}
