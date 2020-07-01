
public class Secretary extends Employee {
	private static final long serialVersionUID = 159003L;
	private String office;

	public Secretary(String name, Double salary, String office) {
		super(name, salary);
		this.office = office;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return String.format("Secretary [office=%s, getName()=%s, getSalary()=%s]", office, getName(), getSalary());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((office == null) ? 0 : office.hashCode());
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
		if (!(obj instanceof Secretary)) {
			return false;
		}
		Secretary other = (Secretary) obj;
		if (office == null) {
			if (other.office != null) {
				return false;
			}
		} else if (!office.equals(other.office)) {
			return false;
		}
		return true;
	}

}
