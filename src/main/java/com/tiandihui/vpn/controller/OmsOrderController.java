package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.OmsOrderDetail;
import com.tiandihui.vpn.domain.OrderParam;
import com.tiandihui.vpn.mbg.mapper.PmsSkuStockMapper;
import com.tiandihui.vpn.mbg.mapper.UmsProductMapper;
import com.tiandihui.vpn.mbg.model.PmsSkuStock;
import com.tiandihui.vpn.service.OmsVpnOrderService;
import com.tiandihui.vpn.service.UmsVpnProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    private OmsVpnOrderService vpnOrderService;

    @Autowired
    private UmsVpnProductService vpnProductService;

    public CommonResult recommendProductList() {
        Map<String,Object> result = new HashMap<>();
        List<PmsSkuStock> normalVipVpns = vpnProductService.normalVipVpnList();
        List<PmsSkuStock> superVipVpns = vpnProductService.superVipVpnList();
        result.put("normalVipList", normalVipVpns);
        result.put("superVipList",superVipVpns);
        return CommonResult.success(result);
    }


    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = vpnOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "下单成功");
    }

    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult paySuccess(@RequestParam Long orderId) {
        Integer count = vpnOrderService.paySuccess(orderId);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelTimeOutOrder() {
        vpnOrderService.cancelTimeOutOrder();
        return CommonResult.success(null);
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(@RequestParam Long orderId) {
        vpnOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }


    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getDetail(@RequestParam Long orderId) {
        OmsOrderDetail orderDetail = vpnOrderService.getDetail(orderId);
        return CommonResult.success(orderDetail);
    }

}
