package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class d {
    private static Object lock = new Object();
    public static d tLQ;
    HashMap<String, c> tLR = new HashMap();

    public static d bVe() {
        if (tLQ == null) {
            synchronized (lock) {
                if (tLQ == null) {
                    tLQ = new d();
                }
            }
        }
        return tLQ;
    }

    public final boolean Qa(String str) {
        if (this.tLR.containsKey(str)) {
            this.tLR.remove(str);
        }
        return true;
    }

    private boolean a(c cVar) {
        if (!this.tLR.containsKey(cVar.tLH.tMe)) {
            return false;
        }
        cVar.tLN = true;
        try {
            if (cVar.tLJ != null) {
                cVar.tLJ.disconnect();
            }
            if (cVar.tLI != null) {
                cVar.tLI.cancel(false);
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e.getMessage());
        }
        this.tLR.remove(cVar.tLH.tMe);
        return true;
    }

    public final boolean bVf() {
        if (this.tLR == null || this.tLR.size() == 0) {
            return false;
        }
        c cVar;
        Collection<c> values = this.tLR.values();
        ArrayList arrayList = new ArrayList();
        for (c cVar2 : values) {
            arrayList.add(cVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cVar2 = (c) it.next();
            if (cVar2.tLH.tMj) {
                a(cVar2);
            }
        }
        arrayList.clear();
        return true;
    }
}
