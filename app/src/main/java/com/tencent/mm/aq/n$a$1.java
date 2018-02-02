package com.tencent.mm.aq;

import com.tencent.mm.aq.n.a;
import com.tencent.mm.aq.n.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.x;

class n$a$1 implements Runnable {
    final /* synthetic */ e hCd;
    final /* synthetic */ a hCe;

    n$a$1(a aVar, e eVar) {
        this.hCe = aVar;
        this.hCd = eVar;
    }

    public final void run() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        a.a aVar = new a.a();
        aVar.hCf = new PString();
        aVar.hCg = new PString();
        aVar.hCh = new PString();
        aVar.hCi = new PString();
        aVar.hAa = o.Pw().a(this.hCd.hCn, FileOp.mk(this.hCd.hCn), this.hCd.hzT, true, aVar.hCf, aVar.hCg, aVar.hCh, aVar.hCi, this.hCd.hCp, this.hCd.hCu);
        a.a(this.hCe).lock();
        try {
            this.hCe.hCc = aVar;
            a.b(this.hCe).signal();
            x.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[]{this.hCd.hCn, Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        } finally {
            a.a(this.hCe).unlock();
        }
    }
}
