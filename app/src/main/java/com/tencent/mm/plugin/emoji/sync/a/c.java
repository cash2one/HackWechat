package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c extends d {
    private String lyH;
    private e lzY;

    public c(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.lyH = str;
    }

    public final void run() {
        if (this.lzY != null) {
            this.lzY.yC(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        com.tencent.mm.sdk.e.c bf = i.aBE().lwM.bf(EmojiGroupInfo.xAb, false);
        bf.field_flag = 0;
        i.aBE().lwM.a(bf);
        if (this.lzY != null) {
            this.lzY.k(getKey(), 2, true);
        }
    }

    public final String getKey() {
        return this.lyH == null ? "" : this.lyH;
    }

    public final void a(e eVar) {
        this.lzY = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(bh.ov(this.lyH) || bh.ov(cVar.getKey()) || !this.lyH.equals(cVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
