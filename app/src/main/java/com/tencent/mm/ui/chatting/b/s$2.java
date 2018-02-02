package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.av.b;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.s;

class s$2 implements Runnable {
    final /* synthetic */ String fhl;
    final /* synthetic */ s yAC;
    final /* synthetic */ String yAD;
    final /* synthetic */ long yAE;

    public s$2(s sVar, String str, String str2, long j) {
        this.yAC = sVar;
        this.yAD = str;
        this.fhl = str2;
        this.yAE = j;
    }

    public final void run() {
        String str = this.yAD;
        if (s.eV(this.fhl) && !bh.az(str, "").startsWith("<")) {
            int indexOf = this.yAD.indexOf(58);
            if (indexOf != -1) {
                str = this.yAD.substring(indexOf + 1);
            }
        }
        a fT = a.fT(bh.VH(str));
        if (fT != null) {
            switch (fT.type) {
                case 3:
                    asv Qs = b.Qs();
                    if (Qs != null && Qs.vVZ != null && Qs.wAi == 0) {
                        try {
                            if (this.yAE == bh.getLong(Qs.vVZ, 0)) {
                                ag.y(new 1(this));
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
