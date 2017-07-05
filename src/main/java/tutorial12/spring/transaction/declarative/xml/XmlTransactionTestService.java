package tutorial12.spring.transaction.declarative.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tutorial12.spring.transaction.TransactionTestService;

/** 
 * @author Ross
 */
public class XmlTransactionTestService implements TransactionTestService {
	private final static Log log = LogFactory.getLog(XmlTransactionTestService.class);
	
	public void readOnlyCommitExampleTransaction() {
		log.info("-- XmlTransactionTestService.readOnlyCommitExampleTransaction -- expects transaction commit and read-only");
		// do stuff
	}
	
	public void readOnlyRollbackExampleTransaction() {
		log.info("-- XmlTransactionTestService.readOnlyRollbackExampleTransaction -- expects transaction rollback and read-only");
		// do stuff
		throw new RuntimeException("readOnlyRollbackExampleTransaction Exception");
	}
	
	public void readWriteCommitExampleTransaction() {
		log.info("-- XmlTransactionTestService.readWriteCommitExampleTransaction -- expects transaction commit");
		// do stuff
	}
	
	public void readWriteRollbackExampleTransaction() {
		log.info("-- XmlTransactionTestService.readWriteRollbackExampleTransaction -- expects transaction rollback");
		// do stuff
		throw new RuntimeException("readWriteRollbackExampleTransaction Exception");
	}
}
