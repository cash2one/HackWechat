package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.a;
import com.tencent.mm.plugin.backup.f.c.b;
import com.tencent.mm.sdk.platformtools.x;

class c$b$1 implements b {
    final /* synthetic */ c.b kjK;

    c$b$1(c.b bVar) {
        this.kjK = bVar;
    }

    public final void c(boolean z, String str, int i) {
        a aVar = this.kjK.kjA;
        long j = (long) i;
        aVar.kjw.addAndGet(0 - j);
        if (aVar.kjw.get() < 8388608) {
            aVar.kjx.open();
        }
        if (aVar.kjw.get() < 16777216) {
            aVar.kjy.open();
        }
        String str2 = "MicroMsg.BackupPackAndSend";
        String str3 = "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(aVar.kjw.get());
        objArr[2] = Boolean.valueOf(aVar.kjw.get() >= 8388608);
        objArr[3] = Boolean.valueOf(aVar.kjw.get() >= 16777216);
        objArr[4] = Boolean.valueOf(aVar.kjx.xfv);
        objArr[5] = Boolean.valueOf(aVar.kjy.xfv);
        x.v(str2, str3, objArr);
        this.kjK.kjv.kjq += (long) i;
        x.i(this.kjK.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str});
    }
}
