package com.tiandihui.vpn.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsMemberLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberLoginLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFromIpIsNull() {
            addCriterion("from_ip is null");
            return (Criteria) this;
        }

        public Criteria andFromIpIsNotNull() {
            addCriterion("from_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFromIpEqualTo(String value) {
            addCriterion("from_ip =", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotEqualTo(String value) {
            addCriterion("from_ip <>", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpGreaterThan(String value) {
            addCriterion("from_ip >", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpGreaterThanOrEqualTo(String value) {
            addCriterion("from_ip >=", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLessThan(String value) {
            addCriterion("from_ip <", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLessThanOrEqualTo(String value) {
            addCriterion("from_ip <=", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLike(String value) {
            addCriterion("from_ip like", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotLike(String value) {
            addCriterion("from_ip not like", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpIn(List<String> values) {
            addCriterion("from_ip in", values, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotIn(List<String> values) {
            addCriterion("from_ip not in", values, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpBetween(String value1, String value2) {
            addCriterion("from_ip between", value1, value2, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotBetween(String value1, String value2) {
            addCriterion("from_ip not between", value1, value2, "fromIp");
            return (Criteria) this;
        }

        public Criteria andIpLocationIsNull() {
            addCriterion("ip_location is null");
            return (Criteria) this;
        }

        public Criteria andIpLocationIsNotNull() {
            addCriterion("ip_location is not null");
            return (Criteria) this;
        }

        public Criteria andIpLocationEqualTo(String value) {
            addCriterion("ip_location =", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationNotEqualTo(String value) {
            addCriterion("ip_location <>", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationGreaterThan(String value) {
            addCriterion("ip_location >", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationGreaterThanOrEqualTo(String value) {
            addCriterion("ip_location >=", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationLessThan(String value) {
            addCriterion("ip_location <", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationLessThanOrEqualTo(String value) {
            addCriterion("ip_location <=", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationLike(String value) {
            addCriterion("ip_location like", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationNotLike(String value) {
            addCriterion("ip_location not like", value, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationIn(List<String> values) {
            addCriterion("ip_location in", values, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationNotIn(List<String> values) {
            addCriterion("ip_location not in", values, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationBetween(String value1, String value2) {
            addCriterion("ip_location between", value1, value2, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andIpLocationNotBetween(String value1, String value2) {
            addCriterion("ip_location not between", value1, value2, "ipLocation");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNull() {
            addCriterion("service_ip is null");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNotNull() {
            addCriterion("service_ip is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIpEqualTo(String value) {
            addCriterion("service_ip =", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotEqualTo(String value) {
            addCriterion("service_ip <>", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThan(String value) {
            addCriterion("service_ip >", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("service_ip >=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThan(String value) {
            addCriterion("service_ip <", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThanOrEqualTo(String value) {
            addCriterion("service_ip <=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLike(String value) {
            addCriterion("service_ip like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotLike(String value) {
            addCriterion("service_ip not like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpIn(List<String> values) {
            addCriterion("service_ip in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotIn(List<String> values) {
            addCriterion("service_ip not in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpBetween(String value1, String value2) {
            addCriterion("service_ip between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotBetween(String value1, String value2) {
            addCriterion("service_ip not between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(Integer value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(Integer value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(Integer value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(Integer value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(Integer value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<Integer> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<Integer> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(Integer value1, Integer value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginMacIsNull() {
            addCriterion("login_mac is null");
            return (Criteria) this;
        }

        public Criteria andLoginMacIsNotNull() {
            addCriterion("login_mac is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMacEqualTo(String value) {
            addCriterion("login_mac =", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotEqualTo(String value) {
            addCriterion("login_mac <>", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacGreaterThan(String value) {
            addCriterion("login_mac >", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacGreaterThanOrEqualTo(String value) {
            addCriterion("login_mac >=", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLessThan(String value) {
            addCriterion("login_mac <", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLessThanOrEqualTo(String value) {
            addCriterion("login_mac <=", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLike(String value) {
            addCriterion("login_mac like", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotLike(String value) {
            addCriterion("login_mac not like", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacIn(List<String> values) {
            addCriterion("login_mac in", values, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotIn(List<String> values) {
            addCriterion("login_mac not in", values, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacBetween(String value1, String value2) {
            addCriterion("login_mac between", value1, value2, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotBetween(String value1, String value2) {
            addCriterion("login_mac not between", value1, value2, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginUidIsNull() {
            addCriterion("login_uid is null");
            return (Criteria) this;
        }

        public Criteria andLoginUidIsNotNull() {
            addCriterion("login_uid is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUidEqualTo(String value) {
            addCriterion("login_uid =", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotEqualTo(String value) {
            addCriterion("login_uid <>", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidGreaterThan(String value) {
            addCriterion("login_uid >", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidGreaterThanOrEqualTo(String value) {
            addCriterion("login_uid >=", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLessThan(String value) {
            addCriterion("login_uid <", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLessThanOrEqualTo(String value) {
            addCriterion("login_uid <=", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLike(String value) {
            addCriterion("login_uid like", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotLike(String value) {
            addCriterion("login_uid not like", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidIn(List<String> values) {
            addCriterion("login_uid in", values, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotIn(List<String> values) {
            addCriterion("login_uid not in", values, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidBetween(String value1, String value2) {
            addCriterion("login_uid between", value1, value2, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotBetween(String value1, String value2) {
            addCriterion("login_uid not between", value1, value2, "loginUid");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNull() {
            addCriterion("connect_time is null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNotNull() {
            addCriterion("connect_time is not null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeEqualTo(Date value) {
            addCriterion("connect_time =", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotEqualTo(Date value) {
            addCriterion("connect_time <>", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThan(Date value) {
            addCriterion("connect_time >", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("connect_time >=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThan(Date value) {
            addCriterion("connect_time <", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("connect_time <=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIn(List<Date> values) {
            addCriterion("connect_time in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotIn(List<Date> values) {
            addCriterion("connect_time not in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeBetween(Date value1, Date value2) {
            addCriterion("connect_time between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("connect_time not between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNull() {
            addCriterion("disconnect_time is null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNotNull() {
            addCriterion("disconnect_time is not null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeEqualTo(Date value) {
            addCriterion("disconnect_time =", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotEqualTo(Date value) {
            addCriterion("disconnect_time <>", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThan(Date value) {
            addCriterion("disconnect_time >", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("disconnect_time >=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThan(Date value) {
            addCriterion("disconnect_time <", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("disconnect_time <=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIn(List<Date> values) {
            addCriterion("disconnect_time in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotIn(List<Date> values) {
            addCriterion("disconnect_time not in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeBetween(Date value1, Date value2) {
            addCriterion("disconnect_time between", value1, value2, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("disconnect_time not between", value1, value2, "disconnectTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}