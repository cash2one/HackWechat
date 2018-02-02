package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.chatroom.b.c;
import com.tencent.mm.z.n;

public class PluginChatroom extends f implements c {
    public String name() {
        return "plugin-chatroom";
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.a(a.class, new n());
        }
    }
}
