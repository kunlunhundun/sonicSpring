package com.tiandihui.vpn.service;

import com.tiandihui.vpn.domain.MailInfo;

public interface MailService {

    void generateCode(String emailUser, int use);

    Boolean verifyCode( String emailUser, String  code, int use);

    MailInfo sendMail(MailInfo mailInfo);

}
