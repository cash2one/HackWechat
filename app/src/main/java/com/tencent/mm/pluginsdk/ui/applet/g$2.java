package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.i.b;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements b {
    final /* synthetic */ g vnF;

    g$2(g gVar) {
        this.vnF = gVar;
    }

    public final boolean oc(int i) {
        if (this.vnF.vnx.vnT && this.vnF.vnx.Ca(i) && !this.vnF.vnx.BZ(i)) {
            x.d("MicroMsg.ContactListArchor", "onItemLongClick " + i);
        }
        return true;
    }
}
