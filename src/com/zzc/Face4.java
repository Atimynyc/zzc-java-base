/*
package com.zzc;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import jdk.jfr.TransitionTo;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

// 输入一个字符串，其中只包含'(', ')', '{', '}', '['和']'，判断其中的括号顺序是否依次成对出现，括号本身无优先级。
public class Face4 {


    // 校验顺序，第二个，校验成对
    // 1. 校验顺序，如果，判断），}， 】 在前面且没读过
    public static void main(String[] args) {

        String s = "755(){}[]";

        int[] nums = {};
        System.out.println(getLargestSonSum());
    }

    //
    private static boolean judgePair(char[] chars) {
        boolean smallTag = false;
        boolean middleTag = false;
        boolean largeTag = false;

        for (char c : chars) {
            if (c == '(') {
                smallTag = true;
            } else if (c == ')') {
                if (!smallTag) {
                    return false;
                }
                smallTag = false;
            }

            if (c == '{') {
                middleTag = true;
            } else if (c == '}') {
                if (!middleTag) {
                    return false;
                }
                middleTag = false;
            }

            if (c == '[') {
                largeTag = true;
            } else if (c == ']') {
                if (!largeTag) {
                    return false;
                }
                largeTag = false;
            }


        }

        return true;
    }


    // 2.给定一个数组，例如 [−2,1,−3,4,−1,2,1,−5,4], 计算最大连续子序列和；
    private static int getLargestSonSum(int[] nums) {
        int length = nums.length;
        // 计算前缀和
        int[] sums = new int[nums.length];
        for (int i = 1; i < length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        // 假设最大连续子序列长度是k, k -> 1 到 length
        // 计算出所有序列长度的情况下的子序列h和
        for (int k = 1; k < length; k++) {
            int temp = k;
            for (int j = 0 ; j < length; j++) {
                max = Math.max(max, sums[temp++] - sums[j]);
            }
        }
        return max;
    }

    @Resource("DataSource1")
    private AccountService accountService1;

    @Resource("DataSource2")
    private AccountSerivce accountService2;

    private TransferOrderService transferOrderService;

    // 完成A用户转账给B用户的功能，请进行接口设计，并实现其内部逻辑。
    //(注意：2个用户的账户不再同一个数据库下，接口发布后会暴露给外部应用进行服务调用，
    //请考虑接口规范、安全、幂等、重试、并发、有可能的异常分支、事务一致性、资金安全等的处理。)
    @Transactional
    public boolean transfer(int accountAID, int accountBID, int numberNum) {
        Long uuid = UUID.randomUUID();
        try {
            Account searchAccount = new Account();
            searchAccount.setAccountId(accountA);

            Account accountA = accountService.findById(accountAID);
            if (accountA == null) {
                return false;
            }
            Account accountB = accountService2.findById(accountBID);
            if (accountB == null) {
                return false;
            }


            TransferOrder transferOrder = new TransferOrder();
            transferOrder.setUUID(UUID.randomUUID());
            transferOrder.setProvider(accountAID);
            transferOrder.setReceiver(accountBID);
            transferOrder.setTransferNumber(numberNum);
            transferOrder.setStatus("start");
            transferOrderService.insert(transferOrder);


            TransferOrder updateTransfer = new TransferOrder();
            updateTransfer.setUUID(uuid);
            updateTransfer.setStatus("working");
            transferOrderService.updateByUUID(updateTransfer);
            accountA.setMoney(accountA.getMoney() - numberNum);
            accountB.setMoney(accountB.getMoney() + numberNum);

            accountService1.updateById(accountA);
            accountService2.updateById(accountB);


            updateTransfer.setStatus("success");
            transferOrderService.updateByUUID(updateTransfer);
            return true;
        } catch (Exception e) {
            TransferOrder updateTransfer = new TransferOrder();
            updateTransfer.setUUID(uuid);
            updateTransfer.setStatus("fail");
            transferOrderService.updateByUUID(updateTransfer);
            throw new Exception();
        }
    }





}
*/
