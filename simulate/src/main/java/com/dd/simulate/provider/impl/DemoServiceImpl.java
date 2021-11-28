package com.dd.simulate.provider.impl;

import com.dd.simulate.provider.api.DemoService;

/**
 * @author Bryce_dd 2021/11/28 23:43
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo(String args) {
        return "resp:" + args;
    }
}
