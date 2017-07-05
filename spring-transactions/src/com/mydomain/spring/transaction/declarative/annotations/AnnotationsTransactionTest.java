package com.mydomain.spring.transaction.declarative.annotations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydomain.spring.transaction.TransactionTestService;

/** 
 * @author Ross
 */
public class AnnotationsTransactionTest {
	private final static Log log = LogFactory.getLog(AnnotationsTransactionTest.class);
	
	public static void main(String[] args) {
		log.info("-- Starting Spring Declarative Annotations Example --");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/com/mydomain/spring/transaction/declarative/annotations/annotations-test.xml");
		TransactionTestService transactionTestService = (TransactionTestService)ctx.getBean("transactionTestService");
		
		transactionTestService.readOnlyCommitExampleTransaction();
		
		try {
			transactionTestService.readOnlyRollbackExampleTransaction();
		} catch (RuntimeException re) {
			log.info("-- Expected exception: " + re.getMessage());
		}		
		
		transactionTestService.readWriteCommitExampleTransaction();
		
		try {
			transactionTestService.readWriteRollbackExampleTransaction();
		} catch (RuntimeException re) {
			log.info("-- Expected exception: " + re.getMessage());
		}		
	}
}
