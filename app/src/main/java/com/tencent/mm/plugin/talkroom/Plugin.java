package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public Plugin() {
        a.xef.b(new 1(this));
        a.xef.b(new b((byte) 0));
        a.xef.b(new a(this, (byte) 0));
        a.xef.b(new c(this, (byte) 0));
    }

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.talkroom.model.b();
    }
}
