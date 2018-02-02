package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class NormalUserFooterPreference$c$5 implements a {
    final /* synthetic */ c pkM;
    final /* synthetic */ com.tencent.mm.pluginsdk.ui.applet.a pkP;
    final /* synthetic */ String pkQ;
    final /* synthetic */ LinkedList pkR;

    NormalUserFooterPreference$c$5(c cVar, com.tencent.mm.pluginsdk.ui.applet.a aVar, String str, LinkedList linkedList) {
        this.pkM = cVar;
        this.pkP = aVar;
        this.pkQ = str;
        this.pkR = linkedList;
    }

    public final void v(String str, boolean z) {
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(this.pkM.pkA.jLe.field_username);
        this.pkP.Sk(WO != null ? bh.az(WO.fWF, "") : "");
        this.pkP.b(this.pkM.pkA.jLe.field_username, this.pkQ, this.pkR);
    }
}
