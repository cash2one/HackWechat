package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class b extends a {
    public final void execute(g gVar) {
        k.b("wechatcommon", getClass().getClassLoader());
        MMBitmapFactory.init();
    }

    public final String name() {
        return "boot-load-wechatcommon-library";
    }
}
