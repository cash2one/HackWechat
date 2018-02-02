package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements a {
    final /* synthetic */ b mrg;

    b$5(b bVar) {
        this.mrg = bVar;
    }

    public final boolean uF() {
        try {
            this.mrg.OW();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}
