package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static volatile a iUA;
    public Map<String, List<IPCDynamicPageView>> iUB = new ConcurrentHashMap();
    public Map<String, a> iUC = new ConcurrentHashMap();

    private a() {
    }

    public static a ade() {
        if (iUA == null) {
            synchronized (a.class) {
                if (iUA == null) {
                    iUA = new a();
                }
            }
        }
        return iUA;
    }

    public final IPCDynamicPageView rv(String str) {
        if (str == null) {
            return null;
        }
        for (Entry entry : this.iUB.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : (List) entry.getValue()) {
                    if (iPCDynamicPageView.gOP != null && iPCDynamicPageView.gOP.equals(str)) {
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list = (List) this.iUB.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(iPCDynamicPageView);
        }
        if (list.isEmpty()) {
            this.iUB.remove(str);
        }
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list;
        List list2 = (List) this.iUB.get(str);
        if (list2 == null) {
            LinkedList linkedList = new LinkedList();
            this.iUB.put(str, linkedList);
            list = linkedList;
        } else {
            list = list2;
        }
        if (list.contains(iPCDynamicPageView)) {
            synchronized (list) {
                list.remove(iPCDynamicPageView);
                list.add(iPCDynamicPageView);
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                if (list.size() > 4) {
                    IPCDynamicPageView aa = aa(list);
                    if (aa != null) {
                        a aVar = (a) this.iUC.get(str);
                        if (aVar != null) {
                            aVar.a(str, aa);
                        }
                    }
                }
            }
        }
        return add;
    }

    private static IPCDynamicPageView aa(List<IPCDynamicPageView> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((IPCDynamicPageView) list.get(i)).isPaused()) {
                return (IPCDynamicPageView) list.remove(i);
            }
        }
        return null;
    }
}
