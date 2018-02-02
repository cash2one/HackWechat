package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$1 implements Runnable {
    final /* synthetic */ b kkP;
    final /* synthetic */ String val$url;

    b$1(b bVar, String str) {
        this.kkP = bVar;
        this.val$url = str;
    }

    public final void run() {
        c aoU = b.aoR().aoU();
        x.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[]{this.val$url});
        ar.CG().a(595, aoU.klp);
        ar.CG().a(new e(r1), 0);
    }
}
