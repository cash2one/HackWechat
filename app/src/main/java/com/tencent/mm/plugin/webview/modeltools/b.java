package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.c;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public static final String tul = Integer.toString(100028);

    public static void d(d dVar) {
        Bundle e;
        try {
            e = dVar.e(24, new Bundle(0));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", e2, "", new Object[0]);
            e = null;
        }
        if (e == null) {
            x.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            return;
        }
        List stringArrayList = e.getStringArrayList("cookies_cleanup_url_list");
        if (bh.cA(stringArrayList)) {
            x.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            return;
        }
        cp(stringArrayList);
        c.iO(ac.getContext());
        c.sync();
        x.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
    }

    private static void cp(List<String> list) {
        com.tencent.xweb.b cIj = com.tencent.xweb.b.cIj();
        for (String str : list) {
            List list2;
            x.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", str);
            String cookie = cIj.getCookie(str);
            if (bh.ov(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!bh.ov(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            a(str, list2, cIj);
        }
    }

    private static void a(String str, List<String> list, com.tencent.xweb.b bVar) {
        if (!bh.cA(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            x.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", r2);
            x.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", str2);
            for (String str3 : list) {
                if (!bh.ov(str3)) {
                    bVar.setCookie(str, str3 + "=");
                    bVar.setCookie(str, str3 + "=;path=/");
                    if (!bh.ov(str2)) {
                        bVar.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
    }
}
