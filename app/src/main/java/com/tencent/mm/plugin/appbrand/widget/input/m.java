package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum m {
    ;
    
    public static final Map<String, Integer> jXN = null;
    public static final Set<String> jXO = null;
    private static final Map<Integer, WeakReference<y>> jXP = null;
    private static final a<p, z> jXQ = null;

    static {
        Set hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        jXO = Collections.unmodifiableSet(hashSet);
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        jXN = Collections.unmodifiableMap(hashMap);
        jXP = new HashMap();
        jXQ = new a();
    }

    public static void m(p pVar) {
        if (pVar != null) {
            j jVar = new j(pVar);
        }
    }

    static void a(int i, y yVar) {
        if (yVar != null) {
            c.runOnUiThread(new 1(i, yVar));
        }
    }

    static y lV(int i) {
        WeakReference weakReference = (WeakReference) jXP.get(Integer.valueOf(i));
        return weakReference == null ? null : (y) weakReference.get();
    }

    public static void a(p pVar, String str, Integer num) {
        if (pVar != null) {
            c.runOnUiThread(new 2(pVar, str, num));
        }
    }

    @Deprecated
    public static boolean a(h hVar, int i) {
        WeakReference weakReference = (WeakReference) jXP.get(Integer.valueOf(i));
        y yVar = weakReference == null ? null : (y) weakReference.get();
        AppBrandInputInvokeHandler appBrandInputInvokeHandler = yVar instanceof AppBrandInputInvokeHandler ? (AppBrandInputInvokeHandler) yVar : null;
        return appBrandInputInvokeHandler != null && appBrandInputInvokeHandler.updateInput(hVar);
    }

    public static boolean n(p pVar) {
        return a(pVar, null);
    }

    public static boolean a(p pVar, Integer num) {
        if (num == null) {
            z zVar = (z) jXQ.get(pVar);
            if (zVar == null) {
                return false;
            }
            num = Integer.valueOf(zVar.getInputId());
        }
        y lV = lV(num.intValue());
        return lV != null && lV.hideKeyboard();
    }

    public static boolean a(p pVar, int i, int i2, int i3) {
        y lV = lV(i);
        return lV != null && lV.isAttachedTo(pVar) && lV.showKeyboard(i2, i3);
    }

    public static void o(p pVar) {
        ag.y(new 3(pVar));
    }

    public static boolean lW(int i) {
        y lV = lV(i);
        return lV != null && lV.removeSelf();
    }

    static void a(p pVar, z zVar) {
        if (pVar != null) {
            c.runOnUiThread(new 4(pVar, zVar));
        }
    }

    static void p(p pVar) {
        if (pVar != null) {
            c.runOnUiThread(new 5(pVar));
        }
    }

    static y q(p pVar) {
        if (pVar == null) {
            return null;
        }
        z zVar = (z) jXQ.get(pVar);
        if (zVar == null) {
            return null;
        }
        return lV(zVar.getInputId());
    }
}
