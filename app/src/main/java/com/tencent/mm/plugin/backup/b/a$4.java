package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ byte[] fgL;
    final /* synthetic */ a kja;
    final /* synthetic */ int kjb;
    final /* synthetic */ long kjc;

    a$4(a aVar, int i, byte[] bArr, long j) {
        this.kja = aVar;
        this.kjb = i;
        this.fgL = bArr;
        this.kjc = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        long Wp = bh.Wp();
        x.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", new Object[]{Integer.valueOf(a.a(this.kja)), Integer.valueOf(this.kjb), Integer.valueOf(bh.bx(this.fgL)), Long.valueOf(Wp - this.kjc)});
        if (a.a(this.kja) == 0) {
            x.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
            return;
        }
        int send = a.a(this.kja) == 1 ? Java2C.send(a.b(this.kja), a.c(this.kja), this.fgL) : a.a(this.kja) == 2 ? Client.Java2C.send(a.b(this.kja), a.c(this.kja), this.fgL) : 0;
        b.mN(bh.bx(this.fgL));
        x.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", new Object[]{Integer.valueOf(send), Integer.valueOf(this.kjb), Integer.valueOf(bh.bx(this.fgL)), Long.valueOf(bh.bz(this.kjc)), Long.valueOf(bh.bz(Wp))});
    }
}
