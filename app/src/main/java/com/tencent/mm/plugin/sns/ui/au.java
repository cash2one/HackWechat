package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class au extends e<m> {
    private boolean fuf = false;
    List<m> list = new ArrayList();
    private String maQ = "";
    private Comparator<m> qSt = new 1(this);
    private boolean rFQ = false;
    private b rFR;
    private a rFS;
    private int rqr = 0;
    private int rqs = 0;
    private String userName = "";

    public interface b {
        void a(List<m> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void bBs();
    }

    public au(b bVar, String str, boolean z) {
        this.rFR = bVar;
        this.userName = str;
        this.fuf = z;
    }

    public final void bT(List<m> list) {
        if (this.rFR != null) {
            if (list != null) {
                c(true, list);
            }
            this.rFR.bBs();
        }
    }

    public final List<m> byT() {
        x.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(ai.a(this.userName, this.fuf, this.maQ, this.rFQ).size())});
        return ai.a(this.userName, this.fuf, this.maQ, this.rFQ);
    }

    public final void bBt() {
        Collections.sort(this.list, this.qSt);
    }

    final void bBu() {
        c(false, this.list);
    }

    public final void e(String str, boolean z, boolean z2) {
        x.d("MicroMsg.SnsSelfHelper", "limitSeq " + str);
        this.maQ = str;
        this.rFQ = z;
        fC(z2);
    }

    private void c(boolean z, List<m> list) {
        this.rFS = new a(this);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (z && this.fuf) {
            m mVar = new m((byte) 0);
            mVar.field_snsId = 0;
            mVar.roJ = -1;
            mVar.hK((int) (System.currentTimeMillis() / 1000));
            list.add(0, mVar);
        }
        int size = list.size();
        x.d("MicroMsg.SnsSelfHelper", "initFixType " + size);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5;
            int i6;
            a aVar = this.rFS;
            aVar.rFV = -1;
            aVar.rGf = -1;
            aVar.rFU = -1;
            aVar.rFZ = "";
            aVar.rGa = "";
            aVar.rGb = "";
            aVar.rGe = false;
            aVar.rFW = false;
            aVar.rGg = false;
            aVar.rGh = -1;
            aVar.rFX = -1;
            aVar.rGc = -1;
            aVar.rGd = 0;
            aVar.rFY = 0;
            aVar.rGi = 0;
            if (this.fuf && i3 == 0) {
                i5 = 1;
            } else {
                bnp bxV;
                if (i3 + 1 < size) {
                    mVar = (m) list.get(i3 + 1);
                    this.rFS.rFV = mVar.field_head;
                    bxV = mVar.bxV();
                    this.rFS.rFZ = bxV.wQl;
                    this.rFS.rFW = ai.J(mVar.field_localPrivate, this.fuf);
                    this.rFS.rFX = mVar.field_type;
                    if (bxV.wQo != null) {
                        this.rFS.rFY = bxV.wQo.vYd.size();
                    } else {
                        this.rFS.rFY = 0;
                    }
                }
                if (i3 + 2 < size) {
                    mVar = (m) list.get(i3 + 2);
                    this.rFS.rGf = mVar.field_head;
                    bxV = mVar.bxV();
                    this.rFS.rGa = bxV.wQl;
                    this.rFS.rGg = ai.J(mVar.field_localPrivate, this.fuf);
                    this.rFS.rGh = mVar.field_type;
                    if (bxV.wQo != null) {
                        this.rFS.rGi = bxV.wQo.vYd.size();
                    } else {
                        this.rFS.rGi = 0;
                    }
                }
                mVar = (m) list.get(i3);
                this.rFS.rFU = mVar.field_head;
                bxV = mVar.bxV();
                this.rFS.rGb = bxV.wQl;
                this.rFS.rGc = mVar.field_type;
                this.rFS.rGe = ai.J(mVar.field_localPrivate, this.fuf);
                if (bxV.wQo != null) {
                    this.rFS.rGd = bxV.wQo.vYd.size();
                } else {
                    this.rFS.rGd = 0;
                }
                aVar = this.rFS;
                Object obj = aVar.rGc == 2 ? 1 : aVar.rFV == -1 ? 1 : aVar.rGc != aVar.rFX ? 1 : a.xK(aVar.rGc) ? 1 : a.xK(aVar.rFX) ? 1 : (aVar.rGd > 1 || aVar.rFY > 1) ? 1 : (aVar.rGb == null || aVar.rGb.equals("")) ? (aVar.rFZ == null || aVar.rFZ.equals("")) ? aVar.rFU != aVar.rFV ? 1 : null : 1 : 1;
                if (obj != null) {
                    i5 = 1;
                } else {
                    aVar = this.rFS;
                    obj = aVar.rGf == -1 ? 1 : aVar.rFX != aVar.rGh ? 1 : a.xK(aVar.rGh) ? 1 : aVar.rGi > 1 ? 1 : (aVar.rGa == null || aVar.rGa.equals("")) ? aVar.rFV != aVar.rGf ? 1 : null : 1;
                    i5 = obj != null ? 2 : 3;
                }
            }
            hashMap.put(Integer.valueOf(i4), Integer.valueOf(i2));
            hashMap2.put(Integer.valueOf(i4), Integer.valueOf(i5));
            i2 += i5;
            hashMap3.put(Integer.valueOf(i4), Integer.valueOf(i));
            if (this.fuf && i3 == 0) {
                i6 = 0;
            } else {
                i6 = 0;
                if (i5 > 0 && this.rFS.rGc == 1) {
                    i6 = 1;
                }
                if (i5 >= 2 && this.rFS.rFX == 1) {
                    i6++;
                }
                if (i5 >= 3 && this.rFS.rGh == 1) {
                    i6++;
                }
            }
            i += i6;
            i3 += i5;
            i4++;
        }
        this.rqr = i4;
        this.rqs = list.size();
        x.d("MicroMsg.SnsSelfHelper", "icount " + this.rqr);
        this.list = list;
        i.Z("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.rFR.a(this.list, hashMap, hashMap2, hashMap3, this.rqs, this.rqr);
    }
}
