package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b$a {
    public final Map<String, f> tNX = new ConcurrentHashMap();

    public final f Qn(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (f) this.tNX.get(str);
    }

    public final f Qo(String str) {
        return (f) this.tNX.remove(str);
    }
}
