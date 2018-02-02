package com.tencent.mm.plugin.subapp.ui.friend;

import com.tencent.mm.R;
import com.tencent.mm.bf.l;
import com.tencent.mm.plugin.subapp.ui.friend.b.2;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class b$2$1 implements a {
    final /* synthetic */ b rWS;
    final /* synthetic */ x rWT;
    final /* synthetic */ 2 rWU;

    b$2$1(2 2, b bVar, x xVar) {
        this.rWU = 2;
        this.rWS = bVar;
        this.rWT = xVar;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (z) {
            ar.Hg();
            x WO = c.EY().WO(this.rWS.username);
            if (((int) WO.gJd) == 0) {
                WO = this.rWT;
                ar.Hg();
                if (!c.EY().R(WO)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    return;
                }
            }
            s.p(WO);
            l.Tx().T(this.rWS.username, 1);
            h.bu(b.a(this.rWU.rWR), b.a(this.rWU.rWR).getString(R.l.dDL));
            b.a(this.rWU.rWR, this.rWS.username);
        } else if (z2) {
            l.Tx().T(this.rWS.username, 2);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + this.rWS.username);
            return;
        }
        this.rWU.rWR.notifyDataSetChanged();
    }
}
