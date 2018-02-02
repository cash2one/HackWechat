package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.bq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class av$4 implements Runnable {
    final /* synthetic */ String hMZ;
    final /* synthetic */ String icx;
    final /* synthetic */ av qXV;
    final /* synthetic */ int qXW;
    final /* synthetic */ aqs qXX;
    final /* synthetic */ List qXY;
    final /* synthetic */ bnp qXZ;
    final /* synthetic */ boolean qYa;
    final /* synthetic */ LinkedList qYb;
    final /* synthetic */ b qYc;

    av$4(av avVar, String str, aqs com_tencent_mm_protocal_c_aqs, List list, bnp com_tencent_mm_protocal_c_bnp, int i, boolean z, LinkedList linkedList, b bVar, String str2) {
        this.qXV = avVar;
        this.hMZ = str;
        this.qXX = com_tencent_mm_protocal_c_aqs;
        this.qXY = list;
        this.qXZ = com_tencent_mm_protocal_c_bnp;
        this.qXW = i;
        this.qYa = z;
        this.qYb = linkedList;
        this.qYc = bVar;
        this.icx = str2;
    }

    public final void run() {
        if (ae.bve()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        av.a(this.qXV, new r(this.hMZ, this.qXX.wxG, this.qXX.wyb, this.qXY, this.qXZ, this.qXW, this.qXX.vGQ, this.qXX.wyg, this.qXX.wyh, this.qXX.wyi, this.qXX, this.qYa, this.qYb, this.qXX.wyn, this.qYc, this.icx));
        g.Dk();
        g.Di().gPJ.a(av.d(this.qXV), 0);
    }
}
