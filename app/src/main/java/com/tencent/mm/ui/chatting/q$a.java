package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.a.a;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.c.f;
import com.tencent.mm.y.h;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class q$a implements OnClickListener {
    final /* synthetic */ q ytD;

    q$a(q qVar) {
        this.ytD = qVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof f) {
            f fVar = (f) view.getTag();
            long j = fVar.fqm;
            a aVar;
            String valueOf;
            String str;
            if (fVar.yJJ == -1) {
                boolean z;
                int g;
                b bVar;
                au auVar;
                ar.Hg();
                cf dH = c.Fa().dH(fVar.fqm);
                if (IF(String.valueOf(j))) {
                    g.pQN.k(10231, "1");
                    com.tencent.mm.av.b.Qo();
                    if (dH.field_msgId == j) {
                        b bVar2 = b.hPA;
                        z = false;
                        g = h.g(dH);
                        bVar = bVar2;
                        auVar = dH;
                    }
                } else {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(fVar.fCs);
                    if (fT != null) {
                        g.pQN.k(10090, "0,1");
                        aVar = (a) com.tencent.mm.kernel.g.h(a.class);
                        valueOf = String.valueOf(fVar.fqm);
                        str = fVar.fzs;
                        ar.Hg();
                        com.tencent.mm.av.b.b(aVar.a(fT, valueOf, str, c.FC(), fVar.fzs));
                    }
                    if (dH.field_msgId == j) {
                        bVar = b.hPA;
                        cf cfVar;
                        if (fT != null) {
                            g = fT.type;
                            z = true;
                            cfVar = dH;
                        } else {
                            g = 0;
                            z = true;
                            cfVar = dH;
                        }
                    }
                }
                bVar.a(auVar, z, g);
            } else {
                String str2 = fVar.fqm + "_" + fVar.yJJ;
                ar.Hg();
                cf dH2 = c.Fa().dH(fVar.fqm);
                l vL = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(fVar.fCs);
                g gVar;
                Object[] objArr;
                if (IF(str2)) {
                    g.pQN.k(10231, "1");
                    com.tencent.mm.av.b.Qo();
                    if (dH2.field_msgId == j) {
                        b.hPA.a(dH2, false, h.g(dH2));
                    }
                    if (!(vL == null || vL.hdX == null || vL.hdX.size() <= fVar.yJJ)) {
                        m mVar = (m) vL.hdX.get(fVar.yJJ);
                        gVar = g.pQN;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mVar.type == 6 ? 1 : 0);
                        objArr[1] = Integer.valueOf(1);
                        gVar.h(14972, objArr);
                    }
                } else {
                    if (!(vL == null || vL.hdX == null || vL.hdX.size() <= fVar.yJJ)) {
                        g.pQN.k(10090, "0,1");
                        m mVar2 = (m) vL.hdX.get(fVar.yJJ);
                        aVar = (a) com.tencent.mm.kernel.g.h(a.class);
                        valueOf = fVar.fzs;
                        str = mVar2.title;
                        String str3 = mVar2.her;
                        String str4 = mVar2.url;
                        String str5 = mVar2.url;
                        String str6 = mVar2.heq;
                        ar.Hg();
                        com.tencent.mm.av.b.b(aVar.a(0, valueOf, str, str3, str4, str5, str6, str2, c.FC(), fVar.fzs, "", ""));
                        gVar = g.pQN;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mVar2.type == 6 ? 1 : 0);
                        objArr[1] = Integer.valueOf(0);
                        gVar.h(14972, objArr);
                    }
                    if (dH2.field_msgId == j) {
                        b.hPA.a(dH2, true, h.g(dH2));
                    }
                }
            }
            this.ytD.ysg.ysf.notifyDataSetChanged();
        }
    }

    private static boolean IF(String str) {
        asv Qs = com.tencent.mm.av.b.Qs();
        if (Qs == null || Qs.vVZ == null || Qs.wAi != 0 || !com.tencent.mm.av.b.Qq()) {
            return false;
        }
        try {
            if (bh.fu(Qs.vVZ, str)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
