package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

@Deprecated
public final class Plugin implements c {
    public final p createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ap createSubCore() {
        return new f();
    }
}
