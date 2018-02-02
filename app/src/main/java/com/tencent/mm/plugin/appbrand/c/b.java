package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public a hBx = new 1(this);
    public Vector<com.tencent.mm.plugin.appbrand.c.d.b> iLA = new Vector();
    public Vector<d.a> iLB = new Vector();
    public HashMap<String, c> iLC = new HashMap();
    public j.a iLD = new 2(this);

    static /* synthetic */ void a(b bVar, boolean z, String str, String str2, String str3) {
        if (bVar.iLA != null && bVar.iLA.size() > 0) {
            Iterator it = bVar.iLA.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.appbrand.c.d.b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.c.d.b bVar) {
        if (this.iLA != null && bVar != null) {
            this.iLA.remove(bVar);
        }
    }

    public final void a(d.a aVar) {
        if (this.iLB != null && aVar != null) {
            this.iLB.remove(aVar);
        }
    }

    public static boolean qh(String str) {
        a qj = f.Zq().qj(str);
        if (qj != null) {
            return g.MJ().kH(qj.mediaId);
        }
        x.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public final void qi(String str) {
        this.iLC.remove(str);
    }
}
