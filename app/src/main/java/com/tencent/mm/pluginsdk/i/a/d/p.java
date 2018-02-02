package com.tencent.mm.pluginsdk.i.a.d;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.i.a.b.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class p {
    private static final HashMap<Integer, g> vhY;
    private static volatile List<g> vhZ = null;

    static {
        HashMap hashMap = new HashMap(2);
        vhY = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new a());
        try {
            vhY.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", e, "", new Object[0]);
        }
    }

    public static void init() {
    }

    public static Collection<g> bZD() {
        if (vhZ != null) {
            return vhZ;
        }
        List linkedList = new LinkedList();
        for (Integer intValue : vhY.keySet()) {
            g gVar = (g) vhY.get(Integer.valueOf(intValue.intValue()));
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        vhZ = linkedList;
        return linkedList;
    }
}
