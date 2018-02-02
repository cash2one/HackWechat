package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.dz;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a {
    private static final SparseArray<a> tts = new SparseArray();
    private static volatile b ttt = null;
    private static final byte[] ttu = new byte[0];
    public final String appId;
    public final String path;
    public final b ttr = bRj();

    private static final class a extends dz {
        private static final com.tencent.mm.sdk.e.c.a iGc = vJ();

        private a() {
        }

        protected final com.tencent.mm.sdk.e.c.a Ac() {
            return iGc;
        }
    }

    public static com.tencent.mm.plugin.webview.modelcache.d.a bRi() {
        return new com.tencent.mm.plugin.webview.modelcache.d.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[]{i.a(dz.vJ(), "WebViewCacheAppIdOccupation")});
    }

    public static a Ox(String str) {
        if (bh.ov(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) tts.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            tts.put(hashCode, aVar);
            return aVar;
        }
        FileOp.mh(aVar.path);
        return aVar;
    }

    static void clearCache() {
        tts.clear();
    }

    private static b bRj() {
        if (!ar.Hj()) {
            return new b(null);
        }
        b bVar;
        synchronized (ttu) {
            if (ttt == null || !ttt.iYd) {
                ar.Hg();
                ttt = new b(c.EV());
            }
            bVar = ttt;
        }
        return bVar;
    }

    private a(String str) {
        this.appId = str;
        FileOp.mh(e.gHG + "sfs");
        this.path = e.gHG + String.valueOf(str.hashCode());
        FileOp.mh(this.path);
    }
}
