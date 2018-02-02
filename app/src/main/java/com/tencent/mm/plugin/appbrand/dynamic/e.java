package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e iRY;
    public Map<String, WeakReference<View>> iRZ = new ConcurrentHashMap();

    private e() {
    }

    public static e acF() {
        if (iRY == null) {
            synchronized (e.class) {
                if (iRY == null) {
                    iRY = new e();
                }
            }
        }
        return iRY;
    }

    public final View rn(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            return null;
        }
        WeakReference weakReference = (WeakReference) this.iRZ.get(str);
        return weakReference != null ? (View) weakReference.get() : null;
    }
}
