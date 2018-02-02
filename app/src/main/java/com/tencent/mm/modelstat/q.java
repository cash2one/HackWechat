package com.tencent.mm.modelstat;

import com.tencent.mm.by.h.d;
import com.tencent.mm.cd.c;
import com.tencent.mm.cd.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class q implements ap {
    private static HashMap<Integer, d> gwY;
    private l hSO = new l();
    private g<m> hSP = new g(new c<m>(this) {
        final /* synthetic */ q hSS;

        {
            this.hSS = r1;
        }

        public final /* synthetic */ Object get() {
            return new m(com.tencent.mm.kernel.g.Dj().gQj);
        }
    });
    private x hSQ = new x();
    private g<g> hSR = new g(new 2(this));
    private n hsr = new a(this) {
        final /* synthetic */ q hSS;

        {
            this.hSS = r1;
        }

        public final void eq(int i) {
            if (i == 4 || i == 6) {
                com.tencent.mm.kernel.g.Dm().g(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 hST;

                    {
                        this.hST = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.kernel.g.Dh().Cy()) {
                            q.Te().SV();
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|onNetworkChange";
                    }
                }, 3000);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[]{Integer.valueOf(i)});
                o.iC(2);
            }
        }
    };

    public static g Te() {
        com.tencent.mm.kernel.g.Dh().Ct();
        return (g) Tf().hSR.get();
    }

    private static q Tf() {
        return (q) p.s(q.class);
    }

    public static m Tg() {
        com.tencent.mm.kernel.g.Dh().Ct();
        return (m) Tf().hSP.get();
    }

    public static void e(e eVar) {
        boolean z;
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = bh.cgy();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Tf().hSO);
        }
    }

    public static void f(e eVar) {
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = bh.cgy();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Tf().hSQ);
        }
    }

    public final void onAccountRelease() {
        com.tencent.mm.kernel.g.Di().b(this.hsr);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(9998), this.hSO);
        this.hSO = new l();
        ak.a.hfM = null;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new 4());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(9998), this.hSO);
        com.tencent.mm.kernel.g.Di().a(this.hsr);
        ak.a.hfM = new ak.e(this) {
            final /* synthetic */ q hSS;

            {
                this.hSS = r1;
            }

            public final void aV(int i, int i2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), bh.cgy()});
                n.A(i, i2, 0);
            }
        };
    }

    public final void br(boolean z) {
    }
}
