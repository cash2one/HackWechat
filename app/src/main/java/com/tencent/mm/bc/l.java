package com.tencent.mm.bc;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private static Map<String, Long> hLk = new HashMap();
    private static Map<String, Long> hLl = new HashMap();
    private static Map<String, Long> hLm = new HashMap();
    private static Map<String, Long> hLn = new HashMap();

    public static void lV(String str) {
        x.i("SearchWidgetStartTrace", "recv rsp widget %s", new Object[]{str});
        hLk.put(str, Long.valueOf(System.currentTimeMillis()));
        g.pQN.h(717, 1);
    }

    public static void lW(String str) {
        x.i("SearchWidgetStartTrace", "jsapiInsertWidget %s", new Object[]{str});
        g.pQN.h(717, 19);
    }

    public static void lX(String str) {
        x.i("SearchWidgetStartTrace", "realInsert %s", new Object[]{str});
        g.pQN.h(717, 3);
    }

    public static void E(String str, boolean z) {
        x.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            g.pQN.h(717, 0);
            long longValue = hLk.containsKey(str) ? ((Long) hLk.get(str)).longValue() : 0;
            if (longValue > 0) {
                int floor = (int) Math.floor((((double) (System.currentTimeMillis() - longValue)) * 1.0d) / 500.0d);
                if (floor > 16) {
                    floor = 16;
                }
                x.i("SearchWidgetStartTrace", "report time cost id %d, key %d", new Object[]{Long.valueOf(718), Integer.valueOf(floor)});
                g.pQN.h(718, (long) floor);
                return;
            }
            x.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[]{str});
            return;
        }
        g.pQN.h(717, 22);
    }

    public static void Rg() {
        x.i("SearchWidgetStartTrace", "hasInitData %s", new Object[]{Boolean.valueOf(true)});
        g.pQN.h(717, 20);
    }
}
