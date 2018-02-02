package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.plugin.ac.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public c pTk = new 1(this);
    public c pTl = new 2(this);
    a pTm = new 3(this);

    public final boolean h(b bVar) {
        if (bVar != null) {
            if (bVar instanceof mp) {
                l.pST.reset();
                l.pST.vE(l.pSS);
                mp mpVar = (mp) bVar;
                com.tencent.mm.plugin.scanner.c.boA().pSf.a(mpVar.fEA.filePath, this.pTm, mpVar.fEA.fEB);
            } else if (bVar instanceof ak) {
                l.pST.aUb();
                ak akVar = (ak) bVar;
                com.tencent.mm.plugin.ac.a.b bVar2 = com.tencent.mm.plugin.scanner.c.boA().pSf;
                String str = akVar.fow.filePath;
                x.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(this.pTm.hashCode())});
                if (bh.ov(str)) {
                    x.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    bVar2.jKT.post(new b$2(bVar2, str, r2));
                }
            }
        }
        return false;
    }
}
