package com.tencent.mm.plugin.bottle;

import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    private b kAA = new 1(this);

    public final p createApplication() {
        return new a();
    }

    public final ap createSubCore() {
        return new i();
    }

    public final b getContactWidgetFactory() {
        return this.kAA;
    }
}
