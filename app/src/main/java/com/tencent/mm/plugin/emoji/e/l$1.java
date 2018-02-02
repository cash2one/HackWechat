package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class l$1 implements a {
    final /* synthetic */ l lxg;

    l$1(l lVar) {
        this.lxg = lVar;
    }

    public final void a(String str, l lVar) {
        if (!bh.ov(str) && str.equals("event_update_group")) {
            x.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[]{(String) lVar.obj});
            if (g.Dh().Cy()) {
                i.aBz().aAN();
            } else {
                return;
            }
        }
        if (!bh.ov(str)) {
            if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                x.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                l.lwW = true;
                l.lwZ = true;
            }
        }
    }
}
