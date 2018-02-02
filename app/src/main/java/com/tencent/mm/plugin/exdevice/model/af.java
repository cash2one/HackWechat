package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.a;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class af implements e {
    c gyH = new c<tl>(this) {
        final /* synthetic */ af lOa;

        {
            this.lOa = r2;
            this.xen = tl.class.getName().hashCode();
        }

        private boolean a(tl tlVar) {
            boolean z = true;
            if (tlVar instanceof tl) {
                switch (tlVar.fMa.fpr) {
                    case 1:
                        x.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[]{tlVar.fMa.ffq});
                        i.lMM.a(ac.getContext(), new 1(this, tlVar));
                        break;
                    case 3:
                        b zg = ad.aEk().zg(tlVar.fMa.ffq);
                        a aVar = tlVar.fMa;
                        if (zg == null) {
                            z = false;
                        }
                        aVar.fsH = z;
                        break;
                    case 4:
                        x.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[]{tlVar.fMa.ffq});
                        ar.CG().a(538, this.lOa);
                        ar.CG().a(new w(0, tlVar.fMa.frg, tlVar.fMa.ffq, f.aDO(), bh.Wp(), tlVar.fMa.data, 1), 0);
                        break;
                    case 7:
                        ar.CG().a(541, this.lOa);
                        ar.CG().a(new r("AndroidWear", tlVar.fMa.frg, tlVar.fMa.ffq, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!bh.bj(ac.getContext(), ac.getPackageName() + ":exdevice")) {
                            d.cy(ac.getContext());
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };

    static /* synthetic */ void ah(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b tlVar = new tl();
        tlVar.fMa.fpr = 2;
        tlVar.fMa.fsH = z;
        tlVar.fMa.ffq = str;
        com.tencent.mm.sdk.b.a.xef.m(tlVar);
    }

    public af() {
        com.tencent.mm.sdk.b.a.xef.b(this.gyH);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            ar.CG().b(541, this);
            r rVar = (r) kVar;
            if (i == 0 && i2 == 0) {
                af(rVar.lNd, true);
            } else {
                af(rVar.lNd, false);
            }
        } else if (kVar instanceof w) {
            ar.CG().b(538, this);
            w wVar = (w) kVar;
            if (i == 0 && i2 == 0) {
                ag(wVar.lNf, true);
            } else {
                ag(wVar.lNf, false);
            }
        }
    }

    private static void af(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b tlVar = new tl();
        tlVar.fMa.fpr = 8;
        tlVar.fMa.fsH = z;
        tlVar.fMa.ffq = str;
        com.tencent.mm.sdk.b.a.xef.m(tlVar);
    }

    private static void ag(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b tlVar = new tl();
        tlVar.fMa.fpr = 5;
        tlVar.fMa.fsH = z;
        tlVar.fMa.ffq = str;
        com.tencent.mm.sdk.b.a.xef.m(tlVar);
    }
}
