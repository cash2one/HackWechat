package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

class aa$5 implements a {
    final /* synthetic */ aa yCl;

    aa$5(aa aaVar) {
        this.yCl = aaVar;
    }

    public final void cqj() {
        if (com.tencent.mm.p.a.aW(this.yCl.fhr.csq().getContext()) || com.tencent.mm.p.a.aU(this.yCl.fhr.csq().getContext())) {
            x.d("MicroMsg.ChattingUI.TrackRoomImp", "voip is running");
            return;
        }
        List DA = q.a.vcw.DA(this.yCl.fhr.csi().field_username);
        x.i("MicroMsg.ChattingUI.TrackRoomImp", "Click banner : %d", new Object[]{Integer.valueOf(DA.size())});
        if (q.a.vcw.DC(this.yCl.fhr.csi().field_username)) {
            aa aaVar = this.yCl;
            if (!aaVar.fhr.csi().field_username.toLowerCase().endsWith("@chatroom") || aaVar.fhr.csu()) {
                b riVar = new ri();
                riVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                String str;
                if (bh.ov(riVar.fJd.fJg) || aaVar.fhr.csi().field_username.equals(riVar.fJd.fJg)) {
                    str = aaVar.fhr.csi().field_username;
                    aaVar.bm("fromBanner", false);
                    return;
                }
                riVar = new ri();
                riVar.fJc.fJf = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                str = aaVar.fhr.csi().field_username;
                aaVar.bm("fromBanner", false);
                return;
            }
            h.b(aaVar.fhr.csq().getContext(), aaVar.fhr.csq().getMMString(R.l.eRm), null, true);
            return;
        }
        this.yCl.mP(true);
    }

    public final void cqk() {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        this.yCl.Zk(this.yCl.fhr.csi().field_username);
    }
}
