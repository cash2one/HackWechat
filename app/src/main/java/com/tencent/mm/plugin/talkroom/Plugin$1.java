package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.iz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class Plugin$1 extends c<iz> {
    final /* synthetic */ Plugin saq;

    Plugin$1(Plugin plugin) {
        this.saq = plugin;
        this.xen = iz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((iz) bVar).fzC.status) {
            case 0:
                if (com.tencent.mm.plugin.talkroom.model.b.bEC() != null) {
                    com.tencent.mm.plugin.talkroom.model.b.bEC().aWa();
                    break;
                }
                break;
        }
        return false;
    }
}
