package com.tencent.mm.plugin.report.service;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class i implements ap {
    private static HashMap<Integer, d> kHz;
    private a kHB;
    private c pRe = new c<l>(this) {
        final /* synthetic */ i pRf;

        {
            this.pRf = r2;
            this.xen = l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((l) bVar).fnh.fni && !g.Dh().Cy()) {
                x.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        kHz = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return com.tencent.mm.plugin.report.a.b.gJN;
            }
        });
    }

    public final void onAccountRelease() {
        if (boo() != null) {
            i boo = boo();
            if (boo.kHB != null) {
                boo.kHB.iV(boo.hashCode());
                boo.kHB = null;
            }
        }
        com.tencent.mm.sdk.b.a.xef.c(this.pRe);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.kHB = com.tencent.mm.platformtools.g.a(hashCode(), g.Dj().cachePath + "CommonOneMicroMsg.db", kHz, false);
        x.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bh.cgy());
        com.tencent.mm.sdk.b.a.xef.b(this.pRe);
        g.Dk();
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ i pRf;

            {
                this.pRf = r1;
            }

            public final void run() {
                if (g.Dh().Cy()) {
                    bh.g(g.Dj().cachePath + "logcat/", "temp_", 10800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void br(boolean z) {
    }

    private static i boo() {
        return (i) p.s(i.class);
    }
}
