package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class j extends f {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static j jch;
    private static HashSet<String> jci = new HashSet();

    public static synchronized void sf(String str) {
        synchronized (j.class) {
            jci.add(str);
        }
    }

    public static synchronized void sg(String str) {
        synchronized (j.class) {
            jci.remove(str);
        }
    }

    public static synchronized void onNetworkChange() {
        synchronized (j.class) {
            HashMap hashMap = new HashMap();
            Context context = ac.getContext();
            boolean isConnected = an.isConnected(context);
            hashMap.put("isConnected", Boolean.valueOf(isConnected));
            if (!isConnected) {
                hashMap.put("networkType", "none");
            } else if (an.is2G(context)) {
                hashMap.put("networkType", "2g");
            } else if (an.is3G(context)) {
                hashMap.put("networkType", "3g");
            } else if (an.is4G(context)) {
                hashMap.put("networkType", "4g");
            } else if (an.isWifi(context)) {
                hashMap.put("networkType", "wifi");
            } else {
                hashMap.put("networkType", "unknown");
            }
            Iterator it = jci.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (jch == null) {
                    jch = new j();
                }
                jch.az(str, 0).v(hashMap).afs();
            }
        }
    }
}
