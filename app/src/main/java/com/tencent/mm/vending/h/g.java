package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> zCS = new ConcurrentHashMap();
    private static Map<Looper, d> zCT = new HashMap();
    private static boolean zCU = false;

    static {
        czZ();
    }

    public static void a(String str, d dVar) {
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase();
        if (zCS.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase());
        }
        zCS.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                zCT.put(((h) dVar).mLooper, dVar);
            }
        }
    }

    public static void aao(String str) {
        zCS.remove(str.toUpperCase());
    }

    public static d aap(String str) {
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) zCS.get(str.toUpperCase());
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(), dVar);
        return dVar;
    }

    public static synchronized d czY() {
        d cVar;
        synchronized (g.class) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
            } else {
                cVar = (d) zCT.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    zCT.put(myLooper, cVar);
                }
            }
        }
        return cVar;
    }

    static synchronized void czZ() {
        synchronized (g.class) {
            if (!zCU) {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                zCU = true;
                a("Vending.UI", d.zCO);
                a("Vending.LOGIC", d.zCP);
                a("Vending.HEAVY_WORK", d.zCQ);
            }
        }
    }
}
