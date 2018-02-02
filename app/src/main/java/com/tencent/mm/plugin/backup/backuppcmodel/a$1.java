package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b;

class a$1 implements Runnable {
    final /* synthetic */ a knw;

    a$1(a aVar) {
        this.knw = aVar;
    }

    public final void run() {
        if (this.knw.klB != null) {
            this.knw.klB.cancel();
        }
        this.knw.klB = new b();
        this.knw.klB.a(this.knw);
    }
}
