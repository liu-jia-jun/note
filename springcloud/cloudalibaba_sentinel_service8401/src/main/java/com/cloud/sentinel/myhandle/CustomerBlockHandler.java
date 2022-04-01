package com.cloud.sentinel.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.common.entities.CommonResult;

/**
 * @author 刘佳俊
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义的限流处理信息......CustomerBlockHandler");
    }
}