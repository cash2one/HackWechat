package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.w;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class r$e extends k implements c, com.tencent.mm.network.k {
    int cLl;
    private boolean hHA = false;
    final /* synthetic */ r hHn;
    e hHy;
    boolean hHz;
    private q hnp;
    int scene;

    public final boolean b(Queue<c> queue) {
        String str;
        String str2 = "MicroMsg.SyncService";
        String str3 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
        Object[] objArr = new Object[5];
        objArr[0] = this;
        objArr[1] = Integer.valueOf(this.scene);
        objArr[2] = Integer.valueOf(this.cLl);
        objArr[3] = Boolean.valueOf(this.hHz);
        if (queue == null) {
            str = "null";
        } else {
            str = Integer.valueOf(queue.size());
        }
        objArr[4] = str;
        x.i(str2, str3, objArr);
        if (queue != null) {
            r.a(this.hHn, queue);
            boolean z = false;
            boolean z2 = false;
            while (!queue.isEmpty()) {
                r$e com_tencent_mm_modelmulti_r_e = (r$e) queue.poll();
                this.cLl |= com_tencent_mm_modelmulti_r_e.cLl;
                if (com_tencent_mm_modelmulti_r_e.scene == 3) {
                    z = true;
                } else if (com_tencent_mm_modelmulti_r_e.hHz) {
                    z2 = true;
                }
                x.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[]{this, Integer.valueOf(queue.size()), com_tencent_mm_modelmulti_r_e, Integer.valueOf(com_tencent_mm_modelmulti_r_e.scene), Integer.valueOf(com_tencent_mm_modelmulti_r_e.cLl), Boolean.valueOf(com_tencent_mm_modelmulti_r_e.hHz), Boolean.valueOf(z2), Boolean.valueOf(z)});
            }
            if (z) {
                this.scene = 3;
            } else if (z2) {
                this.scene = 6;
            }
        }
        if (g.Dh().Cy() && !a.Cs()) {
            g.Dk();
            if (g.Dj() != null) {
                g.Dk();
                if (g.Dj().CU() != null) {
                    g.Dk();
                    long a = bh.a((Long) g.Dj().CU().get(8196, null), 0);
                    if (a != 0) {
                        g.Dk();
                        g.Dj().CU().set(8196, Long.valueOf(0));
                        this.cLl = (int) (((long) this.cLl) | a);
                        this.cLl &= 95;
                    }
                    int i = this.scene == 3 ? 1 : 0;
                    if (this.scene == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
                        this.cLl |= 16;
                        this.scene = 7;
                    } else if (this.scene == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE) {
                        this.cLl |= 64;
                        this.scene = 7;
                    } else if (this.scene == 3) {
                        this.cLl |= 262144;
                        this.scene = 3;
                    }
                    if (this.hHz) {
                        this.scene = 6;
                    }
                    this.hnp = new l.a();
                    ati com_tencent_mm_protocal_c_ati = ((w.a) this.hnp.Kb()).vBQ;
                    com_tencent_mm_protocal_c_ati.wBv = i;
                    com_tencent_mm_protocal_c_ati.vRz = this.cLl;
                    com_tencent_mm_protocal_c_ati.rYW = this.scene;
                    g.Dk();
                    com_tencent_mm_protocal_c_ati.vRA = n.N(bh.VD(bh.ou((String) g.Dj().CU().get(8195, new byte[0]))));
                    com_tencent_mm_protocal_c_ati.wBu = new om();
                    com_tencent_mm_protocal_c_ati.vJA = d.DEVICE_TYPE;
                    x.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[]{this, Long.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_ati.wBv), Integer.valueOf(com_tencent_mm_protocal_c_ati.vRz), Integer.valueOf(this.scene), com_tencent_mm_protocal_c_ati.vJA});
                    x.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[]{this, ad.bi(bh.VD(str))});
                    r.a(this);
                    g.Dk();
                    if (g.Di().gPJ.a(this, 0)) {
                        return true;
                    }
                    com.tencent.mm.plugin.report.d.pPH.h(11098, new Object[]{Integer.valueOf(3500), this.scene + ";" + b.foreground + ";" + r.Qg()});
                    x.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[]{this});
                    com.tencent.mm.plugin.report.d.pPH.a(99, 41, 1, false);
                    return false;
                }
            }
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = this;
        objArr2[1] = Boolean.valueOf(g.Dh().Cy());
        objArr2[2] = Boolean.valueOf(a.Cs());
        g.Dk();
        objArr2[3] = g.Dj();
        x.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
        return false;
    }

    public final String toString() {
        return "NetSync[" + hashCode() + "]";
    }

    public r$e(r rVar, int i, int i2, boolean z) {
        this.hHn = rVar;
        this.scene = i;
        this.cLl = i2;
        this.hHz = z;
    }

    public final int getType() {
        return 138;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hHy = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final boolean Kg() {
        return false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            com.tencent.mm.plugin.report.d.pPH.a(99, 44, 1, false);
            String str2 = "MicroMsg.SyncService";
            String str3 = "%s onGYNetEnd error type:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this;
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[1] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
        } else if (this.hHA) {
            x.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[]{this});
        } else {
            boolean z;
            int cfD;
            this.hHA = true;
            r.C("Check rr failed.", qVar == this.hnp);
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                x.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), str, qVar});
                if (i2 == 4 && i3 == -2006) {
                    x.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[]{this});
                    com.tencent.mm.plugin.report.d.pPH.a(99, 42, 1, false);
                    z = false;
                } else {
                    com.tencent.mm.plugin.report.d.pPH.h(11098, new Object[]{Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + b.foreground + ";" + r.Qg()});
                    com.tencent.mm.plugin.report.d.pPH.a(99, 43, 1, false);
                    this.hHy.a(i2, i3, str, this);
                    r.b(this.hHn, this);
                    return;
                }
            }
            atj com_tencent_mm_protocal_c_atj = ((w.b) qVar.Hp()).vBR;
            boolean z2 = HardCoderJNI.hcReceiveMsgEnable;
            int i5 = HardCoderJNI.hcReceiveMsgDelay;
            int i6 = HardCoderJNI.hcReceiveMsgCPU;
            int i7 = HardCoderJNI.hcReceiveMsgIO;
            if (HardCoderJNI.hcReceiveMsgThr) {
                cfD = g.Dm().cfD();
            } else {
                cfD = 0;
            }
            r$a com_tencent_mm_modelmulti_r_a = new r$a(this.hHn, this, z, com_tencent_mm_protocal_c_atj, new 1(this, com_tencent_mm_protocal_c_atj, HardCoderJNI.startPerformance(z2, i5, i6, i7, cfD, HardCoderJNI.hcReceiveMsgTimeout, 201, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService")));
        }
    }
}
