package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class aa {
    private static final Set<String> tsq;

    static {
        Set hashSet = new HashSet();
        tsq = hashSet;
        hashSet.add("file:///android_asset/");
        String str = e.gZL;
        if (!bh.ov(str)) {
            str = e.gZL.replace("/data/user/0", "/data/data");
        }
        tsq.add("file://" + new File(g.zR(0)).getAbsolutePath());
        tsq.add("file://" + new File(e.bnF, g.zP(0)).getAbsolutePath());
        tsq.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        tsq.add("file://" + new File(e.bnF, "wenote/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath()});
        tsq.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        tsq.add("file://" + new File(e.bnF, "emoji/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = tsq.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public static boolean Oj(String str) {
        if (r.idq) {
            x.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            return true;
        } else if (bh.ov(str)) {
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                return false;
            }
            if (toLowerCase.startsWith("file://")) {
                for (String startsWith : tsq) {
                    if (toLowerCase.startsWith(startsWith)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (bh.ov(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(s.ccQ());
        }
    }
}
