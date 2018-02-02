package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c gMT;
    Map<String, List<e>> gMU = new ConcurrentHashMap();

    public static c Bz() {
        if (gMT == null) {
            synchronized (c.class) {
                if (gMT == null) {
                    gMT = new c();
                }
            }
        }
        return gMT;
    }

    private c() {
    }

    public final boolean b(String str, Bundle bundle) {
        if (str == null || str.length() == 0 || bundle == null) {
            return false;
        }
        List list = (List) this.gMU.get(str);
        if (list == null || list.isEmpty()) {
            return true;
        }
        synchronized (list) {
            List<e> arrayList = new ArrayList(list);
        }
        for (e as : arrayList) {
            as.as(bundle);
        }
        return true;
    }

    public final boolean a(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.gMU.get(str);
        if (list == null) {
            list = new LinkedList();
            this.gMU.put(str, list);
        }
        if (list.contains(eVar)) {
            return false;
        }
        boolean add;
        synchronized (list) {
            add = list.add(eVar);
        }
        return add;
    }

    public final boolean b(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.gMU.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(eVar);
        }
        if (list.isEmpty()) {
            this.gMU.remove(str);
        }
        return remove;
    }
}
