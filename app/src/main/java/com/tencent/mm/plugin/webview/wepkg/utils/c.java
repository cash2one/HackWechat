package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.tv.a;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.webview.wepkg.model.d;
import com.tencent.mm.plugin.webview.wepkg.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class c {
    public d tNY = new d();
    public final com.tencent.mm.sdk.b.c tNZ = new com.tencent.mm.sdk.b.c<tv>(this) {
        final /* synthetic */ c tOa;

        {
            this.tOa = r2;
            this.xen = tv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tv tvVar = (tv) bVar;
            boolean zK = ac.cfw() ? g.zZ().zK() : b.tNW;
            x.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[]{Integer.valueOf(tvVar.fMD.fpr)});
            switch (tvVar.fMD.fpr) {
                case 0:
                    if (!zK) {
                        d.Dm().F(new 1(this));
                        break;
                    }
                    break;
                case 1:
                    if (!zK) {
                        WepkgVersionManager.U(tvVar.fMD.fME, 1, 0);
                        break;
                    }
                    break;
                case 2:
                    if (!zK) {
                        a aVar = tvVar.fMD;
                        com.tencent.mm.plugin.webview.wepkg.a.d bVa = com.tencent.mm.plugin.webview.wepkg.a.d.bVa();
                        String str = tvVar.fMD.fME;
                        if (!bVa.iYd || bh.ov(str)) {
                            zK = false;
                        } else {
                            com.tencent.mm.plugin.webview.wepkg.a.c PR = bVa.PR(str);
                            zK = PR != null && PR.field_bigPackageReady && PR.field_preloadFilesReady;
                        }
                        aVar.fMF = zK;
                        break;
                    }
                    break;
                case 3:
                    if (ac.cfw()) {
                        com.tencent.mm.plugin.webview.wepkg.model.b.bVi().bVj();
                        break;
                    }
                    break;
                case 4:
                    if (!zK) {
                        WepkgVersion Qj = h.Qj(tvVar.fMD.fME);
                        if (Qj != null) {
                            tvVar.fMD.fMG = Qj.tNL;
                            x.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[]{Integer.valueOf(tvVar.fMD.fMG)});
                            break;
                        }
                    }
                    break;
                case 5:
                    if (!zK && ac.cfw() && bh.by(Long.valueOf(bh.c((Long) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xvV, Long.valueOf(0)))).longValue()) > 1800) {
                        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xvV, Long.valueOf(bh.Wo()));
                        b tvVar2 = new tv();
                        tvVar2.fMD.fpr = 0;
                        com.tencent.mm.sdk.b.a.xef.m(tvVar2);
                        break;
                    }
                case 6:
                    if (!bh.ov(tvVar.fMD.fME)) {
                        com.tencent.mm.plugin.webview.wepkg.model.g.Qe(tvVar.fMD.fME);
                        break;
                    }
                    com.tencent.mm.plugin.webview.wepkg.model.g.Qe(null);
                    break;
            }
            return false;
        }
    };
}
