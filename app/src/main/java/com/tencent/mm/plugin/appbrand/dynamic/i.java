package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i {
    private static final Map<String, WxaWidgetContext> iSh = new ConcurrentHashMap();

    public static boolean a(String str, WxaWidgetContext wxaWidgetContext) {
        if (bh.ov(str) || wxaWidgetContext == null) {
            return false;
        }
        iSh.put(str, wxaWidgetContext);
        return true;
    }

    public static WxaWidgetContext ro(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (WxaWidgetContext) iSh.get(str);
    }

    public static WxaWidgetContext rp(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (WxaWidgetContext) iSh.remove(str);
    }
}
