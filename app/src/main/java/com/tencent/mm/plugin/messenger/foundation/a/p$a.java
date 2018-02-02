package com.tencent.mm.plugin.messenger.foundation.a;

import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class p$a {
    private static ConcurrentHashMap<Integer, p> ooL = new ConcurrentHashMap();

    public static void a(int i, p pVar) {
        Assert.assertTrue(ooL.get(Integer.valueOf(i)) == null);
        ooL.put(Integer.valueOf(i), pVar);
    }

    public static p st(int i) {
        return (p) ooL.get(Integer.valueOf(i));
    }
}
