package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        a.xef.b(new 1(this));
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new b();
    }
}
