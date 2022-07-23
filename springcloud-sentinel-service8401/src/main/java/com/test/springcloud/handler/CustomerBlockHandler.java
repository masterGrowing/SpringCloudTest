package com.test.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;

/**
 * @Author L*2
 * @Date 2022/5/27 10:22
 * @Description：
 */
public class CustomerBlockHandler {

    //注意：必须是static！！！
    public static CommentResult blockException1(BlockException exception){
        return new CommentResult(444,"failed!!!",new Payment(2,"good"));
    }
    public static CommentResult blockException2(BlockException exception){
        return new CommentResult(4444,"jj",new Payment(2,"good"));
    }
}
