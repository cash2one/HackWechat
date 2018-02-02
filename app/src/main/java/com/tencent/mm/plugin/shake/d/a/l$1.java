package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.a.a;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class l$1 implements a {
    final /* synthetic */ l qpX;

    l$1(l lVar) {
        this.qpX = lVar;
    }

    public final void a(bdf com_tencent_mm_protocal_c_bdf, long j, boolean z) {
        long currentTimeMillis;
        if (j > l.a(this.qpX)) {
            currentTimeMillis = System.currentTimeMillis() - j;
        } else {
            currentTimeMillis = System.currentTimeMillis() - l.a(this.qpX);
        }
        if (com_tencent_mm_protocal_c_bdf != null && !bh.ov(((bhx) com_tencent_mm_protocal_c_bdf).vNZ)) {
            boolean a;
            bhx com_tencent_mm_protocal_c_bhx = (bhx) com_tencent_mm_protocal_c_bdf;
            x.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bhx.ktN), com_tencent_mm_protocal_c_bhx.vNZ});
            String str = null;
            String str2 = null;
            if (com_tencent_mm_protocal_c_bhx.vNZ != null) {
                com_tencent_mm_protocal_c_bhx.vNZ = com_tencent_mm_protocal_c_bhx.vNZ.trim();
                int indexOf = com_tencent_mm_protocal_c_bhx.vNZ.indexOf("<tvinfo>");
                if (indexOf > 0) {
                    str = com_tencent_mm_protocal_c_bhx.vNZ.substring(0, indexOf);
                    str2 = com_tencent_mm_protocal_c_bhx.vNZ.substring(indexOf);
                } else if (indexOf == 0) {
                    str2 = com_tencent_mm_protocal_c_bhx.vNZ;
                } else {
                    str = com_tencent_mm_protocal_c_bhx.vNZ;
                }
            }
            l.Jg(str2);
            switch (com_tencent_mm_protocal_c_bhx.ktN) {
                case 0:
                    a = l.a(this.qpX, str);
                    break;
                case 1:
                    a = l.b(this.qpX, str);
                    break;
                case 2:
                    a = l.c(this.qpX, str);
                    break;
                case 3:
                    a = l.d(this.qpX, str);
                    break;
                case 4:
                    a = l.e(this.qpX, str);
                    break;
                case 5:
                    a = l.f(this.qpX, str);
                    break;
                case 6:
                    a = l.g(this.qpX, str);
                    break;
                default:
                    x.w("Micromsg.ShakeTVService", "parse unknown type:" + com_tencent_mm_protocal_c_bhx.ktN);
                    l.a(this.qpX, new ArrayList());
                    a = false;
                    break;
            }
            if (a) {
                g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - l.a(this.qpX)))});
            } else {
                g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
            }
        } else if (z) {
            l.a(this.qpX, new ArrayList());
            g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
        } else {
            l.a(this.qpX, new ArrayList());
            g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
        }
        l.bsh();
    }
}
