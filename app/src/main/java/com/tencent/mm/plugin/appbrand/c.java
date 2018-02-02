package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> ipZ = new HashMap();
    private static Map<String, c> iqa = new HashMap();
    private static Map<String, Set<b>> iqb = new ConcurrentHashMap();

    public static class b {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void a(c cVar) {
        }

        public void onResume() {
        }
    }

    public static void a(String str, b bVar) {
        if (str != null && bVar != null) {
            if (!iqb.containsKey(str)) {
                iqb.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
            }
            ((Set) iqb.get(str)).add(bVar);
        }
    }

    private static Iterator<b> oW(String str) {
        Map map = iqb;
        if (str == null) {
            str = "";
        }
        Set set = (Set) map.get(str);
        if (set == null) {
            set = new HashSet();
        }
        return set.iterator();
    }

    public static void oX(String str) {
        Iterator oW = oW(str);
        while (oW.hasNext()) {
            ((b) oW.next()).onCreate();
        }
    }

    public static void oY(String str) {
        Iterator oW = oW(str);
        while (oW.hasNext()) {
            ((b) oW.next()).onDestroy();
        }
    }

    public static void oZ(String str) {
        Iterator oW = oW(str);
        while (oW.hasNext()) {
            ((b) oW.next()).a(pe(str));
        }
    }

    public static void pa(String str) {
        Iterator oW = oW(str);
        while (oW.hasNext()) {
            ((b) oW.next()).onResume();
        }
    }

    public static void pb(String str) {
        Iterator oW = oW(str);
        while (oW.hasNext()) {
            oW.next();
        }
    }

    public static void b(String str, b bVar) {
        if (bVar != null) {
            Set set = (Set) iqb.get(str);
            if (set != null && !set.isEmpty()) {
                set.remove(bVar);
            }
        }
    }

    public static void pc(String str) {
        iqb.remove(str);
    }

    public static void pd(String str) {
        a(str, c.iql);
    }

    public static c pe(String str) {
        c cVar = (c) iqa.get(str);
        if (cVar == null) {
            return c.iql;
        }
        return cVar;
    }

    public static void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            iqa.put(str, cVar);
        }
    }

    public static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            ipZ.put(str, aVar);
        }
    }

    public static a pf(String str) {
        a aVar = (a) ipZ.get(str);
        if (aVar == null) {
            return a.iqc;
        }
        return aVar;
    }
}
