package com.tiandihui.vpn.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsMemberStatisticsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberStatisticsInfoExample() {
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

        public Criteria andConsumeAmountIsNull() {
            addCriterion("consume_amount is null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNotNull() {
            addCriterion("consume_amount is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountEqualTo(BigDecimal value) {
            addCriterion("consume_amount =", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotEqualTo(BigDecimal value) {
            addCriterion("consume_amount <>", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThan(BigDecimal value) {
            addCriterion("consume_amount >", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount >=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThan(BigDecimal value) {
            addCriterion("consume_amount <", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount <=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIn(List<BigDecimal> values) {
            addCriterion("consume_amount in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotIn(List<BigDecimal> values) {
            addCriterion("consume_amount not in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount not between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNull() {
            addCriterion("coupon_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNotNull() {
            addCriterion("coupon_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCountEqualTo(Integer value) {
            addCriterion("coupon_count =", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotEqualTo(Integer value) {
            addCriterion("coupon_count <>", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThan(Integer value) {
            addCriterion("coupon_count >", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_count >=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThan(Integer value) {
            addCriterion("coupon_count <", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_count <=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIn(List<Integer> values) {
            addCriterion("coupon_count in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotIn(List<Integer> values) {
            addCriterion("coupon_count not in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count not between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountIsNull() {
            addCriterion("return_order_count is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountIsNotNull() {
            addCriterion("return_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountEqualTo(Integer value) {
            addCriterion("return_order_count =", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountNotEqualTo(Integer value) {
            addCriterion("return_order_count <>", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountGreaterThan(Integer value) {
            addCriterion("return_order_count >", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_order_count >=", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountLessThan(Integer value) {
            addCriterion("return_order_count <", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("return_order_count <=", value, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountIn(List<Integer> values) {
            addCriterion("return_order_count in", values, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountNotIn(List<Integer> values) {
            addCriterion("return_order_count not in", values, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("return_order_count between", value1, value2, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("return_order_count not between", value1, value2, "returnOrderCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNull() {
            addCriterion("login_count is null");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNotNull() {
            addCriterion("login_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCountEqualTo(Integer value) {
            addCriterion("login_count =", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotEqualTo(Integer value) {
            addCriterion("login_count <>", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThan(Integer value) {
            addCriterion("login_count >", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_count >=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThan(Integer value) {
            addCriterion("login_count <", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThanOrEqualTo(Integer value) {
            addCriterion("login_count <=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountIn(List<Integer> values) {
            addCriterion("login_count in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotIn(List<Integer> values) {
            addCriterion("login_count not in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountBetween(Integer value1, Integer value2) {
            addCriterion("login_count between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotBetween(Integer value1, Integer value2) {
            addCriterion("login_count not between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountIsNull() {
            addCriterion("attend_count is null");
            return (Criteria) this;
        }

        public Criteria andAttendCountIsNotNull() {
            addCriterion("attend_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttendCountEqualTo(Integer value) {
            addCriterion("attend_count =", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotEqualTo(Integer value) {
            addCriterion("attend_count <>", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountGreaterThan(Integer value) {
            addCriterion("attend_count >", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_count >=", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountLessThan(Integer value) {
            addCriterion("attend_count <", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountLessThanOrEqualTo(Integer value) {
            addCriterion("attend_count <=", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountIn(List<Integer> values) {
            addCriterion("attend_count in", values, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotIn(List<Integer> values) {
            addCriterion("attend_count not in", values, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountBetween(Integer value1, Integer value2) {
            addCriterion("attend_count between", value1, value2, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_count not between", value1, value2, "attendCount");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNull() {
            addCriterion("fans_count is null");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNotNull() {
            addCriterion("fans_count is not null");
            return (Criteria) this;
        }

        public Criteria andFansCountEqualTo(Integer value) {
            addCriterion("fans_count =", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotEqualTo(Integer value) {
            addCriterion("fans_count <>", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThan(Integer value) {
            addCriterion("fans_count >", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans_count >=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThan(Integer value) {
            addCriterion("fans_count <", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThanOrEqualTo(Integer value) {
            addCriterion("fans_count <=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountIn(List<Integer> values) {
            addCriterion("fans_count in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotIn(List<Integer> values) {
            addCriterion("fans_count not in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountBetween(Integer value1, Integer value2) {
            addCriterion("fans_count between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fans_count not between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountIsNull() {
            addCriterion("invite_friend_count is null");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountIsNotNull() {
            addCriterion("invite_friend_count is not null");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountEqualTo(Integer value) {
            addCriterion("invite_friend_count =", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountNotEqualTo(Integer value) {
            addCriterion("invite_friend_count <>", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountGreaterThan(Integer value) {
            addCriterion("invite_friend_count >", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_friend_count >=", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountLessThan(Integer value) {
            addCriterion("invite_friend_count <", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountLessThanOrEqualTo(Integer value) {
            addCriterion("invite_friend_count <=", value, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountIn(List<Integer> values) {
            addCriterion("invite_friend_count in", values, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountNotIn(List<Integer> values) {
            addCriterion("invite_friend_count not in", values, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountBetween(Integer value1, Integer value2) {
            addCriterion("invite_friend_count between", value1, value2, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andInviteFriendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_friend_count not between", value1, value2, "inviteFriendCount");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIsNull() {
            addCriterion("first_login_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIsNotNull() {
            addCriterion("first_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeEqualTo(Date value) {
            addCriterion("first_login_time =", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotEqualTo(Date value) {
            addCriterion("first_login_time <>", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeGreaterThan(Date value) {
            addCriterion("first_login_time >", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("first_login_time >=", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeLessThan(Date value) {
            addCriterion("first_login_time <", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("first_login_time <=", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIn(List<Date> values) {
            addCriterion("first_login_time in", values, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotIn(List<Date> values) {
            addCriterion("first_login_time not in", values, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeBetween(Date value1, Date value2) {
            addCriterion("first_login_time between", value1, value2, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("first_login_time not between", value1, value2, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeIsNull() {
            addCriterion("start_rec_member_time is null");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeIsNotNull() {
            addCriterion("start_rec_member_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeEqualTo(Date value) {
            addCriterion("start_rec_member_time =", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeNotEqualTo(Date value) {
            addCriterion("start_rec_member_time <>", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeGreaterThan(Date value) {
            addCriterion("start_rec_member_time >", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_rec_member_time >=", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeLessThan(Date value) {
            addCriterion("start_rec_member_time <", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_rec_member_time <=", value, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeIn(List<Date> values) {
            addCriterion("start_rec_member_time in", values, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeNotIn(List<Date> values) {
            addCriterion("start_rec_member_time not in", values, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeBetween(Date value1, Date value2) {
            addCriterion("start_rec_member_time between", value1, value2, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andStartRecMemberTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_rec_member_time not between", value1, value2, "startRecMemberTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Integer value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Integer value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Integer value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Integer value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Integer> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Integer> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Integer value1, Integer value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Integer value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Integer value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Integer value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Integer value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Integer value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Integer> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Integer> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Integer value1, Integer value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayIsNull() {
            addCriterion("last_connectway is null");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayIsNotNull() {
            addCriterion("last_connectway is not null");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayEqualTo(Integer value) {
            addCriterion("last_connectway =", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayNotEqualTo(Integer value) {
            addCriterion("last_connectway <>", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayGreaterThan(Integer value) {
            addCriterion("last_connectway >", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_connectway >=", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayLessThan(Integer value) {
            addCriterion("last_connectway <", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayLessThanOrEqualTo(Integer value) {
            addCriterion("last_connectway <=", value, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayIn(List<Integer> values) {
            addCriterion("last_connectway in", values, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayNotIn(List<Integer> values) {
            addCriterion("last_connectway not in", values, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayBetween(Integer value1, Integer value2) {
            addCriterion("last_connectway between", value1, value2, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andLastConnectwayNotBetween(Integer value1, Integer value2) {
            addCriterion("last_connectway not between", value1, value2, "lastConnectway");
            return (Criteria) this;
        }

        public Criteria andSsIdIsNull() {
            addCriterion("ss_id is null");
            return (Criteria) this;
        }

        public Criteria andSsIdIsNotNull() {
            addCriterion("ss_id is not null");
            return (Criteria) this;
        }

        public Criteria andSsIdEqualTo(Long value) {
            addCriterion("ss_id =", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdNotEqualTo(Long value) {
            addCriterion("ss_id <>", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdGreaterThan(Long value) {
            addCriterion("ss_id >", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ss_id >=", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdLessThan(Long value) {
            addCriterion("ss_id <", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdLessThanOrEqualTo(Long value) {
            addCriterion("ss_id <=", value, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdIn(List<Long> values) {
            addCriterion("ss_id in", values, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdNotIn(List<Long> values) {
            addCriterion("ss_id not in", values, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdBetween(Long value1, Long value2) {
            addCriterion("ss_id between", value1, value2, "ssId");
            return (Criteria) this;
        }

        public Criteria andSsIdNotBetween(Long value1, Long value2) {
            addCriterion("ss_id not between", value1, value2, "ssId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdIsNull() {
            addCriterion("wireguard_id is null");
            return (Criteria) this;
        }

        public Criteria andWireguardIdIsNotNull() {
            addCriterion("wireguard_id is not null");
            return (Criteria) this;
        }

        public Criteria andWireguardIdEqualTo(Long value) {
            addCriterion("wireguard_id =", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdNotEqualTo(Long value) {
            addCriterion("wireguard_id <>", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdGreaterThan(Long value) {
            addCriterion("wireguard_id >", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("wireguard_id >=", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdLessThan(Long value) {
            addCriterion("wireguard_id <", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdLessThanOrEqualTo(Long value) {
            addCriterion("wireguard_id <=", value, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdIn(List<Long> values) {
            addCriterion("wireguard_id in", values, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdNotIn(List<Long> values) {
            addCriterion("wireguard_id not in", values, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdBetween(Long value1, Long value2) {
            addCriterion("wireguard_id between", value1, value2, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andWireguardIdNotBetween(Long value1, Long value2) {
            addCriterion("wireguard_id not between", value1, value2, "wireguardId");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIsNull() {
            addCriterion("recent_order_time is null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIsNotNull() {
            addCriterion("recent_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeEqualTo(Date value) {
            addCriterion("recent_order_time =", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotEqualTo(Date value) {
            addCriterion("recent_order_time <>", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeGreaterThan(Date value) {
            addCriterion("recent_order_time >", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recent_order_time >=", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeLessThan(Date value) {
            addCriterion("recent_order_time <", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("recent_order_time <=", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIn(List<Date> values) {
            addCriterion("recent_order_time in", values, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotIn(List<Date> values) {
            addCriterion("recent_order_time not in", values, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeBetween(Date value1, Date value2) {
            addCriterion("recent_order_time between", value1, value2, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("recent_order_time not between", value1, value2, "recentOrderTime");
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