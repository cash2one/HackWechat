package com.tencent.mm.ui.chatting.e;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.gridviewheaders.a;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Date;
import java.util.LinkedList;

class h$1 implements Runnable {
    final /* synthetic */ h yHO;
    final /* synthetic */ boolean yHb = true;

    h$1(h hVar, boolean z) {
        this.yHO = hVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        ar.Hg();
        Cursor by = c.Fa().by(this.yHO.jRw, this.yHO.jRy);
        if (by == null) {
            x.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
            return;
        }
        q hD;
        if (s.eV(this.yHO.jRw)) {
            ar.Hg();
            hD = c.Fh().hD(this.yHO.jRw);
        } else {
            hD = null;
        }
        long j = 0;
        while (by.moveToNext()) {
            try {
                cf auVar = new au();
                auVar.b(by);
                String str = auVar.field_content;
                if (str != null) {
                    g$a fT = g$a.fT(str);
                    h hVar = this.yHO;
                    int i = fT.type;
                    hVar.getType();
                    if (hVar.yHN.contains(Integer.valueOf(i))) {
                        long b = a.cxk().b(new Date(auVar.field_createTime));
                        if (j != b) {
                            linkedList.add(new b.c(auVar.field_createTime));
                            h hVar2 = this.yHO;
                            hVar2.yHq++;
                        }
                        String g = h.g(auVar, s.eV(this.yHO.jRw));
                        af WO = ((h) g.h(h.class)).EY().WO(g);
                        String str2 = "";
                        if (hD != null) {
                            str2 = hD.gu(g);
                        }
                        int Rr = com.tencent.mm.pluginsdk.model.c.Rr(fT.hbc);
                        String appName = d.getAppName(this.yHO.mContext, fT.fGz);
                        ar.Hg();
                        af WO2 = c.EY().WO(fT.fGz);
                        if (WO2 == null || !WO2.field_username.equals(fT.fGz)) {
                            ak.a.hfL.a(fT.fGz, "", null);
                        } else {
                            appName = WO2.AQ();
                        }
                        h$a com_tencent_mm_ui_chatting_e_h_a = new h$a(this.yHO, auVar.field_createTime, fT.type, fT.title, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2);
                        com_tencent_mm_ui_chatting_e_h_a.bhd = bh.ov(appName) ? fT.description : appName;
                        com_tencent_mm_ui_chatting_e_h_a.appId = fT.appId;
                        if (bh.ov(auVar.field_imgPath)) {
                            com_tencent_mm_ui_chatting_e_h_a.imagePath = fT.thumburl;
                        } else {
                            com_tencent_mm_ui_chatting_e_h_a.imagePath = auVar.field_imgPath;
                        }
                        com_tencent_mm_ui_chatting_e_h_a.iconRes = Rr;
                        linkedList.add(com_tencent_mm_ui_chatting_e_h_a);
                        j = b;
                    }
                }
            } finally {
                by.close();
            }
        }
        this.yHO.jRt.addAll(linkedList);
        this.yHO.yHi = this.yHO.jRt;
        linkedList.clear();
        ag.y(new Runnable(this) {
            final /* synthetic */ h$1 yHP;

            {
                this.yHP = r1;
            }

            public final void run() {
                if (this.yHP.yHO.yHf != null) {
                    this.yHP.yHO.yHf.z(this.yHP.yHb, this.yHP.yHO.jRt.size());
                }
            }
        });
    }
}
