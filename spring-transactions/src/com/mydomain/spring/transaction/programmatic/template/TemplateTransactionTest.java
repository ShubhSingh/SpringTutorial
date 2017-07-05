package com.mydomain.spring.transaction.programmatic.template;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydomain.spring.transaction.TransactionTestService;

/** 
 * @author Ross
 */
public class TemplateTransactionTest {
	private final static Log log = LogFactory.getLog(TemplateTransactionTest.class);
	
	public static void main(String[] args) {
		log.info("-- Starting Spring Programmatic Template Example --");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/com/mydomain/spring/transaction/programmatic/template/template-test.xml");
		TransactionTestService transactionTestService = (TransactionTestService)ctx.getBean("transactionTestService");
		transactionTestService.readOnlyCommitExampleTransaction();
		transactionTestService.readOnlyRollbackExampleTransaction();
		transactionTestService.readWriteCommitExampleTransaction();
		transactionTestService.readWriteRollbackExampleTransaction();
	}
}
