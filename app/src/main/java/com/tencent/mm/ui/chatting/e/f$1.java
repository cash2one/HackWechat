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

class f$1 implements Runnable {
    final /* synthetic */ f yHG;
    final /* synthetic */ boolean yHb = true;

    f$1(f fVar, boolean z) {
        this.yHG = fVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        ar.Hg();
        Cursor by = c.Fa().by(this.yHG.jRw, this.yHG.jRy);
        if (by == null) {
            x.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
            return;
        }
        q hD;
        if (s.eV(this.yHG.jRw)) {
            ar.Hg();
            hD = c.Fh().hD(this.yHG.jRw);
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
                    if ((3 == fT.type ? 1 : null) != null) {
                        long b = a.cxk().b(new Date(auVar.field_createTime));
                        if (j != b) {
                            linkedList.add(new b.c(auVar.field_createTime));
                            f fVar = this.yHG;
                            fVar.yHq++;
                        }
                        String g = f.g(auVar, s.eV(this.yHG.jRw));
                        af WO = ((h) g.h(h.class)).EY().WO(g);
                        String str2 = "";
                        if (hD != null) {
                            str2 = hD.gu(g);
                        }
                        int Rr = com.tencent.mm.pluginsdk.model.c.Rr(fT.hbc);
                        String appName = d.getAppName(this.yHG.mContext, fT.fGz);
                        ar.Hg();
                        af WO2 = c.EY().WO(fT.fGz);
                        if (WO2 == null || !WO2.field_username.equals(fT.fGz)) {
                            ak.a.hfL.a(fT.fGz, "", null);
                        } else {
                            appName = WO2.AQ();
                        }
                        f$a com_tencent_mm_ui_chatting_e_f_a = new f$a(this.yHG, auVar.field_createTime, fT.type, fT.title, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2);
                        com_tencent_mm_ui_chatting_e_f_a.bhd = bh.ov(appName) ? fT.description : appName;
                        com_tencent_mm_ui_chatting_e_f_a.appId = fT.appId;
                        com_tencent_mm_ui_chatting_e_f_a.imagePath = auVar.field_imgPath;
                        com_tencent_mm_ui_chatting_e_f_a.iconRes = Rr;
                        linkedList.add(com_tencent_mm_ui_chatting_e_f_a);
                        j = b;
                    }
                }
            } finally {
                by.close();
            }
        }
        this.yHG.jRt.addAll(linkedList);
        this.yHG.yHi = this.yHG.jRt;
        linkedList.clear();
        ag.y(new 1(this));
    }
}
