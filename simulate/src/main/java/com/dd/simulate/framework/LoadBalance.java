package com.dd.simulate.framework;

import java.util.List;
import java.util.Random;

/**
 * @author Bryce_dd 2021/11/29 23:58
 */
public class LoadBalance {
    public static URL random(List<URL> list) {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
