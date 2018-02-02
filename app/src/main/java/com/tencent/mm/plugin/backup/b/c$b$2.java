package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.a;
import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.f.c.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$b$2 implements c {
    final /* synthetic */ b kjK;

    c$b$2(b bVar) {
        this.kjK = bVar;
    }

    public final void a(com.tencent.mm.plugin.backup.f.c cVar) {
        long Wp = bh.Wp();
        a aVar = this.kjK.kjA;
        long apX = (long) cVar.apX();
        boolean z = this.kjK.iQP;
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Long.valueOf(apX);
        objArr[2] = Long.valueOf(aVar.kjw.get());
        objArr[3] = Boolean.valueOf(aVar.kjw.get() >= 8388608);
        objArr[4] = Boolean.valueOf(aVar.kjw.get() >= 16777216);
        x.v(str, str2, objArr);
        if (aVar.kjw.get() + apX >= 8388608) {
            aVar.kjx.close();
        }
        if (aVar.kjw.get() >= 16777216) {
            aVar.kjy.close();
        }
        long Wp2 = bh.Wp();
        while (!aVar.kjv.kjn) {
            if (aVar.kjw.get() < (z ? 16777216 : 8388608)) {
                aVar.kjw.addAndGet(apX);
                str = "MicroMsg.BackupPackAndSend";
                String str3 = "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]";
                Object[] objArr2 = new Object[6];
                objArr2[0] = Long.valueOf(bh.bz(Wp2));
                objArr2[1] = Boolean.valueOf(z);
                objArr2[2] = Long.valueOf(apX);
                objArr2[3] = Long.valueOf(aVar.kjw.get());
                objArr2[4] = Boolean.valueOf(aVar.kjw.get() >= 8388608);
                objArr2[5] = Boolean.valueOf(aVar.kjw.get() >= 16777216);
                x.v(str, str3, objArr2);
                this.kjK.kjz.offer(new 1(this, cVar, Wp));
            }
            (z ? aVar.kjy : aVar.kjx).cfB();
        }
        this.kjK.kjz.offer(new 1(this, cVar, Wp));
    }
}
