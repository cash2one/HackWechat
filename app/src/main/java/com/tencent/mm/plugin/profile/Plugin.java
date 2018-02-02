package com.tencent.mm.plugin.profile;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public final class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
    }

    public final p createApplication() {
        x.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        return new a();
    }

    public final b getContactWidgetFactory() {
        x.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ap createSubCore() {
        x.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        return new b();
    }
}
