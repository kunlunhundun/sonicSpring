package com.tiandihui.cmd.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsVpnWireguardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsVpnWireguardExample() {
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

        public Criteria andPrivatekeyIsNull() {
            addCriterion("privatekey is null");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyIsNotNull() {
            addCriterion("privatekey is not null");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyEqualTo(String value) {
            addCriterion("privatekey =", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotEqualTo(String value) {
            addCriterion("privatekey <>", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyGreaterThan(String value) {
            addCriterion("privatekey >", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyGreaterThanOrEqualTo(String value) {
            addCriterion("privatekey >=", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLessThan(String value) {
            addCriterion("privatekey <", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLessThanOrEqualTo(String value) {
            addCriterion("privatekey <=", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLike(String value) {
            addCriterion("privatekey like", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotLike(String value) {
            addCriterion("privatekey not like", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyIn(List<String> values) {
            addCriterion("privatekey in", values, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotIn(List<String> values) {
            addCriterion("privatekey not in", values, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyBetween(String value1, String value2) {
            addCriterion("privatekey between", value1, value2, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotBetween(String value1, String value2) {
            addCriterion("privatekey not between", value1, value2, "privatekey");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDnsIsNull() {
            addCriterion("dns is null");
            return (Criteria) this;
        }

        public Criteria andDnsIsNotNull() {
            addCriterion("dns is not null");
            return (Criteria) this;
        }

        public Criteria andDnsEqualTo(String value) {
            addCriterion("dns =", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotEqualTo(String value) {
            addCriterion("dns <>", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThan(String value) {
            addCriterion("dns >", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThanOrEqualTo(String value) {
            addCriterion("dns >=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThan(String value) {
            addCriterion("dns <", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThanOrEqualTo(String value) {
            addCriterion("dns <=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLike(String value) {
            addCriterion("dns like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotLike(String value) {
            addCriterion("dns not like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsIn(List<String> values) {
            addCriterion("dns in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotIn(List<String> values) {
            addCriterion("dns not in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsBetween(String value1, String value2) {
            addCriterion("dns between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotBetween(String value1, String value2) {
            addCriterion("dns not between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andMtuIsNull() {
            addCriterion("mtu is null");
            return (Criteria) this;
        }

        public Criteria andMtuIsNotNull() {
            addCriterion("mtu is not null");
            return (Criteria) this;
        }

        public Criteria andMtuEqualTo(String value) {
            addCriterion("mtu =", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuNotEqualTo(String value) {
            addCriterion("mtu <>", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuGreaterThan(String value) {
            addCriterion("mtu >", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuGreaterThanOrEqualTo(String value) {
            addCriterion("mtu >=", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuLessThan(String value) {
            addCriterion("mtu <", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuLessThanOrEqualTo(String value) {
            addCriterion("mtu <=", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuLike(String value) {
            addCriterion("mtu like", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuNotLike(String value) {
            addCriterion("mtu not like", value, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuIn(List<String> values) {
            addCriterion("mtu in", values, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuNotIn(List<String> values) {
            addCriterion("mtu not in", values, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuBetween(String value1, String value2) {
            addCriterion("mtu between", value1, value2, "mtu");
            return (Criteria) this;
        }

        public Criteria andMtuNotBetween(String value1, String value2) {
            addCriterion("mtu not between", value1, value2, "mtu");
            return (Criteria) this;
        }

        public Criteria andPublickeyIsNull() {
            addCriterion("publickey is null");
            return (Criteria) this;
        }

        public Criteria andPublickeyIsNotNull() {
            addCriterion("publickey is not null");
            return (Criteria) this;
        }

        public Criteria andPublickeyEqualTo(String value) {
            addCriterion("publickey =", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotEqualTo(String value) {
            addCriterion("publickey <>", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyGreaterThan(String value) {
            addCriterion("publickey >", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyGreaterThanOrEqualTo(String value) {
            addCriterion("publickey >=", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLessThan(String value) {
            addCriterion("publickey <", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLessThanOrEqualTo(String value) {
            addCriterion("publickey <=", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLike(String value) {
            addCriterion("publickey like", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotLike(String value) {
            addCriterion("publickey not like", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyIn(List<String> values) {
            addCriterion("publickey in", values, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotIn(List<String> values) {
            addCriterion("publickey not in", values, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyBetween(String value1, String value2) {
            addCriterion("publickey between", value1, value2, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotBetween(String value1, String value2) {
            addCriterion("publickey not between", value1, value2, "publickey");
            return (Criteria) this;
        }

        public Criteria andEndpointIsNull() {
            addCriterion("endpoint is null");
            return (Criteria) this;
        }

        public Criteria andEndpointIsNotNull() {
            addCriterion("endpoint is not null");
            return (Criteria) this;
        }

        public Criteria andEndpointEqualTo(String value) {
            addCriterion("endpoint =", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotEqualTo(String value) {
            addCriterion("endpoint <>", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointGreaterThan(String value) {
            addCriterion("endpoint >", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointGreaterThanOrEqualTo(String value) {
            addCriterion("endpoint >=", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLessThan(String value) {
            addCriterion("endpoint <", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLessThanOrEqualTo(String value) {
            addCriterion("endpoint <=", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLike(String value) {
            addCriterion("endpoint like", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotLike(String value) {
            addCriterion("endpoint not like", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointIn(List<String> values) {
            addCriterion("endpoint in", values, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotIn(List<String> values) {
            addCriterion("endpoint not in", values, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointBetween(String value1, String value2) {
            addCriterion("endpoint between", value1, value2, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotBetween(String value1, String value2) {
            addCriterion("endpoint not between", value1, value2, "endpoint");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsIsNull() {
            addCriterion("allowed_ips is null");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsIsNotNull() {
            addCriterion("allowed_ips is not null");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsEqualTo(String value) {
            addCriterion("allowed_ips =", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsNotEqualTo(String value) {
            addCriterion("allowed_ips <>", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsGreaterThan(String value) {
            addCriterion("allowed_ips >", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsGreaterThanOrEqualTo(String value) {
            addCriterion("allowed_ips >=", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsLessThan(String value) {
            addCriterion("allowed_ips <", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsLessThanOrEqualTo(String value) {
            addCriterion("allowed_ips <=", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsLike(String value) {
            addCriterion("allowed_ips like", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsNotLike(String value) {
            addCriterion("allowed_ips not like", value, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsIn(List<String> values) {
            addCriterion("allowed_ips in", values, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsNotIn(List<String> values) {
            addCriterion("allowed_ips not in", values, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsBetween(String value1, String value2) {
            addCriterion("allowed_ips between", value1, value2, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andAllowedIpsNotBetween(String value1, String value2) {
            addCriterion("allowed_ips not between", value1, value2, "allowedIps");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveIsNull() {
            addCriterion("persistent_keepalive is null");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveIsNotNull() {
            addCriterion("persistent_keepalive is not null");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveEqualTo(Long value) {
            addCriterion("persistent_keepalive =", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveNotEqualTo(Long value) {
            addCriterion("persistent_keepalive <>", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveGreaterThan(Long value) {
            addCriterion("persistent_keepalive >", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveGreaterThanOrEqualTo(Long value) {
            addCriterion("persistent_keepalive >=", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveLessThan(Long value) {
            addCriterion("persistent_keepalive <", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveLessThanOrEqualTo(Long value) {
            addCriterion("persistent_keepalive <=", value, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveIn(List<Long> values) {
            addCriterion("persistent_keepalive in", values, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveNotIn(List<Long> values) {
            addCriterion("persistent_keepalive not in", values, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveBetween(Long value1, Long value2) {
            addCriterion("persistent_keepalive between", value1, value2, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andPersistentKeepaliveNotBetween(Long value1, Long value2) {
            addCriterion("persistent_keepalive not between", value1, value2, "persistentKeepalive");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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