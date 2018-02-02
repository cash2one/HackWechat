package com.tencent.mm.q;

import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class b$f extends a {
    private boolean gJC = false;
    final /* synthetic */ b gJn;
    private int gJy;
    private String gJz;

    public b$f(b bVar, String str) {
        this.gJn = bVar;
        this.gJz = str;
        this.gJy = 0;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.gJz, Integer.valueOf(this.gJy)});
        if (this.gJy == 0) {
            b kS = af.OD().kS(this.gJz);
            if (kS == null) {
                this.gJC = true;
            } else {
                b.a aVar = new b.a(kS);
                if (b.a(aVar)) {
                    b.a(this.gJn, aVar);
                } else {
                    this.gJC = true;
                }
            }
        }
        return true;
    }

    public final String toString() {
        return "InsertFriend(\"" + this.gJz + "\", " + this.gJy + ")" + (this.gJC ? " [skipped]" : "");
    }
}
