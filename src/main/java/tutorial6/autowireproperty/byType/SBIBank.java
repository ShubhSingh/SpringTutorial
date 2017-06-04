package tutorial6.autowireproperty.byType;

public class SBIBank implements Bank {
	private SavingAccount saving;
	private CurrentAccount current;

	public SavingAccount getSaving() {
		return saving;
	}

	public void setSaving(SavingAccount saving) {
		this.saving = saving;
	}

	public CurrentAccount getCurrent() {
		return current;
	}

	public void setCurrent(CurrentAccount current) {
		this.current = current;
	}

	@Override
	public String showStatus() {
		return "Hi, SBI Bank is Active.";
	}
}
