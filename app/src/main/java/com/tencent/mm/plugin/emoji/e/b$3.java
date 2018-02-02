package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.jh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

class b$3 extends c<jh> {
    final /* synthetic */ b lvv;

    b$3(b bVar) {
        this.lvv = bVar;
        this.xen = jh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jh jhVar = (jh) bVar;
        if (jhVar != null && (jhVar instanceof jh)) {
            x.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
            if (jhVar.fzJ.fnI) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(a.xno, Boolean.valueOf(true));
            }
        }
        return false;
    }
}
