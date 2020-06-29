package com.tiandihui.vpn.service;

public interface MemberActivityService {

    /**
     *查询新增用户 今日新增用户传1
     * @param day
     * @return
     */
    int addNewUser(int day);


    /**
     * 当天活跃用户 传1 一周活跃用户传7
     * 同时在线用户也可以通过此接口 传1
     * @param day
     * @return
     */
    int activityUser(int day);

}
