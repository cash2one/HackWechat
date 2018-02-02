package com.tencent.mm.plugin.music;

import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new b();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new h();
    }
}
