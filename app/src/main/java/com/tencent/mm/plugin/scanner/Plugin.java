package com.tencent.mm.plugin.scanner;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new b();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new c();
    }
}
