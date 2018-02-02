package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.w;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class r {
    private static Boolean hHh = null;
    private WakerLock gyj = null;
    public Queue<c> hHi = new LinkedList();
    public Queue<c> hHj = new LinkedList();
    private HashMap<c, Long> hHk = new HashMap();
    public c hHl = null;
    private long hHm = 0;

    static /* synthetic */ void a(c cVar, long j) {
        if (cVar != null) {
            d.pPH.a(99, (long) bh.e((Integer) d.a((int) bh.bz(j), new int[]{200, 500, 800, 1500, 3000, 5000, 10000, 30000, 60000, 90000}, new Integer[]{Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(80)})), 1, false);
        }
    }

    static /* synthetic */ void a(e eVar) {
        d.pPH.a(99, (long) eVar.scene, 1, false);
        d.pPH.a(99, 0, 1, false);
        d.pPH.a(99, b.foreground ? 241 : 242, 1, false);
    }

    static /* synthetic */ void a(r rVar, c cVar) {
        if (cVar == null) {
            d.pPH.h(11098, Integer.valueOf(3550), b.foreground + ";" + PY());
            d.pPH.a(99, 48, 1, false);
        } else if (cVar instanceof e) {
            d.pPH.h(11098, Integer.valueOf(3551), b.foreground + ";" + PY());
            d.pPH.a(99, 49, 1, false);
        } else if (cVar instanceof f) {
            d.pPH.h(11098, Integer.valueOf(3552), b.foreground + ";" + PY());
            d.pPH.a(99, 50, 1, false);
        } else if (cVar instanceof d) {
            d.pPH.h(11098, Integer.valueOf(3553), b.foreground + ";" + PY());
            d.pPH.a(99, 51, 1, false);
        } else {
            d.pPH.h(11098, Integer.valueOf(3554), b.foreground + ";" + PY());
            d.pPH.a(99, 52, 1, false);
        }
    }

    static /* synthetic */ void a(r rVar, atj com_tencent_mm_protocal_c_atj) {
        int size = (com_tencent_mm_protocal_c_atj.vRD == null || com_tencent_mm_protocal_c_atj.vRD.ksP == null || com_tencent_mm_protocal_c_atj.vRD.ksP.size() <= 0) ? 0 : com_tencent_mm_protocal_c_atj.vRD.ksP.size();
        d.pPH.a(99, (long) bh.e((Integer) d.a(size, new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(az.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(an.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(c$a.CTRL_INDEX), Integer.valueOf(g.CTRL_INDEX)})), 1, false);
        if (!PY()) {
            d.pPH.a(99, size > 0 ? 221 : 218, 1, false);
        } else if (b.foreground) {
            d.pPH.a(99, size > 0 ? 219 : 216, 1, false);
        } else {
            d.pPH.a(99, size > 0 ? 220 : 217, 1, false);
        }
    }

    static /* synthetic */ void a(r rVar, Queue queue) {
        if (queue != null && !queue.isEmpty()) {
            if (queue.size() >= 5) {
                d.pPH.h(11098, Integer.valueOf(3590), queue.size() + ";" + b.foreground + ";" + PY());
            }
            d.pPH.a(99, (long) bh.e((Integer) d.a(queue.size(), new int[]{1, 2, 3, 4, 5, 10}, new Integer[]{Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66)})), 1, false);
        }
    }

    static /* synthetic */ void a(boolean z, atj com_tencent_mm_protocal_c_atj, c cVar) {
        com.tencent.mm.kernel.g.Dk();
        byte[] VD = bh.VD(bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(8195, new byte[0])));
        byte[] a = n.a(com_tencent_mm_protocal_c_atj.vRA);
        x.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", cVar, ad.bi(VD), Boolean.valueOf(z));
        x.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", cVar, ad.bi(a));
        if (com_tencent_mm_protocal_c_atj.vRA == null || com_tencent_mm_protocal_c_atj.vRA.wJB <= 0) {
            d.pPH.a(99, 47, 1, false);
            return;
        }
        if (z) {
            byte[] g = ad.g(VD, a);
            x.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", cVar, ad.bi(g));
            if (g == null || g.length <= 0) {
                g = a;
            }
            com_tencent_mm_protocal_c_atj.vRA = n.N(g);
        }
        if (Arrays.equals(VD, n.a(com_tencent_mm_protocal_c_atj.vRA))) {
            x.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", cVar);
            return;
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().set(8195, bh.by(n.a(com_tencent_mm_protocal_c_atj.vRA)));
        ac.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bh.by(n.a(com_tencent_mm_protocal_c_atj.vRA))).commit();
    }

    static /* synthetic */ void d(r rVar, c cVar) {
        if (cVar instanceof e) {
            d.pPH.h(11098, Integer.valueOf(3571), b.foreground + ";" + PY());
            d.pPH.a(99, b.foreground ? 30 : 34, 1, false);
        } else if (cVar instanceof f) {
            d.pPH.h(11098, Integer.valueOf(3572), b.foreground + ";" + PY());
            d.pPH.a(99, b.foreground ? 31 : 35, 1, false);
        } else if (cVar instanceof d) {
            d.pPH.h(11098, Integer.valueOf(3573), b.foreground + ";" + PY());
            d.pPH.a(99, b.foreground ? 32 : 36, 1, false);
        } else {
            d.pPH.h(11098, Integer.valueOf(3574), b.foreground + ";" + PY());
            d.pPH.a(99, b.foreground ? 33 : 37, 1, false);
        }
    }

    private static boolean EP() {
        if (a.Cs() || !com.tencent.mm.kernel.g.Dh().Cy()) {
            return false;
        }
        if (hHh != null) {
            return hHh.booleanValue();
        }
        hHh = Boolean.valueOf(true);
        return true;
    }

    private static void assertTrue(String str, boolean z) {
        if (!z) {
            x.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
            Assert.assertTrue(str, z);
        }
    }

    public final int a(long j, int i, String str) {
        x.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", Boolean.valueOf(EP()), Long.valueOf(j), Integer.valueOf(i), str, bh.cgy());
        int i2 = 0;
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.b.a.xef.m(new qg());
        }
        long j2 = (-257 & j) & 95;
        if (j2 != 0 && com.tencent.mm.kernel.g.Dh().Cy()) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dj().CU() != null) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().CU().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = d(i, 7, false);
                } else {
                    k lVar = new l(i);
                    i2 = lVar.hashCode();
                    x.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i2));
                    com.tencent.mm.kernel.g.Dk();
                    if (!com.tencent.mm.kernel.g.Di().gPJ.a(lVar, 0)) {
                        x.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i2));
                        i2 = 0;
                    }
                }
            }
        }
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.b.b ahVar = new ah();
            ahVar.foi.type = 3;
            ahVar.foi.fok = str;
            com.tencent.mm.sdk.b.a.xef.m(ahVar);
        }
        return i2;
    }

    public final void a(w.b bVar, int i, long j) {
        x.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", Boolean.valueOf(EP()), bVar, Integer.valueOf(i), Long.valueOf(j), bh.cgy());
        if (EP()) {
            a(new f(this, bVar, i, j));
            return;
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(new l(bVar, i, j), 0);
    }

    public final int id(int i) {
        x.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(EP()), Integer.valueOf(i), bh.cgy());
        if (EP()) {
            return d(i, 7, false);
        }
        k lVar = new l(i);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(lVar, 0);
        return lVar.hashCode();
    }

    private int d(int i, int i2, boolean z) {
        c eVar = new e(this, i, i2, z);
        a(eVar);
        return eVar.hashCode();
    }

    private synchronized void lJ(String str) {
        boolean z = true;
        synchronized (this) {
            x.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.gyj, bh.cgy());
            if (this.gyj == null) {
                this.gyj = new WakerLock(ac.getContext(), new 1(this));
            }
            String str2 = "lock";
            if (this.gyj.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!b.foreground) {
                this.gyj.lock(30000, str);
            }
        }
    }

    private synchronized void Qf() {
        if (this.gyj == null || !this.gyj.isLocking()) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            if (this.gyj == null) {
                str = "null";
            } else {
                str = Boolean.valueOf(this.gyj.isLocking());
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(b.foreground);
            x.w(str2, str3, objArr);
        } else {
            this.gyj.unLock();
        }
    }

    private void a(c cVar) {
        if (m.PZ()) {
            x.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            return;
        }
        com.tencent.mm.kernel.g.Dm().F(new 2(this, cVar));
    }

    private static boolean PY() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ac.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            d.pPH.a(99, 45, 1, false);
            x.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), bh.i(e));
            return true;
        }
    }
}
