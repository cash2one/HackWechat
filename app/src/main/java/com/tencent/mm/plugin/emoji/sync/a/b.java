package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.g.a.cq;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.z.ar;

public final class b extends d {
    private g lAg;
    private String lyH;
    private e lzY;
    private boolean lzc = false;

    public b(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.lyH = str;
    }

    public b(String str, byte b) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.lyH = str;
        this.lzc = true;
    }

    public final void run() {
        if (this.lzY != null) {
            this.lzY.yC(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo bf = i.aBE().lwM.bf(getKey(), true);
        if (this.lzc || bf == null || bf.field_sync != 2 || bf.field_status != 7) {
            this.lAg = new g(this.lyH);
            ar.CG().a(this.lAg, 0);
            abv com_tencent_mm_protocal_c_abv = new abv();
            com.tencent.mm.storage.emotion.i Ya = i.aBE().lwP.Ya(this.lyH);
            if (!(Ya == null || Ya.field_content == null)) {
                try {
                    com_tencent_mm_protocal_c_abv.aF(Ya.field_content);
                } catch (Throwable e) {
                    x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[]{bh.i(e)});
                }
            }
            if (com_tencent_mm_protocal_c_abv.wkD == null) {
                ar.CG().a(new l(this.lyH, 15), 0);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.b.b cqVar = new cq();
        cqVar.fqQ.fqR = getKey();
        cqVar.fqQ.fpr = 2;
        cqVar.fqQ.success = true;
        a.xef.m(cqVar);
    }

    public final String getKey() {
        return this.lyH == null ? "" : this.lyH;
    }

    public final void a(e eVar) {
        this.lzY = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(bh.ov(this.lyH) || bh.ov(bVar.getKey()) || !this.lyH.equals(bVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        if (this.lAg == null || bh.ov(this.lAg.hBn)) {
            x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            return;
        }
        com.tencent.mm.modelcdntran.g.MJ().kI(this.lAg.hBn);
        x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[]{this.lAg.hBn});
    }
}
