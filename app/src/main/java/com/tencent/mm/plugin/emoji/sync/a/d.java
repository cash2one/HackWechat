package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;

public final class d extends com.tencent.mm.plugin.emoji.sync.d {
    private String ibD;
    private k lAh;
    private EmojiInfo lAi;
    private e lzY;

    public d(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.ibD = str;
        this.lAi = i.aBE().lwL.XU(this.ibD);
    }

    public final void run() {
        if (this.lzY != null) {
            this.lzY.yC(this.ibD);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.lAi == null) {
            this.lzY.k(this.ibD, 1, false);
            return;
        }
        this.lAh = new f(this.lAi);
        ar.CG().a(this.lAh, 0);
    }

    public final String getKey() {
        return this.ibD;
    }

    public final void a(e eVar) {
        this.lzY = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(bh.ov(this.ibD) || bh.ov(dVar.ibD) || !this.ibD.equals(dVar.ibD))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
