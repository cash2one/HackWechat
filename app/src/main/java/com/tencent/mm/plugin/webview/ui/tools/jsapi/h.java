package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static final SparseArray<g> tJE = new SparseArray();
    private static volatile g tJF = null;

    private h() {
    }

    @Deprecated
    public static g bUM() {
        if (tJF == null) {
            tJF = new g(0);
        }
        return tJF;
    }

    public static g Be(int i) {
        g gVar;
        synchronized (h.class) {
            if (tJE.get(i) == null) {
                tJE.put(i, new g(i));
            }
            gVar = (g) tJE.get(i);
            tJF = gVar;
        }
        return gVar;
    }

    public static void detach() {
        x.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (h.class) {
            for (int i = 0; i < tJE.size(); i++) {
                g gVar = (g) tJE.valueAt(i);
                int keyAt = tJE.keyAt(i);
                if (gVar != null) {
                    a.bRp().Aq(keyAt);
                }
            }
            tJE.clear();
        }
        if (tJF != null) {
            a.bRp().Aq(0);
            tJF = null;
        }
    }
}
