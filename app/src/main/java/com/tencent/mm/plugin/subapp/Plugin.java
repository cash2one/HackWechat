package com.tencent.mm.plugin.subapp;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    }

    public final p createApplication() {
        x.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        return new b();
    }

    public final b getContactWidgetFactory() {
        x.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ap createSubCore() {
        x.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        return new a();
    }
}
