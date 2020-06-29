package com.tiandihui.vpn;

import com.tiandihui.vpn.domain.MailInfo;
import com.tiandihui.vpn.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TiandihuiApplicationTests {

	@Autowired
	private MailService mailService;

	public TiandihuiApplicationTests() {
		super();
	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void testEmail() {
		MailInfo mailInfo = new MailInfo();
		mailInfo.setTo("490467776@qq.com");
		mailService.sendMail(mailInfo);
	}

}
