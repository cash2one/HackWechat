package com.tencent.mm.plugin.game.b;

import com.tencent.mm.plugin.game.b.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b mVK;

    b$1(b bVar) {
        this.mVK = bVar;
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.FTS.FTS5SearchGameLogic", "appinfo storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        switch (lVar.iYZ) {
            case 2:
            case 3:
                this.mVK.gJk.a(65606, new b(this.mVK, lVar.obj.toString()));
                return;
            case 5:
                this.mVK.gJk.a(65606, new b$a(this.mVK, lVar.obj.toString()));
                return;
            default:
                return;
        }
    }
}
