
public class CompanyReportException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 700L;

	private String companyName;
	private String reportName;

	public CompanyReportException(String message, String companyName, String reportName) {
		super(message);
		this.companyName = companyName;
		this.reportName = reportName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public String toString() {
		return "- Company '"+this.companyName + "' at method '" + this.reportName + "' > " + super.getMessage();
	}

}
