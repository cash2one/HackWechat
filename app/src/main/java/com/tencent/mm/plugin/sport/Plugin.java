package com.tencent.mm.plugin.sport;

import com.tencent.mm.plugin.sport.c.o;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new d();
    }

    public b getContactWidgetFactory() {
        return new com.tencent.mm.plugin.sport.ui.a.b();
    }

    public ap createSubCore() {
        return new o();
    }
}
