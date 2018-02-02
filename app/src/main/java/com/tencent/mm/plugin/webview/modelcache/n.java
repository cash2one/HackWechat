package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;

public final class n {
    public final a ttH = new 1(this);
    public final c ttI = new c<tq>(this) {
        final /* synthetic */ n ttK;

        {
            this.ttK = r2;
            this.xen = tq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tq tqVar = (tq) bVar;
            if (!(tqVar == null || !(tqVar instanceof tq) || bh.ov(tqVar.fMl.fCs))) {
                x.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
            }
            return false;
        }
    };
    public final c ttJ = new 3(this);

    public static void bRn() {
        com.tencent.mm.z.c Hg;
        try {
            Hg = ar.Hg();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewCacheSubCoreToolsExtension", "setupSFS, getAccStg, exception = %s", new Object[]{e});
            Hg = null;
        }
        if (Hg != null) {
            FileOp.mh(e.gHG + "sfs");
            FileOp.a(e.gHG, null, new Builder().setDBDirectory(com.tencent.mm.z.c.FB() + "sfs").setStoragePath(e.gHG + "sfs").setName("wvcache"));
        }
    }
}
