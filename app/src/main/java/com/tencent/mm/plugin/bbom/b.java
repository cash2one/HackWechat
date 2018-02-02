package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.ae.d;
import com.tencent.mm.aq.o;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.is;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class b implements a {
    public final void a(d.a aVar, au auVar, final String str, String str2, boolean z) {
        int i = 1;
        final bw bwVar = aVar.hmq;
        final com.tencent.mm.z.ba.b hT = ba.hT(bwVar.vHc);
        if (hT != null) {
            auVar.dZ(hT.hgH);
            auVar.dW(hT.hgG);
            x.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[]{hT.hgG});
            if (!(hT.hgI == null || hT.scene != 1 || bwVar.ngq == 10000)) {
                ar.Hg();
                com.tencent.mm.l.a WO = c.EY().WO(str);
                if (WO == null || ((int) WO.gJd) <= 0) {
                    ak.a.hfL.a(str, null, new com.tencent.mm.z.ak.b.a(this) {
                        final /* synthetic */ b kvx;

                        public final void v(String str, boolean z) {
                            ar.Hg();
                            b.a(bwVar, hT, c.EY().WO(str));
                        }
                    });
                } else {
                    a(bwVar, hT, WO);
                }
            }
        }
        int i2;
        if (s.gE(str) && s.hs(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!s.eV(str) || s.hr(str)) {
            i = 0;
        }
        if (!z && auVar.cje() && r0 == 0 && r1 == 0) {
            com.tencent.mm.modelcontrol.c.MR();
            if (com.tencent.mm.modelcontrol.c.l(auVar)) {
                com.tencent.mm.aq.b Py = o.Py();
                long j = auVar.field_msgId;
                com.tencent.mm.modelcontrol.c.MR();
                if (com.tencent.mm.modelcontrol.c.MS()) {
                    synchronized (Py.hzl) {
                        if (Py.hzl.size() >= 100) {
                            Py.hzl.remove(0);
                        }
                        Py.hzl.push(Long.valueOf(j));
                    }
                    Py.hzp = System.currentTimeMillis();
                    Py.start();
                }
            }
        }
    }

    static void a(bw bwVar, com.tencent.mm.z.ba.b bVar, com.tencent.mm.storage.x xVar) {
        int i;
        String a = n.a(bwVar.vGX);
        ar.Hg();
        c.CU().set(73729, Integer.valueOf(1));
        String str = xVar.field_nickname;
        h hVar = new h();
        hVar.field_content = n.a(bwVar.vGZ);
        hVar.field_createtime = bh.Wo();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = bwVar.ngq == 3 ? ac.getContext().getString(R.l.exy) : n.a(bwVar.vGZ);
        hVar.field_sayhiuser = a;
        hVar.field_scene = 18;
        if (bwVar.ktm > 3) {
            i = bwVar.ktm;
        } else {
            i = 3;
        }
        hVar.field_status = i;
        hVar.field_svrid = bwVar.vHe;
        hVar.field_talker = str;
        hVar.field_type = bwVar.ngq;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = a;
        hVar.field_ticket = bVar.hgI;
        l.Ty().a(hVar);
        com.tencent.mm.sdk.b.b isVar = new is();
        isVar.fzh.fzi = a;
        com.tencent.mm.sdk.b.a.xef.m(isVar);
    }
}
