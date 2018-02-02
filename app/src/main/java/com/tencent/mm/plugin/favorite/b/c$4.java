package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements a {
    final /* synthetic */ c mrk;

    c$4(c cVar) {
        this.mrk = cVar;
    }

    public final boolean uF() {
        try {
            c.b(this.mrk);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}
