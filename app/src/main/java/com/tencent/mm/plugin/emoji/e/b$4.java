package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.co;
import com.tencent.mm.plugin.emoji.e.d.1;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

class b$4 extends c<co> {
    final /* synthetic */ b lvv;

    b$4(b bVar) {
        this.lvv = bVar;
        this.xen = co.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        switch (((co) bVar).fqN.state) {
            case 0:
                d aAQ = d.aAQ();
                ar.Hg();
                String Fp = com.tencent.mm.z.c.Fp();
                aAQ.lvD = true;
                if (bh.ov(Fp)) {
                    x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                } else {
                    ar.Hg();
                    x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", new Object[]{Boolean.valueOf(System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(a.xns, Long.valueOf(0))).longValue() >= 86400000)});
                    if (System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(a.xns, Long.valueOf(0))).longValue() >= 86400000) {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                        ar.Dm().F(new 1(aAQ, Fp));
                    }
                }
                e aAR = e.aAR();
                if (aAR.isEnable()) {
                    if (!aAR.bgH) {
                        aAR.bgH = true;
                        ar.Hg();
                        if (System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(a.xnt, Long.valueOf(0))).longValue() < 86400000) {
                            z = false;
                        }
                        if (!z) {
                            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                            break;
                        }
                        ar.Dm().F(new e.1(aAR));
                        break;
                    }
                    x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                    break;
                }
                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                break;
            case 1:
                d.aAQ().lvD = false;
                e.aAR().bgH = false;
                break;
        }
        return false;
    }
}
