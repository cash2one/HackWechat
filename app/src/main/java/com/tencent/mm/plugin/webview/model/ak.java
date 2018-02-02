package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class ak {
    private static Map<String, String> tto = new HashMap();

    public static void eL(String str, String str2) {
        x.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
        } else if (tto.containsKey(str)) {
            x.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
        } else {
            tto.put(str, str2);
        }
    }

    public static String BP(String str) {
        x.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[]{str});
        if (bh.ov(str)) {
            x.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            return null;
        }
        String str2 = (String) tto.get(str);
        if (bh.ov(str2)) {
            int indexOf = str.indexOf("#");
            str2 = (String) tto.get(indexOf < 0 ? str : str.substring(0, indexOf));
        }
        return !bh.ov(str2) ? str2 : str;
    }

    public static void clear() {
        tto.clear();
    }
}
