package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onStickyStatusChange";

    public final void X(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isSticky", Boolean.valueOf(z));
        v(hashMap).az(str, 0).afs();
    }
}
