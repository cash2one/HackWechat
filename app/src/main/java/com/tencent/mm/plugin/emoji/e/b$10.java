package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.bx.e;
import com.tencent.mm.bx.f;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.my;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$10 extends c<cm> {
    final /* synthetic */ b lvv;

    b$10(b bVar) {
        this.lvv = bVar;
        this.xen = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((cm) bVar).fqK.fpn) {
            case 1:
                f.chd().chf();
                e.chc().anl();
                a.xef.m(new my());
                break;
            case 2:
                e.chc().anl();
                a.xef.m(new my());
                break;
            default:
                x.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                break;
        }
        return false;
    }
}
