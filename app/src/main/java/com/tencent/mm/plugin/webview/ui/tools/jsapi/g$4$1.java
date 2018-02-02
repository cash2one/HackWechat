package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.h$a;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class g$4$1 implements Runnable {
    final /* synthetic */ amj tIl;
    final /* synthetic */ 4 tIm;

    g$4$1(4 4, amj com_tencent_mm_protocal_c_amj) {
        this.tIm = 4;
        this.tIl = com_tencent_mm_protocal_c_amj;
    }

    public final void run() {
        LinkedList linkedList = this.tIl.whQ;
        String str = this.tIl.niZ;
        String str2 = this.tIl.vFW;
        h hVar = new h(g.i(this.tIm.tIj));
        h$a 1 = new 1(this);
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
            g.a(this.tIm.tIj, this.tIm.tIg, "authorize:fail", null);
            this.tIm.tIk.afC();
        } else if (!hVar.a(linkedList, str, str2, 1)) {
            this.tIm.tIk.afC();
        }
    }
}
