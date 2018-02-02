package com.tencent.mm.z;

import com.tencent.mm.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public byte[] hev;
    public long hew = -1;

    public final int EO() {
        return this.hev == null ? -1 : this.hev.length;
    }

    public a() {
        if (EP()) {
            ag.h(new Runnable(this) {
                final /* synthetic */ a hex;

                {
                    this.hex = r1;
                }

                public final void run() {
                    try {
                        if (a.EP()) {
                            d.pPH.a(226, 1, 1, false);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", bh.i(e));
                    }
                }
            }, 5000);
        }
    }

    public static boolean EP() {
        if (com.tencent.mm.kernel.a.Cs() || !g.Dh().Cy()) {
            return false;
        }
        int i = bh.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("AndroidUseWorkerAuthCache"), 0);
        g.Dk();
        g.Dh();
        int aJ = h.aJ(com.tencent.mm.kernel.a.Cg(), 100);
        boolean ceK = b.ceK();
        r7 = new Object[5];
        g.Dk();
        g.Dh();
        r7[2] = Integer.valueOf(com.tencent.mm.kernel.a.Cg());
        r7[3] = Integer.valueOf(aJ);
        r7[4] = Boolean.valueOf(g.Dh().Cy());
        x.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (ceK) {
            return true;
        }
        if (i > aJ) {
            return true;
        }
        return false;
    }

    public static void EQ() {
        if (EP()) {
            try {
                g.Dk();
                a aVar = g.Dh().gPn;
                g.Dk();
                c Kx = g.Di().gPJ.hmV.Kx();
                long Wp = bh.Wp();
                if (Kx == null) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    d.pPH.a(226, 2, 1, false);
                    return;
                }
                x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(Kx.Kt()), Integer.valueOf(aVar.EO()));
                if (Kx.Kt()) {
                    aVar.hev = Kx.Kw();
                    d.pPH.a(226, aVar.EO() > 0 ? 4 : 5, 1, false);
                    x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(bh.bz(Wp)), Integer.valueOf(aVar.EO()), Long.valueOf(aVar.hew));
                    if (aVar.EO() > 0) {
                        d.pPH.a(226, 31 - (aVar.hew > 5 ? 5 : aVar.hew), 1, false);
                        d.pPH.h(11098, Integer.valueOf(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.hew));
                        aVar.hew = -1;
                        return;
                    }
                    return;
                }
                d.pPH.a(226, 3, 1, false);
                x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
            } catch (Throwable th) {
                x.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bh.i(th));
            }
        }
    }
}
