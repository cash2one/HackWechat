package com.tencent.mm.plugin.qqmail;

import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    private a pnV = new a();

    public final p createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return this.pnV;
    }

    public final ap createSubCore() {
        return new w();
    }
}
