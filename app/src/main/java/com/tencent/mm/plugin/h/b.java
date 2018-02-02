package com.tencent.mm.plugin.h;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b extends a {
    public final void execute(g gVar) {
        k.b("FFmpeg", getClass().getClassLoader());
        k.b("wechatpack", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-FFmpeg-and-wechatpack-libraries";
    }
}
