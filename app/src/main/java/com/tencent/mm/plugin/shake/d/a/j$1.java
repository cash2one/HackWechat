package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.a.a;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class j$1 implements a {
    final /* synthetic */ j qpV;

    j$1(j jVar) {
        this.qpV = jVar;
    }

    public final void a(bdf com_tencent_mm_protocal_c_bdf, long j, boolean z) {
        if (j.a(this.qpV) == null) {
            x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        bht com_tencent_mm_protocal_c_bht = (bht) com_tencent_mm_protocal_c_bdf;
        if (com_tencent_mm_protocal_c_bht == null) {
            x.w("Micromsg.ShakeMusicMgr", "resp null & return");
            j.a(this.qpV, new ArrayList());
        } else if (com_tencent_mm_protocal_c_bht.wLu == 1) {
            long currentTimeMillis;
            if (j > j.b(this.qpV)) {
                currentTimeMillis = System.currentTimeMillis() - j;
            } else {
                currentTimeMillis = System.currentTimeMillis() - j.b(this.qpV);
            }
            if (com_tencent_mm_protocal_c_bht != null && !bh.ov(com_tencent_mm_protocal_c_bht.wLw)) {
                boolean a;
                x.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bht.wLv), com_tencent_mm_protocal_c_bht.wLw});
                String str = com_tencent_mm_protocal_c_bht.wLw;
                if (str != null) {
                    str = str.trim();
                }
                switch (com_tencent_mm_protocal_c_bht.wLv) {
                    case 0:
                        a = j.a(this.qpV, str);
                        break;
                    case 1:
                        a = j.b(this.qpV, str);
                        break;
                    case 2:
                        a = j.c(this.qpV, str);
                        break;
                    case 3:
                        a = j.d(this.qpV, str);
                        break;
                    case 4:
                        a = j.e(this.qpV, str);
                        break;
                    default:
                        x.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + com_tencent_mm_protocal_c_bht.wLv);
                        j.a(this.qpV, new ArrayList());
                        a = false;
                        break;
                }
                if (a) {
                    g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - j.b(this.qpV)))});
                    return;
                }
                g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
            } else if (z) {
                j.a(this.qpV, new ArrayList());
                g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
            } else {
                j.a(this.qpV, new ArrayList());
                g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
            }
        } else {
            List arrayList = new ArrayList();
            if (com_tencent_mm_protocal_c_bht != null) {
                d dVar = new d();
                if (!(com_tencent_mm_protocal_c_bht.wLq == null || com_tencent_mm_protocal_c_bht.wLq.wJD == null)) {
                    dVar.field_username = com_tencent_mm_protocal_c_bht.wLq.wJD.cdp();
                }
                if (!(com_tencent_mm_protocal_c_bht.wLp == null || com_tencent_mm_protocal_c_bht.wLp.wJD == null)) {
                    dVar.field_nickname = com_tencent_mm_protocal_c_bht.wLp.wJD.cdp();
                }
                if (!(com_tencent_mm_protocal_c_bht.wLq == null || com_tencent_mm_protocal_c_bht.wLq.wJD == null)) {
                    dVar.field_distance = com_tencent_mm_protocal_c_bht.wLq.wJD.cdp();
                }
                if (!(com_tencent_mm_protocal_c_bht.wmX == null || com_tencent_mm_protocal_c_bht.wmX.wJD == null)) {
                    dVar.field_sns_bgurl = com_tencent_mm_protocal_c_bht.wmX.wJD.cdp();
                }
                dVar.field_type = 4;
                dVar.field_insertBatch = 1;
                try {
                    dVar.field_lvbuffer = com_tencent_mm_protocal_c_bht.toByteArray();
                } catch (IOException e) {
                    x.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[]{e.getLocalizedMessage()});
                }
                m.brC().a(dVar, true);
                arrayList.add(dVar);
            }
            j.c(this.qpV).d(arrayList, j);
        }
    }
}
