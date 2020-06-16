package com.tiandihui.vpn.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class UmsVpnSsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsVpnSsExample() {
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

        public Criteria andLineNameIsNull() {
            addCriterion("line_name is null");
            return (Criteria) this;
        }

        public Criteria andLineNameIsNotNull() {
            addCriterion("line_name is not null");
            return (Criteria) this;
        }

        public Criteria andLineNameEqualTo(String value) {
            addCriterion("line_name =", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotEqualTo(String value) {
            addCriterion("line_name <>", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameGreaterThan(String value) {
            addCriterion("line_name >", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameGreaterThanOrEqualTo(String value) {
            addCriterion("line_name >=", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLessThan(String value) {
            addCriterion("line_name <", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLessThanOrEqualTo(String value) {
            addCriterion("line_name <=", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLike(String value) {
            addCriterion("line_name like", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotLike(String value) {
            addCriterion("line_name not like", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameIn(List<String> values) {
            addCriterion("line_name in", values, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotIn(List<String> values) {
            addCriterion("line_name not in", values, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameBetween(String value1, String value2) {
            addCriterion("line_name between", value1, value2, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotBetween(String value1, String value2) {
            addCriterion("line_name not between", value1, value2, "lineName");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNull() {
            addCriterion("use_status is null");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNotNull() {
            addCriterion("use_status is not null");
            return (Criteria) this;
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            addCriterion("use_status =", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            addCriterion("use_status <>", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            addCriterion("use_status >", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_status >=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThan(Integer value) {
            addCriterion("use_status <", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("use_status <=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            addCriterion("use_status in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            addCriterion("use_status not in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            addCriterion("use_status between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("use_status not between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Long value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Long value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Long> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdIsNull() {
            addCriterion("encription_type_id is null");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdIsNotNull() {
            addCriterion("encription_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdEqualTo(Integer value) {
            addCriterion("encription_type_id =", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdNotEqualTo(Integer value) {
            addCriterion("encription_type_id <>", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdGreaterThan(Integer value) {
            addCriterion("encription_type_id >", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("encription_type_id >=", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdLessThan(Integer value) {
            addCriterion("encription_type_id <", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("encription_type_id <=", value, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdIn(List<Integer> values) {
            addCriterion("encription_type_id in", values, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdNotIn(List<Integer> values) {
            addCriterion("encription_type_id not in", values, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("encription_type_id between", value1, value2, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andEncriptionTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("encription_type_id not between", value1, value2, "encriptionTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdIsNull() {
            addCriterion("protocal_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdIsNotNull() {
            addCriterion("protocal_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdEqualTo(Integer value) {
            addCriterion("protocal_type_id =", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdNotEqualTo(Integer value) {
            addCriterion("protocal_type_id <>", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdGreaterThan(Integer value) {
            addCriterion("protocal_type_id >", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("protocal_type_id >=", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdLessThan(Integer value) {
            addCriterion("protocal_type_id <", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("protocal_type_id <=", value, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdIn(List<Integer> values) {
            addCriterion("protocal_type_id in", values, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdNotIn(List<Integer> values) {
            addCriterion("protocal_type_id not in", values, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("protocal_type_id between", value1, value2, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("protocal_type_id not between", value1, value2, "protocalTypeId");
            return (Criteria) this;
        }

        public Criteria andProtocalParamIsNull() {
            addCriterion("protocal_param is null");
            return (Criteria) this;
        }

        public Criteria andProtocalParamIsNotNull() {
            addCriterion("protocal_param is not null");
            return (Criteria) this;
        }

        public Criteria andProtocalParamEqualTo(String value) {
            addCriterion("protocal_param =", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamNotEqualTo(String value) {
            addCriterion("protocal_param <>", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamGreaterThan(String value) {
            addCriterion("protocal_param >", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamGreaterThanOrEqualTo(String value) {
            addCriterion("protocal_param >=", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamLessThan(String value) {
            addCriterion("protocal_param <", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamLessThanOrEqualTo(String value) {
            addCriterion("protocal_param <=", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamLike(String value) {
            addCriterion("protocal_param like", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamNotLike(String value) {
            addCriterion("protocal_param not like", value, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamIn(List<String> values) {
            addCriterion("protocal_param in", values, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamNotIn(List<String> values) {
            addCriterion("protocal_param not in", values, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamBetween(String value1, String value2) {
            addCriterion("protocal_param between", value1, value2, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andProtocalParamNotBetween(String value1, String value2) {
            addCriterion("protocal_param not between", value1, value2, "protocalParam");
            return (Criteria) this;
        }

        public Criteria andObfsIdIsNull() {
            addCriterion("obfs_id is null");
            return (Criteria) this;
        }

        public Criteria andObfsIdIsNotNull() {
            addCriterion("obfs_id is not null");
            return (Criteria) this;
        }

        public Criteria andObfsIdEqualTo(Integer value) {
            addCriterion("obfs_id =", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdNotEqualTo(Integer value) {
            addCriterion("obfs_id <>", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdGreaterThan(Integer value) {
            addCriterion("obfs_id >", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("obfs_id >=", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdLessThan(Integer value) {
            addCriterion("obfs_id <", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdLessThanOrEqualTo(Integer value) {
            addCriterion("obfs_id <=", value, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdIn(List<Integer> values) {
            addCriterion("obfs_id in", values, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdNotIn(List<Integer> values) {
            addCriterion("obfs_id not in", values, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdBetween(Integer value1, Integer value2) {
            addCriterion("obfs_id between", value1, value2, "obfsId");
            return (Criteria) this;
        }

        public Criteria andObfsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("obfs_id not between", value1, value2, "obfsId");
            return (Criteria) this;
        }

        public Criteria andCofusedParamIsNull() {
            addCriterion("cofused_param is null");
            return (Criteria) this;
        }

        public Criteria andCofusedParamIsNotNull() {
            addCriterion("cofused_param is not null");
            return (Criteria) this;
        }

        public Criteria andCofusedParamEqualTo(String value) {
            addCriterion("cofused_param =", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamNotEqualTo(String value) {
            addCriterion("cofused_param <>", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamGreaterThan(String value) {
            addCriterion("cofused_param >", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamGreaterThanOrEqualTo(String value) {
            addCriterion("cofused_param >=", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamLessThan(String value) {
            addCriterion("cofused_param <", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamLessThanOrEqualTo(String value) {
            addCriterion("cofused_param <=", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamLike(String value) {
            addCriterion("cofused_param like", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamNotLike(String value) {
            addCriterion("cofused_param not like", value, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamIn(List<String> values) {
            addCriterion("cofused_param in", values, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamNotIn(List<String> values) {
            addCriterion("cofused_param not in", values, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamBetween(String value1, String value2) {
            addCriterion("cofused_param between", value1, value2, "cofusedParam");
            return (Criteria) this;
        }

        public Criteria andCofusedParamNotBetween(String value1, String value2) {
            addCriterion("cofused_param not between", value1, value2, "cofusedParam");
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