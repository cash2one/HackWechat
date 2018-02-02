package com.tencent.mm.modelcdntran;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.c;
import com.tencent.mm.ae.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class g implements ap {
    private b htf = null;
    private c htg = null;
    private c hth;
    private long hti = 0;
    private af htj = new 2(this, Looper.getMainLooper());
    private e htk = new 3(this);

    public static g MG() {
        return (g) p.s(g.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public static String MH() {
        com.tencent.mm.kernel.g.Dh().Ct();
        return com.tencent.mm.kernel.g.Dj().cachePath + "cdndnsinfo/";
    }

    public final void br(boolean z) {
    }

    public static c MI() {
        return MG().hth;
    }

    public final void bq(boolean z) {
        onAccountRelease();
        com.tencent.mm.kernel.g.Dh().Ct();
        if (MG().htg == null) {
            MG().htg = new c();
            x.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[]{Integer.valueOf(MG().htg.hashCode())});
        }
        File file = new File(MH());
        if (!file.exists()) {
            file.mkdir();
        }
        this.hth = new c(this) {
            final /* synthetic */ g htl;

            {
                this.htl = r1;
            }

            public final void a(jp jpVar, jp jpVar2, jp jpVar3) {
                x.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + jpVar.toString() + " getCore().engine:" + g.MK());
                if (g.MK() != null) {
                    g.MK().a(jpVar, jpVar2, jpVar3, null, null, null);
                    com.tencent.mm.kernel.g.Dm().F(new 1(this));
                }
            }
        };
        com.tencent.mm.kernel.g.CG().a(379, this.htk);
    }

    public static c MJ() {
        if (MG().htg == null) {
            synchronized (g.class) {
                if (MG().htg == null) {
                    MG().htg = new c();
                }
            }
        }
        return MG().htg;
    }

    public static b MK() {
        if (MG().htf == null) {
            com.tencent.mm.kernel.g.Dh();
            if (a.Cx()) {
                MG().htf = new b(com.tencent.mm.kernel.g.Dj().cachePath, MJ());
            } else {
                x.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", new Object[]{w.gZK + com.tencent.mm.a.g.s(("mm" + new Random().nextLong()).getBytes()) + "/"});
                MG().htf = new b(r0, MJ());
            }
        }
        return MG().htf;
    }

    public final void onAccountRelease() {
        this.hth = null;
        if (this.htf != null) {
            b bVar = this.htf;
            CdnLogic.setCallBack(null);
            bVar.hsi = null;
            this.htf = null;
        }
        if (this.htg != null) {
            Object obj = this.htg;
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                com.tencent.mm.kernel.g.Dj().CU().b(obj);
            }
            obj.hsp.removeCallbacksAndMessages(null);
            com.tencent.mm.kernel.g.Di().b(obj.hsr);
            com.tencent.mm.kernel.g.Di().gPJ.b(379, obj);
            com.tencent.mm.sdk.b.a.xef.c(obj.hsq);
            this.htg = null;
        }
        this.hti = 0;
        this.htj.removeCallbacksAndMessages(null);
        com.tencent.mm.kernel.g.CG().b(379, this.htk);
    }

    public final void ML() {
        hv(0);
    }

    public final void hv(int i) {
        this.hti = 0;
        this.htj.removeMessages(1);
        com.tencent.mm.kernel.g.CG().a(new e(i), 0);
    }
}
