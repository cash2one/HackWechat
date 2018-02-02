package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.booter.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.w;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class l extends k implements com.tencent.mm.network.k {
    protected static int cLl = 7;
    private static boolean hFM = false;
    private static int hFP = 0;
    public String TAG;
    private int errCode;
    private int errType;
    private String fnL;
    private e gJT;
    private boolean hEW;
    private int hEY;
    private a hEZ;
    public s hFL;
    private boolean hFN;
    private ak hFO;
    private int hFQ;
    private boolean hFR;
    private String hFS;
    public b hFT;
    private long hFU;
    private long hFb;
    private boolean hFc;
    private ak hkO;

    public l(int i) {
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.fnL = "";
        this.hFL = null;
        this.hFN = false;
        this.hEY = 0;
        this.hkO = null;
        this.hFO = null;
        this.hFb = -1;
        this.hFc = false;
        this.hFR = false;
        this.hEW = false;
        this.hFS = "";
        this.hFT = null;
        this.hFU = 0;
        this.TAG += "[" + hashCode() + "]";
        x.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[]{Integer.valueOf(i), bh.cgy()});
        this.hFS = ai.cfH();
        this.hEZ = new a();
        if (this.hFL == null) {
            this.hFL = new s();
        }
        this.hFL.hHH = i;
        g.Dk();
        if (g.Dj() != null && g.Dh().Cy()) {
            g.Dk();
            if (!(g.Dj().CU() == null || com.tencent.mm.kernel.a.Cs())) {
                g.Dk();
                long a = bh.a((Long) g.Dj().CU().get(8196, null), 0);
                if (a != 0) {
                    g.Dk();
                    g.Dj().CU().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) cLl));
                    cLl = i2;
                    cLl = i2 & 95;
                }
            }
        }
        if (i == 1) {
            hFM = true;
        }
        if (i == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
            cLl |= 16;
            hFM = true;
            this.hFQ = 7;
        } else if (i == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE) {
            cLl |= 64;
            hFM = true;
            this.hFQ = 7;
        } else if (i == 3) {
            cLl |= 262144;
            hFM = true;
            this.hFQ = 3;
            x.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(cLl), Integer.valueOf(this.hFQ)});
        } else {
            this.hFQ = i;
        }
        if (hFP == 0) {
            PX();
        }
    }

    public l(b bVar, int i, long j) {
        this(8);
        this.hFS = ai.cfH();
        x.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[]{Long.valueOf(bVar.vBo), Integer.valueOf(i), Long.valueOf(j)});
        this.hEY = i;
        this.hFb = j;
        this.hkO = new ak(g.Dm().oAt.getLooper(), new 1(this, bVar), false);
        if (hFP == 0) {
            PX();
        }
    }

    protected final boolean a(k kVar) {
        boolean z = true;
        if (!(kVar instanceof l)) {
            return false;
        }
        l lVar = (l) kVar;
        if (lVar.hFN || !hFM) {
            return false;
        }
        x.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[]{Long.valueOf(lVar.hmB)});
        if (bh.bA(lVar.hmB) <= 360000) {
            z = false;
        }
        if (z) {
            x.i(this.TAG, "summerworker NetSceneSync timeout");
            Runnable findTaskByRunTime = g.Dm().cfF().findTaskByRunTime(0);
            if (findTaskByRunTime != null) {
                x.e(this.TAG, "summerworker worker is just blocked by task: " + af.dump(findTaskByRunTime, false));
                return false;
            }
        }
        return z;
    }

    public final boolean Kd() {
        return true;
    }

    protected final int Bh() {
        return 100;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final boolean Ke() {
        int i = 1;
        boolean Ke = super.Ke();
        if (Ke) {
            d.pPH.a(99, 228, 1, false);
            d dVar = d.pPH;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            dVar.h(12063, objArr);
        }
        return Ke;
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
        d.pPH.a(99, 229, 1, false);
        this.hEW = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (m.PZ()) {
            hFP = 0;
            x.e(this.TAG, "dkinit never do sync before init done");
            return -1;
        }
        this.gJT = eVar2;
        if (this.hFL == null) {
            this.hFL = new s();
        }
        this.hFL.hHG = com.tencent.mm.sdk.a.b.foreground;
        if (this.hFO != null) {
            x.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.hFO.J(0, 0);
            return 0;
        } else if (hFP > 0) {
            x.w(this.TAG, "other sync is dealing with resp data :%d", new Object[]{Integer.valueOf(hFP)});
            return -1;
        } else if (this.hkO != null) {
            x.i(this.TAG, "pusher not null");
            c(eVar);
            this.hkO.J(0, 0);
            return 0;
        } else {
            q aVar = new a();
            ati com_tencent_mm_protocal_c_ati = ((w.a) aVar.Kb()).vBQ;
            if (this.hFQ == 3) {
                com_tencent_mm_protocal_c_ati.wBv = 1;
            } else {
                com_tencent_mm_protocal_c_ati.wBv = 0;
            }
            this.hFQ = this.hFR ? 6 : this.hFQ;
            com_tencent_mm_protocal_c_ati.vRz = cLl;
            g.Dk();
            com_tencent_mm_protocal_c_ati.vRA = n.N(bh.VD(bh.ou((String) g.Dj().CU().get(8195, new byte[0]))));
            com_tencent_mm_protocal_c_ati.rYW = this.hFQ;
            com_tencent_mm_protocal_c_ati.wBu = new om();
            com_tencent_mm_protocal_c_ati.vJA = com.tencent.mm.protocal.d.DEVICE_TYPE;
            x.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ati.vRz), Integer.valueOf(com_tencent_mm_protocal_c_ati.rYW), ad.bi(r0)});
            hFM = false;
            return a(eVar, aVar, this);
        }
    }

    private boolean PX() {
        PInt pInt = new PInt();
        g.Dk();
        g.Dh();
        byte[] a = f.a(pInt, com.tencent.mm.kernel.a.Cg());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        x.i(str, str2, objArr);
        hFP = pInt.value;
        if (pInt.value == 0 || bh.bw(a)) {
            hFP = 0;
            return false;
        }
        b bVar = new b();
        try {
            bVar.E(a);
            this.hFO = new ak(g.Dm().oAt.getLooper(), new 2(this, new a(bVar)), false);
            return true;
        } catch (Exception e) {
            d.pPH.a(99, 226, 1, false);
            x.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = hFP;
            g.Dk();
            g.Dh();
            f.aL(i, com.tencent.mm.kernel.a.Cg());
            hFP = 0;
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory)});
            Assert.assertTrue("dealWithRespData error", false);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            String str2 = this.TAG;
            String str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
            return;
        }
        boolean z;
        b bVar = (b) qVar.Hp();
        str3 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.hEZ.zi());
        objArr2[4] = Boolean.valueOf(this.hFc);
        objArr2[5] = Integer.valueOf(bVar.vBR.vRD == null ? -1 : bVar.vBR.vRD.ksO);
        objArr2[6] = this.hkO;
        objArr2[7] = this.hFO;
        x.i(str3, str4, objArr2);
        Object obj = (bVar.vBR.vRD == null ? -1 : bVar.vBR.vRD.ksO) > 0 ? 1 : null;
        if (!PY()) {
            d.pPH.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            d.pPH.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            d.pPH.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.hkO = null;
        this.hFN = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            d.pPH.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            d.pPH.a(99, 233, 1, false);
            byte[] a = n.a(((w.a) qVar.Kb()).vBQ.vRA);
            byte[] a2 = n.a(bVar.vBR.vRA);
            x.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[]{Boolean.valueOf(z), ad.bi(a)});
            x.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[]{Boolean.valueOf(z), ad.bi(a2)});
            if (!z) {
                if (bh.bw(a)) {
                    g.Dk();
                    a = bh.VD(bh.ou((String) g.Dj().CU().get(8195, new byte[0])));
                    x.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[]{Integer.valueOf(a.length), bh.bv(a)});
                }
                a = ad.g(a, a2);
                if (a == null || a.length <= 0) {
                    x.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.vBR.vRA = n.N(a);
            }
            g.Dk();
            g.Dh().aT(bVar.vBR.ktm, bVar.vBR.wBw);
            g.Dk();
            g.Dh();
            com.tencent.mm.kernel.a.gA(bVar.vBR.ktm);
            Assert.assertTrue(this.hFT == null);
            this.hFT = bVar;
            this.hFU = bh.Wp();
            new ak(g.Dm().oAt.getLooper(), new 3(this), true).J(50, 50);
            return;
        }
        if (this.hFT != null) {
            x.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.fnL = str;
            ((b) qVar.Hp()).vBR.vPq = 0;
        } else {
            this.gJT.a(i2, i3, str, this);
        }
        d.pPH.a(99, 232, 1, false);
    }

    protected final void a(b bVar) {
        g.Dk();
        g.Dj().CU().set(8195, bh.by(n.a(bVar.vBR.vRA)));
        ac.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bh.by(n.a(bVar.vBR.vRA))).commit();
        g.Dk();
        g.Dj().CU().set(8196, Long.valueOf((long) bVar.vBR.vPq));
        boolean z = ((bVar.vBR.vPq & cLl) == 0 || super.Ke()) ? false : true;
        x.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[]{Boolean.valueOf(z), Integer.valueOf(bVar.vBR.vPq), Integer.valueOf(cLl), Boolean.valueOf(super.Ke())});
        if (!(z || (bVar.vBR.vPq & 256) == 0)) {
            com.tencent.mm.sdk.b.a.xef.m(new qg());
        }
        d.pPH.a(99, z ? 234 : 235, 1, false);
        x.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[]{Integer.valueOf(bVar.vBR.vPq), Boolean.valueOf(this.hFc), Boolean.valueOf(z), Boolean.valueOf(hFM), Integer.valueOf(this.hEY), Boolean.valueOf(this.hFR), this.hFO});
        if (!this.hFc && z) {
            this.hFR = true;
            a(this.hmA, this.gJT);
        } else if (hFM) {
            x.i(this.TAG, "dkpush new notify pending, sync now");
            if (hFP != 0) {
                r0 = hFP;
                g.Dk();
                g.Dh();
                f.aL(r0, com.tencent.mm.kernel.a.Cg());
            }
            hFP = 0;
            this.hFO = null;
            hFM = false;
            this.hFR = true;
            a(this.hmA, this.gJT);
        } else if (this.hFO != null) {
            r0 = hFP;
            g.Dk();
            g.Dh();
            f.aL(r0, com.tencent.mm.kernel.a.Cg());
            this.hFO = null;
            PX();
            a(this.hmA, this.gJT);
        } else {
            if ((this.hEY & 1) > 0) {
                g.Dk();
                g.CG().a(new h(this.hFb, bh.VD(bh.ou((String) g.Dj().CU().get(8195, null)))), 0);
            }
            x.d(this.TAG, "sync or init end: reset selector : now = " + cLl + " default = 7");
            cLl = 7;
            this.gJT.a(this.errType, this.errCode, this.fnL, this);
        }
    }

    private boolean PY() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ac.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            x.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{Boolean.valueOf(true), bh.i(e)});
            return true;
        }
    }
}
