package com.tiandihui.cmd;
import com.tiandihui.cmd.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VpnserverApplicationTests {

	@Autowired
	MailService mailService;

	public VpnserverApplicationTests() {
		super();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendEmail() {

		mailService.generateCode("490467776@qq.com",1);
	}


}
