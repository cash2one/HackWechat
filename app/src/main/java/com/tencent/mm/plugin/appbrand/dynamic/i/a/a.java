package com.tencent.mm.plugin.appbrand.dynamic.i.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Long> hLk = new HashMap();
    private static Map<String, Long> hLl = new HashMap();
    private static Map<String, Long> hLm = new HashMap();
    private static Map<String, Long> hLn = new HashMap();

    public static void rx(String str) {
        x.i("SearchWidgetStartTraceFramework", "startLaunch %s", new Object[]{str});
        hLl.put(str, Long.valueOf(System.currentTimeMillis()));
        g.pQN.h(717, 4);
    }

    public static void ry(String str) {
        x.i("SearchWidgetStartTraceFramework", "endLaunch %s", new Object[]{str});
        g.pQN.h(717, 5);
        long longValue = hLl.containsKey(str) ? ((Long) hLl.get(str)).longValue() : 0;
        if (longValue > 0) {
            n(719, System.currentTimeMillis() - longValue);
        } else {
            x.e("SearchWidgetStartTraceFramework", "can't find widget launch timestamp for appid %s", new Object[]{str});
        }
        hLl.remove(str);
    }

    public static void rz(String str) {
        x.i("SearchWidgetStartTraceFramework", "startGetReleaseUrl %s", new Object[]{str});
        hLm.put(str, Long.valueOf(System.currentTimeMillis()));
        g.pQN.h(717, 7);
    }

    public static void R(String str, boolean z) {
        x.i("SearchWidgetStartTraceFramework", "endGetReleaseUrl %s", new Object[]{str});
        if (z) {
            g.pQN.h(717, 8);
            long longValue = hLm.containsKey(str) ? ((Long) hLm.get(str)).longValue() : 0;
            if (longValue > 0) {
                n(720, System.currentTimeMillis() - longValue);
            } else {
                x.e("SearchWidgetStartTraceFramework", "can't find widget get release url timestamp for appid %s", new Object[]{str});
            }
        } else {
            g.pQN.h(717, 9);
        }
        hLm.remove(str);
    }

    private static void n(long j, long j2) {
        int i = 6;
        int floor = (int) Math.floor((1.0d * ((double) j2)) / 500.0d);
        if (floor <= 6) {
            i = floor;
        }
        x.i("SearchWidgetStartTraceFramework", "report time cost id %d, key %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        g.pQN.h(j, (long) i);
    }

    public static void rA(String str) {
        x.i("SearchWidgetStartTraceFramework", "syncLaunch %s", new Object[]{str});
        g.pQN.h(717, 23);
    }

    public static void rB(String str) {
        x.i("SearchWidgetStartTraceFramework", "asyncLaunch %s", new Object[]{str});
        g.pQN.h(717, 24);
    }
}
