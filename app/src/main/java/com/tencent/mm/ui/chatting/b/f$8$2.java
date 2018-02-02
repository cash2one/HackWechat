package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.b.f.8;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.LinkedList;

class f$8$2 implements a {
    final /* synthetic */ String pkQ;
    final /* synthetic */ 8 yzG;

    f$8$2(8 8, String str) {
        this.yzG = 8;
        this.pkQ = str;
    }

    public final void v(String str, boolean z) {
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.yzG.yzA.fhr.csq().getContext(), new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
            final /* synthetic */ f$8$2 yzH;

            {
                this.yzH = r1;
            }

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    s.p(this.yzH.yzG.yzA.fhr.csi());
                    this.yzH.yzG.yzF.setVisibility(8);
                }
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(3));
        ar.Hg();
        af WO = c.EY().WO(this.yzG.yzA.yzm);
        aVar.Sk(WO != null ? bh.az(WO.fWF, "") : "");
        aVar.b(this.yzG.yzA.yzm, this.pkQ, linkedList);
    }
}
