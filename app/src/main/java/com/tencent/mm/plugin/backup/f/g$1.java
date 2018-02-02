package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements a {
    final /* synthetic */ g kpp;

    g$1(g gVar) {
        this.kpp = gVar;
    }

    public final boolean uF() {
        if (g.a(this.kpp)) {
            x.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[]{Integer.valueOf(g.JM())});
            this.kpp.kpm = 0;
        } else {
            x.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[]{Integer.valueOf(g.JM())});
            if (g.JM() < g.b(this.kpp).length) {
                g.c(this.kpp).apz();
                g.d(this.kpp).J((long) g.b(this.kpp)[g.JM()], (long) g.b(this.kpp)[g.JM()]);
                g.JO();
            } else {
                g.e(this.kpp);
                this.kpp.kpm = 0;
                g.c(this.kpp).apA();
            }
        }
        return false;
    }
}
