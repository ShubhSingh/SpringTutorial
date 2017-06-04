package tutorial2.settingbeanproperties.pnamespace;

public class SBIBank implements Bank {

	private String customerName;
	private int branchCode;
	private int accountNo;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public SBIBank(String customerName, int branchCode) {
		this.customerName = customerName;
		this.branchCode = branchCode;
	}
	
	/** Initialize default constructor with values
	 */
	public SBIBank() {
		this.customerName = "Customer";
		this.branchCode = 118;
	}

	@Override
	public int getBalance() {
		return 756;
	}

	@Override
	public String showStatus() {
		return "Hi, "+ customerName +" SBI Bank is Active. Your branh code is: "+ branchCode;
	}

	@Override
	public String toString() {
		return "SBIBank [customerName=" + customerName + ", branchCode="
				+ branchCode + ", accountNo=" + accountNo + "]";
	}

}
