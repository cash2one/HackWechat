package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.af;
import java.util.List;

public final class r {
    public p fhr;
    public aa yvM;

    public r(p pVar) {
        this.fhr = pVar;
    }

    public final boolean aP(au auVar) {
        if (!auVar.aNe()) {
            return false;
        }
        af.aI(auVar);
        this.fhr.mM(true);
        return true;
    }

    public final void ctS() {
        Intent intent = new Intent();
        g.pQN.h(12809, Integer.valueOf(1), "");
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.fhr.csv());
        intent.putExtra("map_talker_name", this.fhr.crz());
        d.b(this.fhr.csq().getContext(), "location", ".ui.RedirectUI", intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ctT() {
        boolean z = true;
        if (!a.aW(this.fhr.csq().getContext()) && !a.aU(this.fhr.csq().getContext())) {
            if (q.a.vcx.Fs(this.fhr.csi().field_username)) {
                x.i("MicroMsg.ChattingUI.LocationImp", "click share location, but now is in multitalk!");
                h.h(this.fhr.csq().getContext(), R.l.ewo, R.l.dGO);
                return;
            }
            String str = null;
            b riVar = new ri();
            if (q.a.vcp != null) {
                riVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                if (!bh.ov(riVar.fJd.fJg)) {
                    str = this.fhr.csq().getMMString(R.l.ebD);
                } else if (q.a.vcp.Mr(this.fhr.csi().field_username)) {
                    str = this.fhr.csq().getMMString(R.l.ebE);
                }
            }
            if (!bh.ov(str)) {
                if (q.a.vcw != null && q.a.vcw.DC(this.fhr.csi().field_username)) {
                    List DA = q.a.vcw.DA(this.fhr.csi().field_username);
                    if (DA != null) {
                    }
                }
                z = false;
                if (!z) {
                    i.a aVar = new i.a(this.fhr.csq().getContext());
                    aVar.YG(str);
                    aVar.EC(R.l.epk).a(new 2(this));
                    aVar.akx().show();
                    return;
                }
            }
            this.yvM.Zj("fromPluginLocation");
        }
    }
}
