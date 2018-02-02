package com.tencent.smtt.utils;

import java.util.Map;
import java.util.Map.Entry;

public final class s {
    public b Abr = null;
    public b Abs = null;

    public static boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.iFr == null || bVar2 == null || bVar2.iFr == null) {
            return false;
        }
        Map map = bVar.iFr;
        Map map2 = bVar2.iFr;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!map2.containsKey(str)) {
                return false;
            }
            a aVar2 = (a) map2.get(str);
            if (aVar.lsw == aVar2.lsw) {
                if (aVar.Abt != aVar2.Abt) {
                }
            }
            return false;
        }
        return true;
    }
}
