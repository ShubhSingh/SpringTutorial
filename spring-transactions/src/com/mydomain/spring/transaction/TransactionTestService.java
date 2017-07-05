package com.mydomain.spring.transaction;

/** 
 * @author Ross
 */
public interface TransactionTestService {
	public void readOnlyCommitExampleTransaction();
	
	public void readOnlyRollbackExampleTransaction();
	
	public void readWriteCommitExampleTransaction();
	
	public void readWriteRollbackExampleTransaction();
}
