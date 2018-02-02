package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$5 implements a {
    final /* synthetic */ c klx;

    c$5(c cVar) {
        this.klx = cVar;
    }

    public final boolean uF() {
        if (!c.apc()) {
            x.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
            if (c.d(this.klx) != null) {
                c.d(this.klx).TG();
            }
            c.e(this.klx);
        }
        return true;
    }
}
