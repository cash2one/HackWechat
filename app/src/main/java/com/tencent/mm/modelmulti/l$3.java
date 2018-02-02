package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class l$3 implements a {
    final /* synthetic */ l hFV;
    private int hFX = 0;
    private long hFY = 0;
    private int hFZ = 0;

    l$3(l lVar) {
        this.hFV = lVar;
    }

    public final boolean uF() {
        c cVar = new c();
        if (!g.Dh().Cy()) {
            x.e(l.b(this.hFV), "syncRespHandler acc is not ready STOP :%s", new Object[]{l.c(this.hFV)});
            l.d(this.hFV);
            return false;
        } else if (l.e(this.hFV)) {
            cVar.bx(this.hFV);
            l.d(this.hFV);
            return false;
        } else if (l.c(this.hFV) == null || l.c(this.hFV).vBR.vRD == null || l.c(this.hFV).vBR.vRD.ksP == null) {
            x.e(l.b(this.hFV), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[]{l.c(this.hFV)});
            cVar.bx(this.hFV);
            l.d(this.hFV);
            return false;
        } else {
            LinkedList linkedList = l.c(this.hFV).vBR.vRD.ksP;
            cVar.bv(this.hFV);
            this.hFZ++;
            long Wp = bh.Wp();
            for (int i = 0; i < 5; i++) {
                if (this.hFX < linkedList.size()) {
                    x.v(l.b(this.hFV), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.hFX), Integer.valueOf(linkedList.size()), Integer.valueOf(((ol) linkedList.get(this.hFX)).vXp), Integer.valueOf(((ol) linkedList.get(this.hFX)).vXq.wJB)});
                    linkedList.size();
                    if (!cVar.a((ol) linkedList.get(this.hFX), false)) {
                        x.w(l.b(this.hFV), "DoCmd Failed index:%d", new Object[]{Integer.valueOf(this.hFX)});
                    }
                    this.hFX++;
                }
                if (this.hFX >= linkedList.size()) {
                    this.hFY += bh.bz(Wp);
                    x.i(l.b(this.hFV), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[]{Integer.valueOf(this.hFX), Integer.valueOf(linkedList.size()), Long.valueOf(bh.bz(l.f(this.hFV))), Long.valueOf(this.hFY), Integer.valueOf(this.hFZ), l.c(this.hFV)});
                    this.hFV.a(l.c(this.hFV));
                    cVar.bw(this.hFV);
                    d.pPH.a(99, (long) bh.e((Integer) d.a((int) this.hFY, new int[]{100, 300, 1000, 3000}, new Integer[]{Integer.valueOf(240), Integer.valueOf(ai.CTRL_BYTE), Integer.valueOf(bc.CTRL_BYTE), Integer.valueOf(bd.CTRL_BYTE), Integer.valueOf(JsApiGetSetting.CTRL_INDEX)})), 1, false);
                    d.pPH.a(99, (long) bh.e((Integer) d.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(az.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(an.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(c$a.CTRL_INDEX), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX)})), 1, false);
                    d.pPH.a(99, b.foreground ? 241 : 242, 1, false);
                    d.pPH.a(99, (long) l.g(this.hFV), 1, false);
                    d.pPH.a(99, 0, 1, false);
                    d dVar = d.pPH;
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(linkedList.size());
                    objArr[1] = Long.valueOf(r10);
                    objArr[2] = Integer.valueOf(l.g(this.hFV));
                    objArr[3] = Integer.valueOf(l.c(this.hFV).vBR.vPq);
                    objArr[4] = Long.valueOf(this.hFY);
                    objArr[5] = Integer.valueOf(this.hFZ);
                    objArr[6] = l.h(this.hFV);
                    objArr[7] = Integer.valueOf(b.foreground ? 1 : 2);
                    dVar.h(12063, objArr);
                    l.d(this.hFV);
                    return false;
                }
                if (bh.bz(Wp) > 500) {
                    x.d(l.b(this.hFV), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[]{Long.valueOf(bh.bz(Wp)), Integer.valueOf(i), Integer.valueOf(this.hFX), l.c(this.hFV)});
                    this.hFY += bh.bz(Wp);
                    return true;
                }
            }
            this.hFY += bh.bz(Wp);
            return true;
        }
    }
}
