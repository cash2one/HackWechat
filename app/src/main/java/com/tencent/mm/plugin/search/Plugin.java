package com.tencent.mm.plugin.search;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    public final p createApplication() {
        return new a();
    }

    public final ap createSubCore() {
        return new com.tencent.mm.plugin.search.a.c();
    }

    public final b getContactWidgetFactory() {
        return null;
    }
}
