package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ byte[] fgL;
    final /* synthetic */ b kqA;

    b$4(b bVar, byte[] bArr) {
        this.kqA = bVar;
        this.fgL = bArr;
    }

    public final void run() {
        try {
            synchronized (b.a(this.kqA)) {
                b.b(this.kqA).write(this.fgL);
                b.b(this.kqA).flush();
            }
        } catch (Exception e) {
            x.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[]{e});
            b.c(this.kqA);
            b.a(this.kqA, 10008, ("send_error " + e).getBytes());
        }
    }
}
