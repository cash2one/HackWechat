package com.tencent.mm.plugin.ext;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public ap createSubCore() {
        return new b();
    }

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
