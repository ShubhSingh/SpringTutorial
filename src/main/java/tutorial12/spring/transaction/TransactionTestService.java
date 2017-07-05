package tutorial12.spring.transaction;

public interface TransactionTestService {
	public void readOnlyCommitExampleTransaction();
	
	public void readOnlyRollbackExampleTransaction();
	
	public void readWriteCommitExampleTransaction();
	
	public void readWriteRollbackExampleTransaction();
}
