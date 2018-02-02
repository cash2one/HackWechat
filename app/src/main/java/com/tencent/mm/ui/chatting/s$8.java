package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.List;

class s$8 implements Runnable {
    final /* synthetic */ s ytT;
    final /* synthetic */ List ytZ;

    s$8(s sVar, List list) {
        this.ytT = sVar;
        this.ytZ = list;
    }

    public final void run() {
        for (au auVar : this.ytZ) {
            if (auVar.cje()) {
                int i;
                e bh = o.Pw().bh(auVar.field_msgSvrId);
                if (auVar.field_isSend == 1) {
                    int i2;
                    if (bh.Pe()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    i = i2;
                } else if (bh.Pe()) {
                    if (com.tencent.mm.a.e.bO(o.Pw().m(f.a(bh).hzQ, "", ""))) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (bh.offset < bh.hlp || bh.hlp == 0) {
                    o.Px().a(bh.hzP, auVar.field_msgId, i, Long.valueOf(auVar.field_msgId), R.g.bAH, new 1(this));
                }
            } else if (auVar.cjm()) {
                l.a(auVar, null);
            } else if (auVar.cjh() || auVar.cji()) {
                r nF = t.nF(auVar.field_imgPath);
                if (!(nF == null || nF.status == 199)) {
                    if (nF.Ui()) {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                        t.nJ(auVar.field_imgPath);
                    } else {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                        t.nB(auVar.field_imgPath);
                    }
                }
            }
        }
    }
}
