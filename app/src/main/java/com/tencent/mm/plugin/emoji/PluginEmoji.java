package com.tencent.mm.plugin.emoji;

import com.tencent.mm.api.o;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.h.n;

public class PluginEmoji extends f implements c {
    private d ltc;
    e ltd;

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        alias(c.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.pluginsdk.ui.d.d.a.a(com.tencent.mm.bx.g.chg());
        b.cgX();
        n.bYX();
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            pin(d.aAl());
            if (gVar.DS()) {
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.d(new a()));
            }
        }
        com.tencent.mm.ui.e.b.c.a(new 1(this));
        com.tencent.mm.ui.e.c.b.a(new 2(this));
        o.fdN = new 3(this);
    }

    public void setEmojiMgr() {
        if (this.ltc == null) {
            this.ltc = com.tencent.mm.plugin.emoji.b.b.a.luX.aAL();
        }
    }

    public void removeEmojiMgr() {
        this.ltc = null;
    }

    public d getEmojiMgr() {
        setEmojiMgr();
        return this.ltc;
    }

    public e getProvider() {
        if (this.ltd == null) {
            this.ltd = new com.tencent.mm.bu.a();
        }
        return this.ltd;
    }
}
