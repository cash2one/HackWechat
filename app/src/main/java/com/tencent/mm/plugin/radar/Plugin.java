package com.tencent.mm.plugin.radar;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    public final p createApplication() {
        return new b();
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ap createSubCore() {
        return new c();
    }
}
