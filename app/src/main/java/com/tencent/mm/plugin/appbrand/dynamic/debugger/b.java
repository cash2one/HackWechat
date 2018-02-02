package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.mm.modelappbrand.h.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<a>> gMS = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> iSV = new ConcurrentHashMap();

    public static DebuggerInfo rr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (DebuggerInfo) iSV.get(str);
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        if (str != null && str.length() != 0) {
            iSV.put(str, debuggerInfo);
        }
    }

    public static boolean c(String str, a aVar) {
        if (bh.ov(str) || aVar == null) {
            return false;
        }
        List list = (List) gMS.get(str);
        if (list == null) {
            list = new LinkedList();
            gMS.put(str, list);
        } else if (list.contains(aVar)) {
            return true;
        }
        return list.add(aVar);
    }

    public static boolean d(String str, a aVar) {
        if (bh.ov(str) || aVar == null) {
            return false;
        }
        List list = (List) gMS.get(str);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            gMS.remove(str);
        }
        return remove;
    }

    public static void B(String str, int i) {
        if (!bh.ov(str)) {
            List list = (List) gMS.get(str);
            if (list != null) {
                for (a hg : new LinkedList(list)) {
                    hg.hg(i);
                }
            }
        }
    }
}
