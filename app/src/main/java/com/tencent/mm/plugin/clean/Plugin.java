package com.tencent.mm.plugin.clean;

import com.tencent.mm.plugin.clean.a.a;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return j.ayv();
    }
}
