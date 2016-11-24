/**
* TODO
* @Project: interframe-web-admin
* @Title: BatchJobTests.java
* @Package com.interframe.system.batch
* @author jason
* @Date 2016年11月10日 下午2:30:15
* @Copyright
* @Version 
*/
package com.interframe.system.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 * 
 * @ClassName: BatchJobTests
 * @author jason
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context-test.xml","classpath:batch-config.xml" })
@ActiveProfiles({ "dev", "mybatis" })
public class BatchJobTests {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job1;

	@Test
	public void jobExcuteTest() {

		JobParametersBuilder jobParaBuilder = new JobParametersBuilder();
		try {
			JobExecution jobExecute = jobLauncher.run(job1, jobParaBuilder.toJobParameters());
			ExitStatus status = jobExecute.getExitStatus();
			if (status.getExitCode().equals(ExitStatus.COMPLETED.getExitCode())) {
				System.out.println("任务正常完成");
			} else {
				System.out.println("任务失败，exitCode=" + status.getExitCode());
			}
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
